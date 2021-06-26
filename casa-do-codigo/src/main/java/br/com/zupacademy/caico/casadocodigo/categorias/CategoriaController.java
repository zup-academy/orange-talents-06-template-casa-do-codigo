package br.com.zupacademy.caico.casadocodigo.categorias;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.caico.casadocodigo.validators.ValidaNomeRepetidoCategoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;	
	
	@Autowired
	private ValidaNomeRepetidoCategoria validaNomeRepetidoCategoria;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validaNomeRepetidoCategoria);
	}

	
	@PostMapping
	public CategoriaRespDTO cadastrar(@Valid @RequestBody CategoriaFormDTO categoriaFormDTO) {
		CategoriaRespDTO categoria = categoriaFormDTO.cadastrar(categoriaFormDTO, categoriaRepository);
		return categoria;
	}
}
