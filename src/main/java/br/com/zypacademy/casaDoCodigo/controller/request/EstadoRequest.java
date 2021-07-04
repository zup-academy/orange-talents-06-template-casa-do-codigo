package br.com.zypacademy.casaDoCodigo.controller.request;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zypacademy.casaDoCodigo.controller.validator.ExistsId;
import br.com.zypacademy.casaDoCodigo.controller.validator.ValorUnico;
import br.com.zypacademy.casaDoCodigo.model.Estado;
import br.com.zypacademy.casaDoCodigo.model.Pais;
import br.com.zypacademy.casaDoCodigo.repository.PaisRepository;

public class EstadoRequest {
	@NotBlank
	@ValorUnico(domainClass = Estado.class, fieldName = "nome", message = "Nome do estado deve ser único")
	private String nome;
	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "codigo", message = "País deve ser previamente cadastrado")
	private Long paisCodigo;
	
	public EstadoRequest(
			@NotBlank @ValorUnico(domainClass = Estado.class, fieldName = "nome", message = "Nome do estado deve ser único") String nome,
			@NotBlank @ExistsId(domainClass = Estado.class, fieldName = "país", message = "País deve ser previamente cadastrado") Long paisCodigo) {
		this.nome = nome;
		this.paisCodigo = paisCodigo;
	}
	
	public Estado toModel(PaisRepository paisRepository) {
		return new Estado(this.nome, recuperaPais(paisRepository));
	}
	
	public Pais recuperaPais(PaisRepository paisRepository) {
		Optional<Pais> paisRecuperado = paisRepository.findById(this.paisCodigo);
		System.err.println(paisRecuperado);
		Pais pais = paisRecuperado.get();
		return pais;

	}
	
	
}
