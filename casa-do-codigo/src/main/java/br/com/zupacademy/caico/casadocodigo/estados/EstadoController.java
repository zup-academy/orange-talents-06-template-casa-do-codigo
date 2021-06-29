package br.com.zupacademy.caico.casadocodigo.estados;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	public EstadoRespDTO cadastrar(@RequestBody @Valid EstadoFormDTO estadoFormDTO) throws Exception {
		EstadoRespDTO estadoRespDTO = estadoFormDTO.cadastrar(
				estadoFormDTO, 
				estadoRepository,
				entityManager);
		return estadoRespDTO;
	}
}
