package br.com.zupacademy.caico.casadocodigo.livros;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public LivroRespDTO cadastrar(@RequestBody @Valid LivroFormDTO livroFormDTO) {		
		LivroRespDTO livro = livroFormDTO.cadastrar(livroFormDTO,entityManager);
		return livro;		
	}
}
