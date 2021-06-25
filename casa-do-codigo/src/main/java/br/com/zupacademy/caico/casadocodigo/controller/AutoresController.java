package br.com.zupacademy.caico.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.caico.casadocodigo.dto.AutoresFormDTO;
import br.com.zupacademy.caico.casadocodigo.dto.AutoresRespDTO;
import br.com.zupacademy.caico.casadocodigo.repository.AutoresRepository;

@RestController
@RequestMapping("/autores")
public class AutoresController {

	@Autowired
	private AutoresRepository autoresRepository;
	
	@PostMapping
	public AutoresRespDTO cadastrar(@Valid @RequestBody AutoresFormDTO autoresFormDTO) {
		return autoresFormDTO.cadastrar(autoresFormDTO, autoresRepository);				
	}
}
