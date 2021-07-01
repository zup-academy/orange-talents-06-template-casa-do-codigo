package br.com.zupacademy.caico.casadocodigo.paises;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.caico.casadocodigo.validators.UniqueValue;

@Entity
public class Paises {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty @UniqueValue(domainClass = Paises.class, fieldName = "nome")
	private String nome;
	
	@Deprecated
	public Paises() {
		
	}
	
	public Paises(@NotNull @NotEmpty String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
