package br.com.zypacademy.casaDoCodigo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pais {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	@OneToMany(mappedBy = "pais") 
	private List<Estado> estados;
	
	
	public Pais() {}

	public Pais(String nome) {
		this.nome = nome;
	}

		
	public Pais(String nome, List<Estado> estados) {
		super();
		this.nome = nome;
		this.estados = estados;
	}

	public String getNome() {
		return nome;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	
}
