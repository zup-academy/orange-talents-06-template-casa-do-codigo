package br.com.zypacademy.casaDoCodigo.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zypacademy.casaDoCodigo.controller.Dto.CategoriaDto;
import br.com.zypacademy.casaDoCodigo.controller.form.CategoriaForm;
import br.com.zypacademy.casaDoCodigo.model.Categoria;
import br.com.zypacademy.casaDoCodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<CategoriaDto> listar() {
		return CategoriaDto.converter(categoriaRepository.findAll()); 
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDto> criar(@RequestBody @Valid CategoriaForm form, HttpServletResponse response) {
		Categoria categoria = form.converter();
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
			.buildAndExpand(categoriaSalva.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(new CategoriaDto(categoriaSalva));
		
	}

}
