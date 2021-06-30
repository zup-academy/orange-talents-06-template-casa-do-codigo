package br.com.zupacademy.caico.casadocodigo.livros;

import java.time.format.DateTimeFormatter;

import br.com.zupacademy.caico.casadocodigo.autores.DetalhesLivrosAutorDTO;
import br.com.zupacademy.caico.casadocodigo.categorias.CategoriaRespDTO;

public class LivroDetalhe {

	private String titulo;	
	private String resumo;
	private String sumario;
	private double preco;
	private Integer numeroPaginas;
	private String isbn;
	private String dataPublicacao;
	private CategoriaRespDTO categorias;
	private DetalhesLivrosAutorDTO autor;
	
	public LivroDetalhe(Livros livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao()
						.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.categorias = new CategoriaRespDTO(livro.getCategorias().getNome());
		this.autor = new DetalhesLivrosAutorDTO(livro.getAutores());
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

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public CategoriaRespDTO getCategorias() {
		return categorias;
	}

	public DetalhesLivrosAutorDTO getAutor() {
		return autor;
	}
	
}
