package br.com.zypacademy.casaDoCodigo.controller.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zypacademy.casaDoCodigo.controller.validator.ExistsId;
import br.com.zypacademy.casaDoCodigo.controller.validator.ValorUnico;
import br.com.zypacademy.casaDoCodigo.model.Autor;
import br.com.zypacademy.casaDoCodigo.model.Categoria;
import br.com.zypacademy.casaDoCodigo.model.Estado;
import br.com.zypacademy.casaDoCodigo.model.Livro;
import br.com.zypacademy.casaDoCodigo.repository.AutorRepository;
import br.com.zypacademy.casaDoCodigo.repository.CategoriaRepository;
import br.com.zypacademy.casaDoCodigo.repository.PaisRepository;

public class LivroRequest {

	@NotBlank
	@ValorUnico(domainClass = Livro.class, message = "Título deve ser único", fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@Size(min = 3)
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@NotNull
	@Min(100)
	private Integer pagina;

	@NotBlank
	@ValorUnico(domainClass = Livro.class, message = "ISBN deve ser único", fieldName = "isbn")
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDateTime entrada;
	@NotNull
	@ExistsId(domainClass = Categoria.class, message = "Código da categoria deve existir", fieldName = "codigo")
	private Long codigoCategoria;
	@NotNull
	@ExistsId(domainClass = Autor.class, message = "Código do autor deve existir", fieldName = "codigo")
	private Long codigoAutor;

	public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@Size(min = 3) String sumario, @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer pagina,
			@NotBlank String isbn, @Future LocalDateTime entrada, @NotNull Long codigoCategoria,
			@NotNull Long codigoAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.pagina = pagina;
		this.isbn = isbn;
		this.entrada = entrada;
		this.codigoCategoria = codigoCategoria;
		this.codigoAutor = codigoAutor;
	}

	public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		System.err.println("aqui");
		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.pagina, this.isbn, this.entrada,
				recuperaCategoria(categoriaRepository), recuperaAutor(autorRepository));
	}

	public Categoria recuperaCategoria(CategoriaRepository categoriaRepository) {
		Optional<Categoria> categoriaRecuperada = categoriaRepository.findById(this.codigoCategoria);
		System.err.println(categoriaRecuperada);
		Categoria categoria = categoriaRecuperada.get();
		return categoria;

	}

	public Autor recuperaAutor(AutorRepository autorRepository) {
		Optional<Autor> atorRecuperada = autorRepository.findById(this.codigoAutor);
		System.err.println(atorRecuperada);
		Autor autor = atorRecuperada.get();
		return autor;
	}

	
}
