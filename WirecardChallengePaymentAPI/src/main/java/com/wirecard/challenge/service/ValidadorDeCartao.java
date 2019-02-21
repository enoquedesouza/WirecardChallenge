package com.wirecard.challenge.service;



import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wirecard.challenge.model.entity.CartaoDeCredito;
import com.wirecard.challenge.repository.CartaoDeCreditoRepository;
import com.wirecard.challenge.utilitarios.Status;

@Service
public class ValidadorDeCartao {
	
	
	private Optional<CartaoDeCredito> cartao;
	private String numeroDoCartao;
	@Autowired
	private CartaoDeCreditoRepository cartaoRep;

	
	public boolean cartaoEValido(String numero) {
		
		int soma = 0;
		int tmp = 0;
		numero = numero.replace(" ", "");
		boolean alterne = false;
		
		for(int i = (numero.length()-1); i >=0; i--) {
			
			if(alterne) {
				
				tmp = Integer.parseInt(String.valueOf(numero.charAt(i))) *2;
				
				if(tmp > 9) {
					
					tmp -=9;
				}
			}else
				
				tmp = Integer.parseInt(String.valueOf(numero.charAt(i)));
			
			soma+=tmp;
			alterne =!alterne;
		}
		
		if(soma%10 == 0) {
			
			numeroDoCartao = numero;
			cartao = cartaoRep.findByNumero(numeroDoCartao);
			return true;
		}
		
		return false;
	}
	
	public boolean isStatusOk() {
		
		if(cartao.get().getStatus().equals(Status.ATIVO)) {
			 
			return true;
			
		}else if(cartao.get().getStatus().equals(Status.BLOQUEADO)) {
			
			return false;
		}
		
		return false;
		
	}
	public boolean isCVVOk(int cvv) {
		
		if(cartao.get().getCvv() == cvv) {
			
			return true;
		}
		
		return false;
	}
	
	
	public boolean isNomeDoCartaoOk(String nome) {
		
		if(cartao.get().getNomeNoCartao().equals(nome))
			
			return true;
		
		else
			
			return false;
	
	}
	
	public boolean isDataDeValidadeOk(Date dataDeValidade) {
		
		Date dataAtual = Date.valueOf(LocalDate.now());
		
		Date data = cartao.get().getValidade();
		
		
		//if(data.equals(dataDeValidade)) {
			
			if(dataAtual.before(data)) {
				
				return true;
			}
			
			//return false;
			
		//}else
		
			return false;
	}
	
	
	public boolean temLimite(double valorDaCompra) {
		
		if(valorDaCompra <= cartao.get().getLimiteDisponivel()) {
			
			return true;
		}
		
		return false;
		
	}
	

}
