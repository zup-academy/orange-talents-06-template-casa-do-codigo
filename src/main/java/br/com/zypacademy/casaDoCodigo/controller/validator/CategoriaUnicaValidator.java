package br.com.zypacademy.casaDoCodigo.controller.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zypacademy.casaDoCodigo.controller.form.AutorForm;
import br.com.zypacademy.casaDoCodigo.controller.form.CategoriaForm;
import br.com.zypacademy.casaDoCodigo.model.Autor;
import br.com.zypacademy.casaDoCodigo.model.Categoria;
import br.com.zypacademy.casaDoCodigo.repository.CategoriaRepository;

public class CategoriaUnicaValidator implements ConstraintValidator<CategoriaUnica, String> {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void initialize(CategoriaUnica constraintAnnotation) {
		// TODO Auto-generated method stub
		ConstraintValidator.super.initialize(constraintAnnotation);
	}


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Optional<Categoria> categoriaInvestigada = categoriaRepository.findByNome(value);
		if(categoriaInvestigada.isPresent()) {
			return false;
		}
		System.out.println(value);
		return true;
	}


}
