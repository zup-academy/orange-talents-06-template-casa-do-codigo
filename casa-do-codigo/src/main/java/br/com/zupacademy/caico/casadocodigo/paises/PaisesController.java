package br.com.zupacademy.caico.casadocodigo.paises;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisesController {
	
	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping
	@Transactional
	public PaisRespDTO cadastrar(@RequestBody @Valid PaisFormDTO paisFormDTO) {
		PaisRespDTO paisRespDTO = paisFormDTO.cadastrar(paisFormDTO, entityManager);
		
		return paisRespDTO;
	}
}
