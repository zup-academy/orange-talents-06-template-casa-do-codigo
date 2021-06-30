package br.com.zupacademy.caico.casadocodigo.categorias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @NotEmpty
	private String nome;
	
	@Deprecated
	public Categorias() {
		
	}
		
	public Categorias(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
