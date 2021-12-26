package br.com.mv.mvcadastro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "O atributo nome é obrigatório")
	@Size(min = 5, max = 100, message = "O atributo nome deve ter no mínimo 05 e no máximo 100 caracteres")
	private String nome;

	// @ApiModelProperty(example = "00.000.000/0000-00")
	@NotNull(message = "O atributo cnpj é obrigatório")
	@Size(min = 14, max = 14, message = "O atributo cnpj deve ter 14 caracteres")
	private String cnpj;

	@ManyToMany
	@JsonIgnoreProperties("clienteProjeto")
	@JoinTable(
			name = "cliente_projeto", 
			joinColumns =  @JoinColumn(name = "cliente_id") , 
			inverseJoinColumns = 
			@JoinColumn(name = "projeto_id"))
	private List<Projetos> projetos = new ArrayList<Projetos>();

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("cliente")
	private List<Endereco> clienteEndereco;

	// Primeiro método Construtor - Com os atributos
	public Cliente(long id, String nome, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	// Segundo método Construtor - Sem os atributos

	public Cliente() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Projetos> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projetos> projetos) {
		this.projetos = projetos;
	}

	public List<Endereco> getClienteEndereco() {
		return clienteEndereco;
	}

	public void setClienteEndereco(List<Endereco> clienteEndereco) {
		this.clienteEndereco = clienteEndereco;
	}

}
