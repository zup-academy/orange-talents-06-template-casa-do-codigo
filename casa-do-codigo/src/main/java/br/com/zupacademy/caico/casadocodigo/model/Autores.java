package br.com.zupacademy.caico.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;

@Entity
public class Autores {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotFound
	@NotEmpty
	private String nome;
	
	@NotNull
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@NotEmpty
	@Length(max = 400)
	private String descricao;
	
	@CreationTimestamp
	private LocalDateTime dataCriacao;
	
	@Deprecated
	public Autores() {
		
	}
	
	public Autores(
			@NotEmpty @NotNull String nome, 
			@Email @NotNull String email, 
			@Length(max = 400) @NotNull String descricao) {
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}		
	
	
}
