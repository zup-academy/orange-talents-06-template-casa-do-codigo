package br.com.zypacademy.casaDoCodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "codigo_pais")
	private Pais pais;
	
	public Estado() {}

	public Estado(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Pais getPais() {
		return pais;
	}

	public Long getCodigo() {
		return codigo;
	
	}

}
