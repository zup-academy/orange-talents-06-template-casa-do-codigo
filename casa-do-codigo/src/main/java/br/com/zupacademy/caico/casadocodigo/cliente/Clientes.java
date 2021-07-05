package br.com.zupacademy.caico.casadocodigo.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.caico.casadocodigo.estados.Estados;
import br.com.zupacademy.caico.casadocodigo.paises.Paises;

@Entity
public class Clientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String email;

	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotBlank
	@Column(nullable = false)
	private String sobrenome;
	
	@NotBlank
	@Column(nullable = false)
	private String documento;	
	
	@NotBlank
	@Column(nullable = false)
	private String endereco;
	
	@NotBlank
	@Column(nullable = false)
	private String complemento;
	
	@NotBlank
	@Column(nullable = false)
	private String cidade;
	
	@NotNull
	@ManyToOne
	private Paises paises;
	
	@ManyToOne
	private Estados estados;
	
	@NotBlank
	@Column(nullable = false)
	private String telefone;
	
	@NotBlank
	@Column(nullable = false)
	private String cep;
	
	
	@Deprecated
	public Clientes() {
		
	}

	/**
	 * 
	 * @param email
	 * @param nome
	 * @param sobrenome
	 * @param documento
	 * @param endereco
	 * @param complemento
	 * @param cidade
	 * @param paises
	 * @param estados
	 * @param telefone
	 * @param cep
	 */
	public Clientes(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Paises paises, Estados estados, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paises = paises;
		this.estados = estados;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getId() {
		return id;
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

	public Paises getPaises() {
		return paises;
	}

	public Estados getEstados() {
		return estados;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
}
