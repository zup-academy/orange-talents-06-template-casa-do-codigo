package br.com.zypacademy.casaDoCodigo.controller.Dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zypacademy.casaDoCodigo.model.Categoria;

public class CategoriaDto {
	
	private String nome;
			
	public String getNome() {
		return nome;
	}
	
	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
	}
	
	public static List<CategoriaDto> converter(List<Categoria> categorias) {
		return categorias.stream().map(CategoriaDto:: new).collect(Collectors.toList());
	}

}
