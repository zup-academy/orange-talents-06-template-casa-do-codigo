package br.com.zypacademy.casaDoCodigo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zypacademy.casaDoCodigo.controller.Dto.AutorDto;
import br.com.zypacademy.casaDoCodigo.controller.form.AutorForm;
import br.com.zypacademy.casaDoCodigo.model.Autor;
import br.com.zypacademy.casaDoCodigo.repository.AutorRepository;

@RestController
@RequestMapping("autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;

	@GetMapping
	public List<AutorDto> lista(){
		return AutorDto.converter(autorRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, 
			UriComponentsBuilder uriBuilder) {
		Autor autor = form.converter();
		autorRepository.save(autor);
		
		URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(autor));
	}
	
	
}
