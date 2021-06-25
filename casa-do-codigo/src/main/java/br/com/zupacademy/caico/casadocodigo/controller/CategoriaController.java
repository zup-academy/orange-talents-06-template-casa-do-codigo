package br.com.zupacademy.caico.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.caico.casadocodigo.dto.CategoriaFormDTO;
import br.com.zupacademy.caico.casadocodigo.dto.CategoriaRespDTO;
import br.com.zupacademy.caico.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public CategoriaRespDTO cadastrar(@Valid @RequestBody CategoriaFormDTO categoriaFormDTO) {
		CategoriaRespDTO categoria = categoriaFormDTO.cadastrar(categoriaFormDTO, categoriaRepository);
		return categoria;
	}
}
