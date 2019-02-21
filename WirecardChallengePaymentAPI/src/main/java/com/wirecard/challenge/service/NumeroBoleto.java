package com.wirecard.challenge.service;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;;

/* A geração deste digitável do código de barras segue as especificações técnicas para a geração de 
 * boleto de cobrança do Banco do Brasil. Esta especificação é de novembro de 2018 e tem o seguinte 
 * modelo:
 * 
 *  AAABC.CCCCX XDDDD.DDDDDY EEEEE.EEEEEZ K UUUUVVVVVVVVVV
 * |  Campo 1  |   Campo 2  |  Campo 3   |4|    Campo 5   |
 *  
 *  Onde:     
 *  	
 *       		AAAB - Código do banco + código da moeda, que para o Real é 9.
 *
 *  			CCCCCX - Número do convênio, definido pelo banco. X é o dígito verificador do campo.
 *  			
 *  			DDDDD.DDDDDY - depois temos
 *  			complemento e a agência do beneficiário. Y é dígito verificador do campo.
 *  
 *  			Número do convênio + complemento compõe o Nosso Número.
 *  
 *  			EEEEE.EEEEEZ - Conta bancária + carteira, Z é o dígito verificador do campo.
 *  
 *  			K - Dígito verificador do código de barras.
 *  
 *  			UUUU - Fator de vencimento, calculado por uma regra específica.
 *  
 *  			VVVVVVVVVV - Destinado ao valor do boleto.
 *  
 *  		
 *  
 *  */
public class NumeroBoleto {

	private static final int CODMD = 9; //Código moeda para o real.
	
	
	private String codBc; //Código do banco.
	private String agencia; // Agência bancária do beneficiário
	private String conta; // conta bancária do beneficiário
	private String valor; // Valor do boleto
	private String valorFormatado;
	private int diasVencimento; //Dias da geração até o vencimento.
	private String numConv; //numero do convênio.
	private String complemento; 
	private String carteira;
	
	private int x;//dígito verificador do campo 1.
	private int y; //digito verificador do campo 2.
	private int z; //dígito verificador do campo 3.
	private int k; //dígito verificador do código. 
	
	private int fator; // Numero de dias transcorridos da data referência (03/07/2000) até a data a geração do boleto.
					  // estabelece um padão para a geração da data de vencimento dos boletos bancários do país

	private long fVenc; //fator de vencimento. É o fator mais os dias estabelecidos para o vencimento do boleto.
	
	
	
	
	
	public NumeroBoleto(String codBc, String agencia, String conta, String valor, int diasVencimento, 
						String numConv, String complemento,  String carteira) {
		
		
		this.codBc = padronizaCodBc(codBc);
		this.agencia = agencia;
		this.conta = conta;
		this.diasVencimento = diasVencimento;
		this.numConv = numConv;
		this.valor = valor;
		this.complemento = complemento;
		this.carteira = carteira;
		
		x = calculaDigitoVerificadorDoCampo(codBc+CODMD+numConv); 
		y = calculaDigitoVerificadorDoCampo(complemento+agencia);
		z = calculaDigitoVerificadorDoCampo(conta+carteira);
		fVenc = calculaFatorDeVencimento(diasVencimento); 
		valorFormatado = padronizaValor(valor);
		k = calculaDigitoVerificadorDoCB(padronizaCod());
		
		
		
	}
	
	private static String padronizaCodBc(String cod) {
		
		
		if(cod.length()==1) {
			
			return (cod = "00"+cod);
			
		}else if(cod.length()==2)
			
			return(cod = "0"+cod);
		
		return cod;
		
	}
	
	// Deixa o valor passado no padrão para ser utilizado no código de barras (VVVVVVVVVV)
	private static String padronizaValor(String valor) {
		
		StringBuilder retorno = new StringBuilder();
		retorno.append(valor).deleteCharAt(valor.indexOf(","));
		
		for(int i = valor.length(); i <=10; i++) {
			
			retorno.insert(0, '0');
		}
		
		
		return retorno.toString();
	}
	
	/* Padroniza o código para ficar no formato que permite o cáculo do do digito verificador do código inteiro.
	 * Formato:
	 * AAABCCCCVVVVVVVVVVDDDDDDEEEEEFFFFGGGGGGGGHH
	 *  A - código do banco
	 *  B - codigo da moeda
	 *  C - Fator de vencimento
	 *  V - representação do valor
	 *  D - número do convênio
	 *  E - complemento
	 *  F - agência
	 *  G - conta
	 *  H - carteira
	 */
	private String padronizaCod() {
		
		StringBuilder padraoCod = new StringBuilder();
		
		
		return padraoCod.append(codBc).append(CODMD).append(fVenc).
				  append(valorFormatado).append(numConv).
				  append(complemento).append(agencia).
				  append(conta).append(carteira).toString();
	}
	

	// @param campo é a representação string do campo,. O método cálcula o digito verificador do campo passado como parâmetro.
	private static int calculaDigitoVerificadorDoCampo(String campo) {
		
		String valor = campo;
		int tmp;
		int soma = 0;
		
		for(int i = (valor.length()-1); i >=0; i--) {
				
				if(((valor.length() - 1)-i)%2 == 0) {
					
					tmp = Integer.parseInt(String.valueOf(valor.charAt(i))) *2;
					
					if(tmp > 9) {
						
						tmp = Integer.parseInt(String.valueOf(String.valueOf(tmp).charAt(0)))+
								Integer.parseInt(String.valueOf(String.valueOf(tmp).charAt(1)));
					}
				}else
					
					tmp = Integer.parseInt(String.valueOf(valor.charAt(i)));
				
				soma+=tmp;
		}
		
		if((soma%10) == 0) 
			return 0;
		
		return (10 - soma%10);
	}
	
	
	//@param codigo representação string do código. O parâmetro é passado em um formato específico 
	// com os dados da linha digitá a menos dos dígitos verificadores.
	private static int calculaDigitoVerificadorDoCB(String codigo) {
		
		String valor = codigo;
		int multiplicador = 2;
		int soma = 0;
		int dv;
		
		for(int i =(valor.length()-1); i >= 0; i--) {
			
			soma += Integer.parseInt(String.valueOf(valor.charAt(i))) *multiplicador;
			
			multiplicador++;
			
			//reseta o multiplicador
			if(multiplicador > 9) {
				
				multiplicador = 2;
			}
			
		}
		
		dv = 11-soma%11;
		switch(dv) {
			case 0:
				return 1;
			case 1:
				return 1;
			case 11:
				return 1;
			default:
				return dv;
		}
	}

	
  /* A FEBRABAN definiu a data referência para o cálculo do fator do vencimento 03/07/2000 
   * a partir desta data o fator inicia de 1000 e acrecido de 1 a cada dia passado, quando 
   * chegar a 9999 e resetado para 1000. A data de vencimento dos boletos são calculados como sendo
   * uma representação do fator acrescido dos dias desetinados para o pagamento do documento*/
	
  private long calculaFatorDeVencimento(int diasVencimento) {
		
	  	// recupera o número de dias transcorrido desde a data referência até a data da geração do boleto.
	  
		LocalDate dataAtual = LocalDate.now();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Calendar data1 = Calendar.getInstance();
		Calendar data2 = Calendar.getInstance();
		
		try {
			
			data1.setTime(sdf.parse("03/07/2000"));
			data2.setTime(sdf.parse(""+dataAtual.getDayOfMonth()+"/"+dataAtual.getMonthValue()+"/"+dataAtual.getYear())); 
			
		} catch (java.text.ParseException e ) {}
		
		long valor1 = data1.getTimeInMillis();
		long valor2 = data2.getTimeInMillis();
		
		//calcula os dias transcorridos até a data atual.
		long fator = (valor2 - valor1)/(1000*3600*24);
		fator += (1000 + 1);// + 1 referente ao dia atual.
		
		if(fator == 10000) {
			
			fator = 1000;
		}
		
		return fator + diasVencimento;
  }
  
  // Representação string da linha digitável do código de barras
  public String toString() {
	  
	  return new StringBuilder().append(codBc).append(CODMD).append(numConv).
			  append(x).append(complemento).append(agencia).append(y).
			  append(conta).append(carteira).append(z).append(k).
			  append(fVenc). append(valorFormatado).toString();
  }
	
}
