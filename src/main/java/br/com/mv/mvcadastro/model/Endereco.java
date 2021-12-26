package br.com.mv.mvcadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;

	@NotNull(message = "O atributo rua é obrigatório")
	private String rua;

	@NotNull(message = "O atributo numero é obrigatório")
	private int numero;

	@NotNull(message = "O atributo complemento é obrigatório")
	private String complemento;

	@NotNull(message = "O atributo bairro é obrigatório")
	private String bairro;

	@NotNull(message = "O atributo cidade é obrigatório")
	private String cidade;

	@NotNull(message = "O atributo estado é obrigatório")
	private String estado;

	@ManyToOne
	@JsonIgnoreProperties("clienteEndereco")
	private Cliente cliente;

	// Primeiro método Construtor - Com os atributos
	public Endereco(Long idEndereco, String rua, int numero, String complemento, String bairro, String cidade,
			String estado) {
		{
			this.idEndereco = idEndereco;
			this.rua = rua;
			this.numero = numero;
			this.complemento = complemento;
			this.bairro = bairro;
			this.cidade = cidade;
			this.estado = estado;
		}

	}

	public Endereco() {
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Segundo método Construtor - Sem os atributos

}
