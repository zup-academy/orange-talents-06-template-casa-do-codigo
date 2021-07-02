package br.com.zypacademy.casaDoCodigo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zypacademy.casaDoCodigo.controller.validator.ValorUnico;
import br.com.zypacademy.casaDoCodigo.model.Categoria;

public class CategoriaForm {
	@NotNull @NotEmpty
	@ValorUnico(domainClass = CategoriaForm.class, message = "A descrição da categoria deve ser única")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public Categoria converter() {
		return new Categoria(nome);
	}
}
