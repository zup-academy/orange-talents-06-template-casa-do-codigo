package br.com.zupacademy.caico.casadocodigo.autores;

public class DetalhesLivrosAutorDTO {

	private String nome;
	private String descricao;
	
	public DetalhesLivrosAutorDTO(Autores autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
