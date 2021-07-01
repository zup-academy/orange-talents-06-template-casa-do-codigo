package br.com.zypacademy.casaDoCodigo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zypacademy.casaDoCodigo.controller.validator.CategoriaUnica;
import br.com.zypacademy.casaDoCodigo.model.Categoria;

public class CategoriaForm {
	@NotNull @NotEmpty
	@CategoriaUnica
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public Categoria converter() {
		return new Categoria(nome);
	}
}
