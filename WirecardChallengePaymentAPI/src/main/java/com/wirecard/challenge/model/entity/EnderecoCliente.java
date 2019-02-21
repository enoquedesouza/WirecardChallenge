package com.wirecard.challenge.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="enderecosclientes")
public class EnderecoCliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_endereco_cliente;
	
	@Column(name="rua")
	private String rua;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="pais")
	private String pais;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonBackReference
	private Cliente cliente;
	
	//@OneToMany(fetch = FetchType.LAZY,mappedBy = "cliente",cascade=CascadeType.ALL)
	//@JsonBackReference
	
	public Long getId() {
		return id_endereco_cliente;
	}
	public void setId(Long id) {
		this.id_endereco_cliente = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getPaís() {
		return pais;
	}
	public void setPaís(String país) {
		this.pais = país;
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
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
}
