package br.com.zupacademy.caico.casadocodigo.autores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.caico.casadocodigo.validators.ValidaEmailRepetidoAutor;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	private AutoresRepository autoresRepository;
	@Autowired
	private ValidaEmailRepetidoAutor validaEmailRepetido;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validaEmailRepetido);
	}
	
	@PostMapping
	public AutoresRespDTO cadastrar(@Valid @RequestBody AutoresFormDTO autoresFormDTO) {
		return autoresFormDTO.cadastrar(autoresFormDTO, autoresRepository);				
	}
}
