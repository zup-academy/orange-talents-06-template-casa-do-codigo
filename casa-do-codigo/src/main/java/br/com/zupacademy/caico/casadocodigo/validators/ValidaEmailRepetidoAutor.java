package br.com.zupacademy.caico.casadocodigo.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.caico.casadocodigo.dto.AutoresFormDTO;
import br.com.zupacademy.caico.casadocodigo.model.Autores;
import br.com.zupacademy.caico.casadocodigo.repository.AutoresRepository;

@Component
public class ValidaEmailRepetidoAutor implements Validator{

	@Autowired
	private AutoresRepository autoresRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutoresFormDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		AutoresFormDTO autorRequest = (AutoresFormDTO) target;
		
		Optional<Autores> autorCadastrado = autoresRepository.findByEmail(autorRequest.getEmail());
		
		if (autorCadastrado.isPresent()) {
			errors.rejectValue("email", null, 
						"Já existe um autor(a) cadastrado com o mesmo e-mail! "
						+ autorRequest.getEmail());
		}
	}
	
	

}
