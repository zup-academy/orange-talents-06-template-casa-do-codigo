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

import br.com.zypacademy.casaDoCodigo.controller.Dto.EstadoDto;
import br.com.zypacademy.casaDoCodigo.controller.request.EstadoRequest;
import br.com.zypacademy.casaDoCodigo.model.Estado;
import br.com.zypacademy.casaDoCodigo.repository.EstadoRepository;
import br.com.zypacademy.casaDoCodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@GetMapping
	public List<EstadoDto> listar() {
		return EstadoDto.toModel(estadoRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<EstadoDto> criar(@RequestBody @Valid EstadoRequest request, HttpServletResponse response) {
		Estado estado = request.toModel(paisRepository);
		Estado estadoSalvo = estadoRepository.save(estado);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(estadoSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(new EstadoDto(estadoSalvo));

	}

	@GetMapping("/{id}")
	public ResponseEntity<EstadoDto> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Estado> estado = this.estadoRepository.findById(id);
		EstadoDto estadoDto = new EstadoDto(estado.get());
		return estado.isPresent() ? ResponseEntity.ok(estadoDto) : ResponseEntity.notFound().build();
	}
}
