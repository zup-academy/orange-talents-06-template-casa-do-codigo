package br.com.zupacademy.caico.casadocodigo.dto;

public class CategoriaRespDTO {

	private String nome;
	
	@Deprecated
	public CategoriaRespDTO() {
		
	}
	
	public CategoriaRespDTO(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
