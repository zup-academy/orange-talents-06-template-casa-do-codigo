package br.com.zypacademy.casaDoCodigo.controller.validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, Object> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<?> classe;
	private String dominio;

	@Override
	public void initialize(ValorUnico constraintAnnotation) {
		dominio = constraintAnnotation.fieldName();
		classe = constraintAnnotation.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery("select 1 from " + classe.getName() + " where " + dominio + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.isTrue(list.size() <= 1,
				"Foi encontrado mais de um " + classe + " com o atributo " + dominio + " = " + value);
		return list.isEmpty();
	}

}
