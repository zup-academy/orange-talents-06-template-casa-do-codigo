package br.com.zypacademy.casaDoCodigo.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zypacademy.casaDoCodigo.controller.validator.ValorUnico;
import br.com.zypacademy.casaDoCodigo.model.Autor;

public class AutorRequest {

	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nome;
	
	@NotNull
	@NotEmpty
	@Email
	@Size(min = 3, max = 50)
	@ValorUnico(domainClass = Autor.class, message = "Valor do email deve ser único", fieldName = "email")
	private String email;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 400)
	private String descricao;

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

	

}
