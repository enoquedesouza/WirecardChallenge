package com.wirecard.challenge.model;

import java.util.Calendar;

//Não utilizada por enquanto
public class Boleto {

	private String numero;
	private Calendar dataEmissao;
	private Calendar dataVencimento;
	
	
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Calendar getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Calendar getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
	
}
