package br.com.zypacademy.casaDoCodigo.controller.pagamento;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zypacademy.casaDoCodigo.controller.Dto.EstadoDto;
import br.com.zypacademy.casaDoCodigo.controller.Dto.pagamento.ClienteDto;
import br.com.zypacademy.casaDoCodigo.controller.request.EstadoRequest;
import br.com.zypacademy.casaDoCodigo.controller.request.pagemento.ClienteRequest;
import br.com.zypacademy.casaDoCodigo.model.Estado;
import br.com.zypacademy.casaDoCodigo.model.Pais;
import br.com.zypacademy.casaDoCodigo.model.pagamento.Cliente;
import br.com.zypacademy.casaDoCodigo.repository.ClienteRepository;
import br.com.zypacademy.casaDoCodigo.repository.EstadoRepository;
import br.com.zypacademy.casaDoCodigo.repository.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@GetMapping
	public List<ClienteDto> listar() {
		return ClienteDto.toModel(clienteRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		ClienteDto clienteDto = new ClienteDto(cliente.get());
		return cliente.isPresent() ? ResponseEntity.ok(clienteDto) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ClienteDto> criar(@RequestBody @Valid ClienteRequest request, HttpServletResponse response) {
		Cliente cliente = request.toModel(paisRepository, estadoRepository);
		Cliente clienteSalvo = clienteRepository.save(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(clienteSalvo.getCodigo()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(new ClienteDto(clienteSalvo));

	}

}
