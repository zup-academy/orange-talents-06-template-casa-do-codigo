package br.com.zupacademy.caico.casadocodigo.validators;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.caico.casadocodigo.dto.CategoriaFormDTO;
import br.com.zupacademy.caico.casadocodigo.model.Categorias;
import br.com.zupacademy.caico.casadocodigo.repository.CategoriaRepository;

@Component
public class ValidaNomeRepetidoCategoria implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaFormDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		
		CategoriaFormDTO categoriaRequest = (CategoriaFormDTO) target;
		
		Optional<Categorias> categoriaCadastrada = categoriaRepository.findByNome(categoriaRequest.getNome());
		
		if (categoriaCadastrada.isPresent()) {
			errors.rejectValue("nome", null, 
						"Já existe uma categoria cadastrada com o mesmo nome! "
						+ categoriaRequest.getNome());
		}
	}

}
