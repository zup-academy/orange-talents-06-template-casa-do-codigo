package br.com.zupacademy.caico.casadocodigo.autores;

import java.time.LocalDateTime;

public class AutoresRespDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataCriacao;
	
	public AutoresRespDTO(Autores autores) {
		this.id = autores.getId();
		this.nome = autores.getNome();
		this.email = autores.getEmail();
		this.descricao = autores.getDescricao();
		this.dataCriacao = autores.getDataCriacao();
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
