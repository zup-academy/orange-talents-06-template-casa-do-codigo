package br.com.zypacademy.casaDoCodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zypacademy.casaDoCodigo.model.Autor;

public class AutorForm {
	
	@NotNull @NotEmpty
	@Size(min=3, max=50)
	private String nome;
	@NotNull @NotEmpty @Email
	@Size(min=3, max=50)
	private String email;
	@NotNull @NotEmpty
	@Size(min=3, max=400)
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Autor converter() {
		return new Autor(nome, email, descricao);
	}
	
}
