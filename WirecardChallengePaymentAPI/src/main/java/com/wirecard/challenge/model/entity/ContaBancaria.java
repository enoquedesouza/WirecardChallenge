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
@Table(name="contas")
public class ContaBancaria {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_conta;
	
	@Column(name="codbanco")
	private int codBanco; //código do banco
	
	@Column(name="tipo")
	private int tipo; //conta 1 - corrente ou 2 - poupança
	
	@Column(name="agencia")
	private String agencia;
	
	@Column(name="numero")
	private String numero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonBackReference
	private Cliente cliente;
	
	
	public Long getId() {
		return id_conta;
	}
	public void setId(Long id) {
		this.id_conta = id;
	}
	public int getCodBanco() {
		return codBanco;
	}
	public void setCodBanco(int codBanco) {
		this.codBanco = codBanco;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	
	

}
