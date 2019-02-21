package com.wirecard.challenge.utilitarios;

import java.util.HashMap;
import java.util.Map;

/*
 * Coloquei estes exemplos de IIN, bandeiras, apenas para teste. Encontrei algumas
 * referências na internet, mas como, em 2017, houve uma mudança no padrão para para 
 * a geração IIN seguindo a norma ISO/IEC 7812-2 (2017) não sei até que ponto esta avaliação é
 * válida. Seria preciso consultar a norma, mas é paga :/
 * 
 * */
public class Constantes {

	public static final int DIAS_DE_VENCIMENTO = 3;
	//para o controle da cobrança
	public static final String NUM_CONVENIO = "050094"; 
	public static final String COMPLEMENTO = "01448"; 
	public static final int CARTEIRA = 31;
	
	public static final String MASTERCARD = "Mastercard";
	public static final String VISA = "Visa";
	public static final String VISA_ELECTRON = "Visa Electron";
	
	
	
	
	//Identifica a baneira a partir do IIN						      
	public static String getBandeira(String numCartao) {
		
		numCartao = numCartao.replace(" ", "");
		numCartao = numCartao.substring(0, 6);
		
		if(numCartao.startsWith("4")) {
			
			if(numCartao.substring(0, 5).equals("4026") || 
					numCartao.substring(0, 5).equals("4508") ||
				       numCartao.substring(0, 5).equals("4844") ||
				          numCartao.substring(0, 5).equals("4913") ||
				            numCartao.substring(0, 5).equals("4917") ||
				              numCartao.substring(0, numCartao.length()).equals("417500")){
				
					return VISA_ELECTRON;
				
			}else
				
				return VISA;
			
		}else if(numCartao.startsWith("5") &&
				    (51 <= Integer.parseInt(numCartao.substring(0,2)) &&
				    		Integer.parseInt(numCartao.substring(0,2))<= 55)){
			
				return MASTERCARD;
		}
		
		
		return null;
	}
}
