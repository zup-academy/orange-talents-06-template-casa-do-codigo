package br.com.zypacademy.casaDoCodigo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zypacademy.casaDoCodigo.controller.Dto.PaisDto;
import br.com.zypacademy.casaDoCodigo.controller.request.PaisRequest;
import br.com.zypacademy.casaDoCodigo.model.Pais;
import br.com.zypacademy.casaDoCodigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping
	public List<PaisDto> listar() {
		return PaisDto.toModel(paisRepository.findAll()); 
	}
	
	@PostMapping
	public ResponseEntity<PaisDto> criar(@RequestBody @Valid PaisRequest request, HttpServletResponse response) {
		Pais pais = request.converter();
		Pais paisSalvo = paisRepository.save(pais);
		System.out.println("oi");

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(paisSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(new PaisDto(paisSalvo));

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PaisDto> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Pais> pais = this.paisRepository.findById(id);
		PaisDto paisDto = new PaisDto(pais.get());
		return pais.isPresent() ? 
				ResponseEntity.ok(paisDto) : ResponseEntity.notFound().build();
	}
	
}
