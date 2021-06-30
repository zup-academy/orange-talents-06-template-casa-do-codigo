package br.com.zupacademy.caico.casadocodigo.estados;

public class EstadoRespDTO {

	private String nome;
	private String pais;
	
	public EstadoRespDTO(String nome, String pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}
	
}
