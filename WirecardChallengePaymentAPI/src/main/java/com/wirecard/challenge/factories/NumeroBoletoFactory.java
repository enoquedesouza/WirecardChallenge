package com.wirecard.challenge.factories;

import com.wirecard.challenge.model.entity.Cliente;
import com.wirecard.challenge.model.entity.Venda;
import com.wirecard.challenge.service.NumeroBoleto;
import com.wirecard.challenge.utilitarios.Constantes;

public class NumeroBoletoFactory {

	private NumeroBoleto numBoleto;
	private Cliente cl;
	private Venda vd;
	
	public NumeroBoletoFactory(Venda vd, Cliente cl) {
		
		this.vd = vd;
		this.cl = cl;
	}
	
	
	public String getNumeroBoleto() {
		
		numBoleto = new NumeroBoleto( String.valueOf(cl.getContas().get(0).getCodBanco()),
				   cl.getContas().get(0).getAgencia(),
				   cl.getContas().get(0).getNumero(),
				   String.format("%.2f", vd.getPagamento().getValor()),
				   Constantes.DIAS_DE_VENCIMENTO,
				   Constantes.NUM_CONVENIO, Constantes.COMPLEMENTO, 
				   String.valueOf(Constantes.CARTEIRA));
		System.out.println(numBoleto.toString());
		return numBoleto.toString();
	}
	
}
