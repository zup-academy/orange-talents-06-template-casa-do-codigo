package br.com.zupacademy.caico.casadocodigo.estados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.caico.casadocodigo.paises.Paises;

@Entity
public class Estados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @ManyToOne
	private Paises pais;

	@Deprecated
	public Estados() {
		
	}
	
	public Estados(@NotNull @NotEmpty String nome, @NotNull Paises pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Paises getPais() {
		return pais;
	}
}
