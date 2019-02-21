package com.wirecard.challenge.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirecard.challenge.model.entity.CartaoDeCredito;
import com.wirecard.challenge.model.entity.Pagamento;
import com.wirecard.challenge.service.ValidadorDeCartao;
import com.wirecard.challenge.utilitarios.Status;

@Service
public class ValidacoesCartaoFactory {
  
	
	@Autowired
	private ValidadorDeCartao validador;
	
	
	//Obs: estou supondo que o cartão está na base de dados. 
	public String valideCartao(CartaoDeCredito cartao, Pagamento pg) {
		
		if(validador.cartaoEValido(cartao.getNumero())) {
			
			if(validador.isStatusOk()) {
			
				if(validador.isNomeDoCartaoOk(cartao.getNomeNoCartao())) {
			
					if(validador.isCVVOk(cartao.getCvv())) {
				
						if(validador.isDataDeValidadeOk(cartao.getValidade())) {
					
							if(validador.temLimite(pg.getValor())) {
								System.out.println("ok");
								return Status.OK;
							}
							
							return Status.NEGADO;
						}
					
						return Status.NEGADO;
					}
	
					return Status.NEGADO;
				}
				
				return Status.NEGADO;
			}
		
			return Status.NEGADO;
		}

		return Status.CARTAO_INVALIDO;
	}
}
