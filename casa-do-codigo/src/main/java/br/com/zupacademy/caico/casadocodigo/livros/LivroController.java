package br.com.zupacademy.caico.casadocodigo.livros;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@PostMapping
	public LivroRespDTO cadastrar(@RequestBody @Valid LivroFormDTO livroFormDTO) {		
		LivroRespDTO livro = livroFormDTO.cadastrar(
				livroFormDTO,
				entityManager);
		return livro;		
	}
	
	@GetMapping 
	public Page<ListaLivros> listarLivros(@PageableDefault(size = 3) Pageable paginacao) {
		Page<Livros> livros = livroRepository.findAll(paginacao);
		List<ListaLivros> listaLivros = new ArrayList<>();
		
		for (Livros lista : livros) {
			ListaLivros itemLivro = new ListaLivros();
			itemLivro.setId(lista.getId());
			itemLivro.setNome(lista.getTitulo());
			listaLivros.add(itemLivro);
		}
		
		Page<ListaLivros> livrosCadastrados = new PageImpl<>(listaLivros);
		return livrosCadastrados;
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<LivroDetalhe> detalhamentoLivro(@PathVariable Long id){
		
		Livros livro = entityManager.find(Livros.class, id);

		if (livro == null) {
			return ResponseEntity.notFound().build();
		}
		
		LivroDetalhe livroDetalhe = new LivroDetalhe(livro);
		
		return ResponseEntity.ok().body(livroDetalhe);
		
	}
}
