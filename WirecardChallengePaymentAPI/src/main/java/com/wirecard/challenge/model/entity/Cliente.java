package com.wirecard.challenge.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long id_cliente;
	
	@Column(name="nome")
	private String nome; //nome ou razão social
	
	@Column(name="cnpj")
	private String cnpj;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<EnderecoCliente> enderecos;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<ContatoCliente> contatos;
	
	@OneToMany( mappedBy = "cliente",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<ContaBancaria> contas;
	
	
	public Long getId() {
		return id_cliente;
	}
	public void setId(Long id) {
		this.id_cliente = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<EnderecoCliente> getEnderecos() {
		return enderecos;
	}
	public void setEndereco(List<EnderecoCliente> enderecos) {
		this.enderecos = enderecos;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	public void setContas(List<ContaBancaria> contas) {
		this.contas = contas;
	}
	
	public List<ContaBancaria> getContas() {
		return contas;
	}
	
	public void setContatos(List<ContatoCliente> contatos) {
		this.contatos = contatos;
	}
	
	public List<ContatoCliente> getContatos() {
		return contatos;
	}
	
	
	
}
