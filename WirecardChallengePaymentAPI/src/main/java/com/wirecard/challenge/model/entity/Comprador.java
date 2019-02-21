package com.wirecard.challenge.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compradores")
public class Comprador {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_comprador;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	
	public void setId(Long id) {
		this.id_comprador = id;
	}
	
	public Long getId() {
		
		return id_comprador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
}
