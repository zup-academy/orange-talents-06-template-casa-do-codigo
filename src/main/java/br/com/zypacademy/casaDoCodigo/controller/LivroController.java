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

import br.com.zypacademy.casaDoCodigo.controller.Dto.LivroDto;
import br.com.zypacademy.casaDoCodigo.controller.request.LivroRequest;
import br.com.zypacademy.casaDoCodigo.model.Livro;
import br.com.zypacademy.casaDoCodigo.repository.AutorRepository;
import br.com.zypacademy.casaDoCodigo.repository.CategoriaRepository;
import br.com.zypacademy.casaDoCodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private AutorRepository autorRepository;

	
	@GetMapping
	public List<LivroDto> listar() {
		return LivroDto.converter(livroRepository.findAll()); 
	}
	
	@PostMapping
	public ResponseEntity<LivroDto> criar(@RequestBody @Valid LivroRequest request, HttpServletResponse response) {
		Livro livro = request.toModel(categoriaRepository, autorRepository);
		Livro livroSalvo = livroRepository.save(livro);
		System.out.println("oi");

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(livroSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(new LivroDto(livroSalvo));

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<LivroDto> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Livro> livro = this.livroRepository.findById(id);
		LivroDto livroDto = new LivroDto(livro.get());
		return livro.isPresent() ? 
				ResponseEntity.ok(livroDto) : ResponseEntity.notFound().build();
	}

}
