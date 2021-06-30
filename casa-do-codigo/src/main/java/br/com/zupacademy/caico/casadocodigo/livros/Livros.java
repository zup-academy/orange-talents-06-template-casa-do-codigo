package br.com.zupacademy.caico.casadocodigo.livros;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.caico.casadocodigo.autores.Autores;
import br.com.zupacademy.caico.casadocodigo.categorias.Categorias;

@Entity
public class Livros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @NotEmpty
	private String titulo;
	
	@NotNull @NotEmpty @Length(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull @Min(20)
	private double preco;
	
	@NotNull @Min(100)
	private Integer numeroPaginas;
	
	@NotNull @NotEmpty
	private String isbn;
	
	@NotNull
	private LocalDate dataPublicacao;
	
	@NotNull
	@ManyToOne
	private Categorias categorias;
	
	@NotNull
	@ManyToOne
	private Autores autores;
	
	@Deprecated
	public Livros() {
		
	}
	
	
	/**
	 * 
	 * @param titulo
	 * @param resumo
	 * @param sumario
	 * @param preco
	 * @param numeroPaginas
	 * @param isbn
	 * @param dataPublicacao
	 * @param categoria
	 * @param autor
	 */
	public Livros(@NotNull @NotEmpty String titulo, @NotNull @NotEmpty @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) double preco, @NotNull @Min(100) Integer numeroPaginas,
			@NotNull @NotEmpty String isbn, @NotNull LocalDate dataPublicacao,
			@NotNull Categorias categorias, @NotNull Autores autores) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categorias = categorias;
		this.autores = autores;
	}

	public Long getId() {
		return id;
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

	public Categorias getCategorias() {
		return categorias;
	}

	public Autores getAutores() {
		return autores;
	}	
	
	
}
