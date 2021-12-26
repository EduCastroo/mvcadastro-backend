package br.com.mv.mvcadastro.model;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_projetos")
public class Projetos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoProjeto;

	@NotNull(message = "O atributo nome é obrigatório")
	private String nomeProjeto;

	@NotNull(message = "O atributo valor é obrigatório")
	private double valorProjeto;

	@ManyToMany(mappedBy = "projetos")
	@JsonIgnoreProperties("projetos")
	private List<Cliente> clienteProjeto;

	// Primeiro método Construtor - Com os atributos
	public Projetos(long codigoProjeto, String nomeProjeto, double valorProjeto) {

		this.codigoProjeto = codigoProjeto;
		this.nomeProjeto = nomeProjeto;
		this.valorProjeto = valorProjeto;

	}
	// Segundo método Construtor - Sem os atributos

	public Projetos() {
	}

	public long getCodigoProjeto() {
		return codigoProjeto;
	}

	public void setCodigoProjeto(long codigoProjeto) {
		this.codigoProjeto = codigoProjeto;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public double getValorProjeto() {
		return valorProjeto;
	}

	public void setValorProjeto(double valorProjeto) {
		this.valorProjeto = valorProjeto;
	}

	public List<Cliente> getClienteProjeto() {
		return clienteProjeto;
	}

	public void setClienteProjeto(List<Cliente> clienteProjeto) {
		this.clienteProjeto = clienteProjeto;
	}

}
