package br.com.zupacademy.caico.casadocodigo.estados;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.caico.casadocodigo.exception.Exceptions;
import br.com.zupacademy.caico.casadocodigo.paises.Paises;
import br.com.zupacademy.caico.casadocodigo.validators.NaoCadastrado;

public class EstadoFormDTO {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NaoCadastrado(domainClass = Paises.class, fieldName = "id", message = "País não cadastrado no sistema!")
	private Long pais_id;

	public EstadoFormDTO(@NotNull @NotEmpty String nome, @NotEmpty Long pais_id) {
		this.nome = nome;
		this.pais_id = pais_id;
	}

	public String getNome() {
		return nome;
	}

	public Long getPais_id() {
		return pais_id;
	}

	public EstadoRespDTO cadastrar(
			EstadoFormDTO estadoFormDTO, 
			EstadoRepository estadoRepository,
			EntityManager entityManager) throws Exception {
		
		Estados estadoExistente = estadoRepository.findByNomeAndPaisId(estadoFormDTO.getNome(), estadoFormDTO.getPais_id());
		

		if (estadoExistente != null) {
			throw new Exceptions("Estado já cadastro para este país.");
		}		
		
		
		Paises pais = entityManager.find(Paises.class, estadoFormDTO.getPais_id());
		
		Estados estado = new Estados(estadoFormDTO.getNome(), pais);
		
		estadoRepository.save(estado);

		EstadoRespDTO estadoRespDTO = new EstadoRespDTO(estado.getNome(), estado.getPais().getNome());
		return estadoRespDTO;
	}
	
}
