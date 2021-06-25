package br.com.zupacademy.caico.casadocodigo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.caico.casadocodigo.model.Categorias;
import br.com.zupacademy.caico.casadocodigo.repository.CategoriaRepository;

public class CategoriaFormDTO {

	@NotNull @NotEmpty
	private String nome;
	
	@Deprecated
	public CategoriaFormDTO() {
		
	}
	
	public CategoriaFormDTO(@NotNull @NotEmpty String nome) {
		this.nome = nome;
		
	}
	
	public CategoriaRespDTO cadastrar(CategoriaFormDTO categoriaFormDTO, CategoriaRepository categoriaRepository) {
		Categorias categoria = new Categorias(categoriaFormDTO.getNome());	
		categoriaRepository.save(categoria);
		CategoriaRespDTO categoriaRespDTO = new CategoriaRespDTO(categoria.getNome());
		return categoriaRespDTO;
	}

	public String getNome() {
		return nome;
	}	
	
	
}
