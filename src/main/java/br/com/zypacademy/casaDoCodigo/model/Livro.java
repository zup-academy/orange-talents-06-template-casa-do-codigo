package br.com.zypacademy.casaDoCodigo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer pagina;
	private String isbn;
	private LocalDateTime entrada;

	@ManyToOne
	@JoinColumn(name = "categoria_codigo")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "autor_codigo")
	private Autor autor;
	
	public Livro() {}
	

	public Livro(String titulo, String resumo, String sumario, BigDecimal preco, Integer pagina, String isbn,
			LocalDateTime entrada, Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.pagina = pagina;
		this.isbn = isbn;
		this.entrada = entrada;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	
	public Long getCodigo() {
		return codigo;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPagina() {
		return pagina;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public Autor getAutor() {
		return autor;
	}


	public Categoria getCategoria() {
		return categoria;
	}
}
