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
@Table(name="contatosclientes")
public class ContatoCliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_contato_cliente;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefonefixo")
	private String telefonefixo;
	
	@Column(name="telefonemovel")
	private String telefoneMovel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonBackReference
	private Cliente cliente;
	
	
	public Long getId() {
		return id_contato_cliente;
	}
	public void setId(Long id) {
		this.id_contato_cliente = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefonefixo() {
		return telefonefixo;
	}
	public void setTelefonefixo(String telefonefixo) {
		this.telefonefixo = telefonefixo;
	}
	public String getTelefoneMovel() {
		return telefoneMovel;
	}
	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	
}
