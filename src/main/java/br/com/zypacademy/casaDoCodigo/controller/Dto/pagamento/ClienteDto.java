package br.com.zypacademy.casaDoCodigo.controller.Dto.pagamento;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.zypacademy.casaDoCodigo.controller.Dto.EstadoDto;
import br.com.zypacademy.casaDoCodigo.model.Estado;
import br.com.zypacademy.casaDoCodigo.model.Pais;
import br.com.zypacademy.casaDoCodigo.model.pagamento.Cliente;

public class ClienteDto {
	
	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	private Pais pais;
	private Estado estado;
	private Integer telefone;
	private Integer cep;

	public ClienteDto() {}
	
	public ClienteDto(Cliente cliente) {
		super();
		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.documento = cliente.getDocumento();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.pais = cliente.getPais();
		System.err.println(cliente.getPais());
		this.estado = cliente.getEstado();
		System.err.println(cliente.getEstado());
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
	}

	public static List<ClienteDto> toModel(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto:: new).collect(Collectors.toList());
		
	}

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

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public Integer getCep() {
		return cep;
	}
	
	

}
