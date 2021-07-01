package br.com.zupacademy.caico.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import br.com.zupacademy.caico.casadocodigo.estados.Estados;
import br.com.zupacademy.caico.casadocodigo.paises.Paises;
import br.com.zupacademy.caico.casadocodigo.validators.Documento;
import br.com.zupacademy.caico.casadocodigo.validators.NaoCadastrado;
import br.com.zupacademy.caico.casadocodigo.validators.UniqueValue;

public class ClienteFormDTO {

	@NotBlank @UniqueValue(domainClass = Clientes.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@Documento
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull @NaoCadastrado(domainClass = Paises.class, fieldName = "id")
	private Long pais_id;
	
	private Long estado_id;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPais_id() {
		return pais_id;
	}

	public Long getEstado_id() {
		return estado_id;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public ClienteRespDTO cadastrar(
			@Valid ClienteFormDTO clienteFormDTO, 
			EntityManager entityManager,
			ClienteRepository clienteRepository) {

		Paises pais = entityManager.find(Paises.class, clienteFormDTO.getPais_id());
		Assert.state(pais != null, "País não cadastrado no sistema: " + clienteFormDTO.getPais_id());
		
		Estados estado = null;
		
		if (clienteFormDTO.estado_id != null) {
			estado = entityManager.find(Estados.class, clienteFormDTO.estado_id);
			Assert.state(estado != null, "Estado não cadastro no sistema: " + clienteFormDTO.estado_id);
		}
		
		
		
		Clientes cliente = new Clientes(
				clienteFormDTO.getEmail(),
				clienteFormDTO.getNome(),
				clienteFormDTO.getSobrenome(),
				clienteFormDTO.getDocumento(),
				clienteFormDTO.getEndereco(),
				clienteFormDTO.getComplemento(),
				clienteFormDTO.getCidade(),
				pais,
				estado,
				clienteFormDTO.getTelefone(),
				clienteFormDTO.getCep()
				);
		
		clienteRepository.save(cliente);
		
		ClienteRespDTO clienteRespDTO = new ClienteRespDTO(cliente.getId());
		return clienteRespDTO;
	}
	
	public boolean documentoValido() {
		Assert.hasLength(documento,
				"você nao deveria validar o documento se ele não tiver sido preenchido");

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		return cpfValidator.isValid(documento, null)
				|| cnpjValidator.isValid(documento, null);
	}
	
}
