package com.wirecard.challenge.model;

import com.wirecard.challenge.model.entity.Venda;

/* Classe que representa um resumo da compra que acabou de ser realizada pelo usuário.
 * Este resumo é apresentado ao usuário quando ele confirma as informações do checkout. */
public class StatusVenda {
	
	/* Informações do comprador*/
	private Venda vd;

	private String meio; // número linha digitável do boleto ou final do cartão.
	
	

	public void setVenda(Venda vd) {
		
		this.vd = vd;
	}
	
	public Venda getVenda() {
		return vd;
	}
	

	public void setInfoPagamento(String meio) {
		
		this.meio = meio;
	}

	public String getInfoPagamento() {
		
		return meio;
	}
	
	public String toString() {
		
		return vd.getComprador().getNome() +
			   vd.getComprador().getCpf() +
			   vd.getComprador().getEmail()+
			   vd.getPagamento().getValor()+
			   (vd.getPagamento().getTipo()==2?"Número Boleto: " + 
			    meio: "Numero Cartão: " + meio) +
			   vd.getPagamento().getStatus() + 
			   vd.getData();
	}

}
