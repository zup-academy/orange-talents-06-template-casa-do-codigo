package br.com.zupacademy.caico.casadocodigo.livros;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.caico.casadocodigo.autores.Autores;
import br.com.zupacademy.caico.casadocodigo.categorias.Categorias;
import br.com.zupacademy.caico.casadocodigo.validators.NaoCadastrado;
import br.com.zupacademy.caico.casadocodigo.validators.UniqueValue;

public class LivroFormDTO {
	
	@NotNull @NotEmpty @UniqueValue(domainClass = Livros.class, fieldName = "titulo")
	private String titulo;
	
	@NotNull @NotEmpty @Length(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @Min(20)
	private double preco;
	
	@NotNull @Min(100)
	private Integer numeroPaginas;
	
	@NotNull @NotEmpty @UniqueValue(domainClass = Livros.class, fieldName = "isbn", message = "ISBN já cadastrado")
	private String isbn;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	@NotNull
	@NaoCadastrado(domainClass = Categorias.class, fieldName = "id", message = "É necessário informar uma categoria válida")
	private Long categoria_id;
	
	@NotNull
	@NaoCadastrado(domainClass = Autores.class, fieldName = "id", message = "Autor não cadastro no sistema")
	private Long autor_id;

	public LivroFormDTO(@NotNull @NotEmpty String titulo, @NotNull @NotEmpty @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) double preco, @NotNull @Min(100) Integer numeroPaginas,
			@NotNull @NotEmpty String isbn,
			@NotNull Long categoria_id, @NotNull Long autor_id) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.categoria_id = categoria_id;
		this.autor_id = autor_id;
	}

	public LivroRespDTO cadastrar(LivroFormDTO livroFormDTO, EntityManager entityManager) {
		
		Categorias categoria = entityManager.find(Categorias.class, categoria_id);
		Autores autor = entityManager.find(Autores.class, autor_id);
		
		Assert.state(categoria != null, "É necessário informar uma categoria válida");
		Assert.state(autor != null, "É necessário informar um(a) autor(a) válida");
		
		Livros livro = new Livros(
				livroFormDTO.getTitulo(),
				livroFormDTO.getResumo(),
				livroFormDTO.getSumario(),
				livroFormDTO.getPreco(),
				livroFormDTO.getNumeroPaginas(),
				livroFormDTO.getIsbn(),
				livroFormDTO.getDataPublicacao(),	
				categoria,
				autor
				);	
		
		entityManager.persist(livro);
		
		LivroRespDTO livroRespDTO = new LivroRespDTO(
				livro.getTitulo(),
				livro.getResumo(),
				livro.getSumario(),
				livro.getPreco(),
				livro.getNumeroPaginas(),
				livro.getIsbn(),
				livro.getDataPublicacao(),
				livro.getCategorias().getNome(),
				livro.getAutores().getNome()				
				);	
		
		return livroRespDTO;
	}	
	
	
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public double getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public Long getAutor_id() {
		return autor_id;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}		

}
