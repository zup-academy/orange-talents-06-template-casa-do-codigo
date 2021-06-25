package br.com.zupacademy.caico.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.zupacademy.caico.casadocodigo.model.Autores;
import br.com.zupacademy.caico.casadocodigo.repository.AutoresRepository;

public class AutoresFormDTO {
	
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

	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getDescricao() {
		return descricao;
	}

	
	/**
	 * Converte os dados para a classe Autores, e realiza a inserção no banco de dados.
	 * @param autores
	 * @param autoresRepository
	 * @return Retorna um DTO de resposta.
	 */
	
	public AutoresRespDTO cadastrar(AutoresFormDTO autores, AutoresRepository autoresRepository) {
		Autores autor = new Autores(autores.getNome(), autores.getEmail(), autores.getDescricao());
		autoresRepository.save(autor);		
		AutoresRespDTO autoresRespDTO = new AutoresRespDTO(autor);
		return autoresRespDTO;
	}
	

}
