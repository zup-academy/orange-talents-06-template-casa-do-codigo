package br.com.zypacademy.casaDoCodigo.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zypacademy.casaDoCodigo.controller.validator.ValorUnico;
import br.com.zypacademy.casaDoCodigo.model.Pais;

public class PaisRequest {
	@NotNull @NotEmpty
	@ValorUnico(domainClass = Pais.class, message = "A descrição do pais deve ser único", fieldName= "nome" )
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public Pais converter() {
		return new Pais(nome);
	}
}
