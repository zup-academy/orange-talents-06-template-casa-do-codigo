package br.com.zypacademy.casaDoCodigo.model.pagamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.zypacademy.casaDoCodigo.model.Estado;
import br.com.zypacademy.casaDoCodigo.model.Pais;

@Entity
public class Cliente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String email;
	private String nome;
	private String sobrenome;
	private String documento;
	private String endereco;
	private String complemento;
	private String cidade;
	
	@OneToOne
	@JoinColumn(name = "pais_codigo")
	private Pais pais;
	@OneToOne
	@JoinColumn(name = "estado_codigo")
	private Estado estado;
	private Integer telefone;
	private Integer cep;
	
	public Cliente() {}

	public Cliente(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Pais pais, Estado estado, Integer telefone, Integer cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public Long getCodigo() {
		return codigo;
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
