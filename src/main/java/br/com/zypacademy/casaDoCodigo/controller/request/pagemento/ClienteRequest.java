package br.com.zypacademy.casaDoCodigo.controller.request.pagemento;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zypacademy.casaDoCodigo.controller.validator.ValorUnico;
import br.com.zypacademy.casaDoCodigo.model.Estado;
import br.com.zypacademy.casaDoCodigo.model.Pais;
import br.com.zypacademy.casaDoCodigo.model.pagamento.Cliente;
import br.com.zypacademy.casaDoCodigo.repository.EstadoRepository;
import br.com.zypacademy.casaDoCodigo.repository.PaisRepository;

public class ClienteRequest {
	@Email
	@NotBlank
	@ValorUnico(domainClass = Cliente.class, fieldName = "email", message = "Email deve ser único e não pode ser vazio")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotEmpty
	@NotNull
	@Length(min = 11, max = 14)
	// @ValidaTamnho
	private String documento;
	@NotEmpty
	@NotNull
	private String endereco;
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String nomePais;
	@NotBlank
	private String nomeEstado;
	@NotNull
	private Integer telefone;
	@NotNull
	private Integer cep;

	private Pais pais;

	public ClienteRequest(
			@Email @NotNull @NotEmpty @ValorUnico(domainClass = Cliente.class, fieldName = "email", message = "Email deve ser único e não pode ser vazio") String email,
			@NotEmpty @NotNull String nome, @NotEmpty @NotNull String sobrenome,
			@NotEmpty @NotNull @Size(min = 11, max = 14) String documento, @NotEmpty @NotNull String endereco,
			String complemento, @NotEmpty @NotNull String cidade, @NotEmpty @NotNull String pais,
			@NotEmpty @NotNull String estado, @NotEmpty @NotNull Integer telefone, @NotEmpty @NotNull Integer cep) {

		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.nomePais = pais;
		this.nomeEstado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, 
				this.complemento, this.cidade, consultaPais(paisRepository), 
				consultaEstado(estadoRepository), this.telefone, this.cep);
	}

	public Pais consultaPais(PaisRepository paisRepository) {
		Optional<Pais> paisRecuperado = paisRepository.findByNome(this.nomePais);
		if (paisRecuperado.isEmpty()) {
			pais = paisRepository.save(new Pais(this.nomePais));
			return pais;
		}
		System.err.println(paisRecuperado);
		pais = paisRecuperado.get();
		return pais;
	}

	public Estado consultaEstado(EstadoRepository estadoRepository) {
		Optional<Estado> estadoRecuperado = estadoRepository.findByNome(this.nomeEstado);
		if (estadoRecuperado.isEmpty()) {
			Estado estado = estadoRepository.save(new Estado(this.nomeEstado, pais));
			return estado;
		}
		System.err.println(estadoRecuperado);
		Estado estado = estadoRecuperado.get();
		return estado;
	}

}
