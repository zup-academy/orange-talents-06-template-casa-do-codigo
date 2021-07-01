package br.com.zypacademy.casaDoCodigo.controller.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zypacademy.casaDoCodigo.controller.form.AutorForm;
import br.com.zypacademy.casaDoCodigo.model.Autor;
import br.com.zypacademy.casaDoCodigo.repository.AutorRepository;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorForm form = (AutorForm) target;
		Optional<Autor> autorPossivel =  autorRepository.findByEmail(form.getEmail());
		if(autorPossivel.isPresent()) {
			errors.rejectValue("email", null, "Já existe outro autor(a) com o mesmo email.");
		}
	}

}
