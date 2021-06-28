package br.com.zupacademy.caico.casadocodigo.livros;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class LivroRespDTO {

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
	
	private LocalDate dataPublicacao;
	
	@NotNull @NotEmpty
	private String categoria;
	
	@NotNull @NotEmpty
	private String autor;

	public LivroRespDTO(@NotNull @NotEmpty String titulo, @NotNull @NotEmpty @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) double preco, @NotNull @Min(100) Integer numeroPaginas,
			@NotNull @NotEmpty String isbn, @NotNull LocalDate dataPublicacao,
			@NotNull @NotEmpty String categoria, @NotNull @NotEmpty String autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
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

	public String getCategoria() {
		return categoria;
	}

	public String getAutor() {
		return autor;
	}	
	
}
