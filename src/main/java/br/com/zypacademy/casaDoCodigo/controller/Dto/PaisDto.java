package br.com.zypacademy.casaDoCodigo.controller.Dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zypacademy.casaDoCodigo.model.Pais;

public class PaisDto {
	private String pais;
		
	public PaisDto() {}
	
	public PaisDto(Pais pais) {
		this.pais = pais.getNome();
	}

	public static List<PaisDto> toModel(List<Pais> paises) {
		 
		return paises.stream().map(PaisDto::new).collect(Collectors.toList());
	}
	
	public String getPais() {
		return pais;
	}
}
