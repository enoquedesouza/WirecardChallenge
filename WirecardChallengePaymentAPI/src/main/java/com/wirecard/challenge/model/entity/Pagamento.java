package com.wirecard.challenge.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pagamentos")
public class Pagamento {
	
	public static final int CARTAO = 1;
	public static final int BOLETO = 2;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_pagamento;
	
	@Column(name="tipo")
	private int tipo;
	
	@Column(name="status")
	private String status;
	
	@Column(name="valormeio")
	private String valorMeio; //Número cartão ou número do boleto
	
	@Column(name="valor")
	private double valor;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_cartao")
    private CartaoDeCredito cartao;
	
	public Long getId() {
		return id_pagamento;
	}
	public void setId(Long id) {
		this.id_pagamento = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setValorMeio(String meio) {
		
		valorMeio = meio;
	}
	
	public String getValorMeio() {
		return valorMeio;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getValor() {
		return valor;
	}
	
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public Venda getVenda() {
		return venda;
	}
	
	public void setCartao(CartaoDeCredito cartao) {
		this.cartao = cartao;
	}
	
	public CartaoDeCredito getCartao() {
		return cartao;
	}
	

}
