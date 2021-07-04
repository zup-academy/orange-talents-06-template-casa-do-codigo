package br.com.zypacademy.casaDoCodigo.controller.Dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zypacademy.casaDoCodigo.model.Estado;
import br.com.zypacademy.casaDoCodigo.model.Pais;

public class EstadoDto {
	private String estado;
	private Pais pais;

	public EstadoDto() {}
	
	public EstadoDto(Estado estado) {
		this.estado = estado.getNome();
		this.pais = estado.getPais();
	}


	public static List<EstadoDto> toModel(List<Estado> estados) {
		return estados.stream().map(EstadoDto:: new).collect(Collectors.toList());
	}

	public String getEstado() {
		return estado;
	}

	public Pais getPais() {
		return pais;
	}
	
	

}
