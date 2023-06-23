package com.projeto.casadocodigo.service.genericValidator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;

import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager mananger;
    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Query query = mananger.createQuery("select 1 from " +klass.getName()+ " where " + domainAttribute + "=:object");
        query.setParameter("object", object);
        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <=1, "Encontrado mais de um "+klass+" com o atributo "+domainAttribute+" = "+ object);
        return list.isEmpty();
    }
}
