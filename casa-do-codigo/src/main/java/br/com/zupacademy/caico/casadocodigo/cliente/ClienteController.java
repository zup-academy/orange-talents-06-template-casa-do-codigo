package br.com.zupacademy.caico.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping
	@Transactional
	public ClienteRespDTO cadastrar(@RequestBody @Valid ClienteFormDTO clienteFormDTO) {
		
		ClienteRespDTO clienteRespDTO = clienteFormDTO.cadastrar(
											clienteFormDTO, 
											entityManager,
											clienteRepository);		
		return clienteRespDTO;
		
	}
}
