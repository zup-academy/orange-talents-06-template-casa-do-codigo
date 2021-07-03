package br.com.zypacademy.casaDoCodigo.controller.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zypacademy.casaDoCodigo.model.Autor;
import br.com.zypacademy.casaDoCodigo.model.Categoria;
import br.com.zypacademy.casaDoCodigo.model.Livro;

public class LivroDto {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer pagina;
	private String isbn;
	private LocalDateTime entrada;
	private Categoria categoria;
	private Autor autor;

	public LivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.pagina = livro.getPagina();
		this.isbn = livro.getIsbn();
		this.entrada = livro.getEntrada();
		this.categoria = livro.getCategoria();
		this.autor = livro.getAutor();
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

	public CategoriaDto getCategoria() {
		return new CategoriaDto(categoria);
	}

	public AutorDto getAutor() {
		return new AutorDto(autor);
	}

	/*
	 * public CategoriaDto getCategoriaDto() { Optional<Categoria> categoria =
	 * categoriaRepository.findById(this.categoria); System.out.println(categoria);
	 * return categoria; }
	 */

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}

}
