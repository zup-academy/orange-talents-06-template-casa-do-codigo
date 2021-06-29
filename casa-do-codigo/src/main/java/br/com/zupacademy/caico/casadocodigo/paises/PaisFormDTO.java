package br.com.zupacademy.caico.casadocodigo.paises;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.caico.casadocodigo.validators.UniqueValue;

public class PaisFormDTO {
	
	@NotNull @NotEmpty @UniqueValue(domainClass = Paises.class, fieldName = "nome", message = "Já existe um país cadastrado com esse nome!")
	private String nome;
	
	@Deprecated
	public PaisFormDTO() {
		
	}
	
	public PaisFormDTO(@NotNull @NotEmpty String nome) {
		this.nome = nome;
	}

	public PaisRespDTO cadastrar(PaisFormDTO paisFormDTO, EntityManager entityManager) {
		Paises pais = new Paises(paisFormDTO.getNome());
		entityManager.persist(pais);
		PaisRespDTO paisRespDTO = new PaisRespDTO(pais.getNome());
		return paisRespDTO;
	}
	
	public String getNome() {
		return nome;
	}
	
}
