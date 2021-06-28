package br.com.zupacademy.caico.casadocodigo.validators;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class NaoCadastradoValidator implements ConstraintValidator<NaoCadastrado, Object>{

	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(NaoCadastrado params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		
		Query query = manager.createQuery("select l from " + klass.getName() + 
				" l where " + domainAttribute + " = :value");
		
		query.setParameter("value", value);
		
		List<?> list = query.getResultList();
		
		Assert.isTrue(list.size() <= 1, "Não foi encontrado nenhum " + klass
				+" com o atributo " + domainAttribute+ " = " + value);
		
		return !list.isEmpty();

	}

}
