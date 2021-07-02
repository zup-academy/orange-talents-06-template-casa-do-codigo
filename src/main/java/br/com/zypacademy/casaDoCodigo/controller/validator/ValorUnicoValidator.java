package br.com.zypacademy.casaDoCodigo.controller.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zypacademy.casaDoCodigo.model.Autor;
import br.com.zypacademy.casaDoCodigo.model.Categoria;
import br.com.zypacademy.casaDoCodigo.repository.AutorRepository;
import br.com.zypacademy.casaDoCodigo.repository.CategoriaRepository;

public class ValorUnicoValidator implements ConstraintValidator<ValorUnico, String> {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private AutorRepository autorRepository;

	private Class<?> classe;

	@Override
	public void initialize(ValorUnico constraintAnnotation) {
		classe = constraintAnnotation.domainClass();

		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<Categoria> categoriaInvestigada = categoriaRepository.findByNome(value);
		if (categoriaInvestigada.isPresent()) {
			return false;
		}
		Optional<Autor> autorInvestigada = autorRepository.findByEmail(value);
		if (autorInvestigada.isPresent()) {
			return false;
		}

		return true;
	}

}
