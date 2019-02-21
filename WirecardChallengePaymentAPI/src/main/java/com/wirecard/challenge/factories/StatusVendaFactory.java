package com.wirecard.challenge.factories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirecard.challenge.model.StatusVenda;
import com.wirecard.challenge.model.entity.Cliente;
import com.wirecard.challenge.model.entity.Pagamento;
import com.wirecard.challenge.model.entity.Venda;
import com.wirecard.challenge.utilitarios.Status;

@Service
public class StatusVendaFactory {

	private StatusVenda statusVenda;
	private String numBoleto;
	
	@Autowired
	private ValidacoesCartaoFactory validacao;
	
	
	public StatusVenda statusVenda(Cliente cl, Venda vd) {
		
		
		//Se tipo boleto gera o número do boleto. sintetiza as informações da venda e retorna
		if(vd.getPagamento().getTipo() == Pagamento.BOLETO) {
			
			numBoleto = new NumeroBoletoFactory(vd, cl).getNumeroBoleto();
			
			statusVenda = new StatusVenda();
			statusVenda.setVenda(vd);
			statusVenda.setInfoPagamento(numBoleto);
			
			
			return statusVenda;
			
		//Se tipo cartão, valida as informações do cartão, realiza a transação e retorna.
		}else {
			String status = validacao.valideCartao(vd.getPagamento().getCartao(), 
					vd.getPagamento());
			
			if(status.equals(Status.OK)) {
				
				statusVenda = new StatusVenda();
				vd.getPagamento().setStatus(Status.REALIZADO);
				vd.setStatus(Status.CONCLUIDO);
				statusVenda.setVenda(vd);
				statusVenda.setInfoPagamento(vd.getPagamento().getCartao().
												getNumero());
				
				return statusVenda;
				
			}else {
				
				statusVenda = new StatusVenda();
				vd.getPagamento().setStatus(status);
				vd.setStatus(Status.NAO_CONCLUIDO);
				statusVenda.setVenda(vd);
				statusVenda.setInfoPagamento(vd.getPagamento().getCartao().
												getNumero());
				
				
				//Qualquer situação que impeça o pagamento com o cartão retorne as informações 
				return statusVenda;
			}
			
			
			
		}
		
	}
}
