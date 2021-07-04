package br.com.zypacademy.casaDoCodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;

	public Categoria() {

	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(Categoria categoria) {
		this.nome = categoria.getNome();
	}
	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

}
