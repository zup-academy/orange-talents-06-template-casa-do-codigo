package br.com.zypacademy.casaDoCodigo.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zypacademy.casaDoCodigo.controller.validator.ValorUnico;
import br.com.zypacademy.casaDoCodigo.model.Categoria;

public class CategoriaRequest {
	@NotNull @NotEmpty
	@ValorUnico(domainClass = Categoria.class, message = "A descrição da categoria deve ser única", fieldName= "nome" )
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public Categoria converter() {
		return new Categoria(nome);
	}
}
