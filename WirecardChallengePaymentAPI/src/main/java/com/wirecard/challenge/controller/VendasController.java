package com.wirecard.challenge.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wirecard.challenge.factories.StatusVendaFactory;
import com.wirecard.challenge.model.StatusVenda;
import com.wirecard.challenge.model.entity.CartaoDeCredito;
import com.wirecard.challenge.model.entity.Cliente;
import com.wirecard.challenge.model.entity.Comprador;
import com.wirecard.challenge.model.entity.ContaBancaria;
import com.wirecard.challenge.model.entity.ContatoCliente;
import com.wirecard.challenge.model.entity.EnderecoCliente;
import com.wirecard.challenge.model.entity.Pagamento;
import com.wirecard.challenge.model.entity.Venda;
import com.wirecard.challenge.repository.CartaoDeCreditoRepository;
import com.wirecard.challenge.repository.ClienteRepository;
import com.wirecard.challenge.repository.CompradorRepository;
import com.wirecard.challenge.repository.ContaBancariaRepository;
import com.wirecard.challenge.repository.ContatoRepository;
import com.wirecard.challenge.repository.EnderecoRepository;
import com.wirecard.challenge.repository.PagamentoRepository;
import com.wirecard.challenge.repository.VendaRepository;
import com.wirecard.challenge.utilitarios.Constantes;
import com.wirecard.challenge.utilitarios.Status;

@RestController
public class VendasController {

	
	
	private Optional<Cliente> cl;
	private StatusVenda statusVenda;
	private CartaoDeCredito cartao;
	
	@Autowired
	private StatusVendaFactory statusVendaFactory;
	
	@Autowired
	private CartaoDeCreditoRepository cR;
	
	@Autowired
	private ClienteRepository clR;
	
	@Autowired
	private VendaRepository vdR;
	
	@Autowired
	private ContatoRepository ctR;
	
	@Autowired
	private EnderecoRepository endR;
	
	@Autowired
	private ContaBancariaRepository cnR;
	
	@Autowired
	private CompradorRepository cpR;
	
	@Autowired
	private PagamentoRepository pgR;
	
	
	
	
	@GetMapping("/")
	@ResponseBody
	public ModelAndView index() { 
		
		ModelAndView mv = new ModelAndView("checkout");  
		return mv; 
    
	}
	
	
	//A clicar o botão, na página de checkout, para confirmar a compra
	//Ou acessar via curl
	
	@PostMapping(value = "/confirmar")
	public StatusVenda adicionaConta(@RequestParam String id, @RequestParam String nome, 
								  @RequestParam String email, @RequestParam String cpf, 
								  @RequestParam(required=false) String nomecartao, 
								  @RequestParam(required=false) String numerocartao, 
								  @RequestParam(required=false) String cvv,   
								  @RequestParam(required=false) String validadecartao,  
								  @RequestParam(required=false) String valor,
								  @RequestParam(required=false) String tipopagamento) {
		
		
			//Informações de quem está realizando a compra
			Comprador cp = new Comprador();
			cp.setNome(nome);
			cp.setEmail(email);
			cp.setCpf(cpf);
			System.out.println(validadecartao);
			//Informações da opção de pagamento
			Pagamento pg = new Pagamento();
			pg.setStatus(Status.PENDENTE);
			pg.setTipo((tipopagamento.equals("boleto"))?Pagamento.BOLETO: Pagamento.CARTAO);
			pg.setValor(Double.parseDouble(valor));
			
			if(tipopagamento.equals("cartao")) {
				
				//Recupera as informações do cartão de crédito passadas pelo usuário
				
				cartao = new CartaoDeCredito();
				cartao.setNomeNoCartao(nomecartao);
				cartao.setNumero(numerocartao);
				cartao.setCvv(Integer.parseInt(cvv));
				cartao.setValidade(validadecartao);;
				cartao.setBandeira(Constantes.getBandeira(numerocartao));
				pg.setCartao(cartao);
				
			}
			
			//Configura a venda para o cliente conecato a API
			Venda vd = new Venda();
			vd.setComprador(cp);
			vd.setData(LocalDate.now());
			vd.setPagamento(pg);
			vd.setStatus(Status.AGUARDANDO_PAGAMENTO);
			
			cl = clR.findById(Long.parseLong(id));
			/*
			 * Resumo das informações da venda que está sendo realizado
			 * Este resumo é retornado para o cliente da API como um objeto JSON
			 * e ele decide o que mostrar na tua página de compra.
			 * 
			  */
			
			
			statusVenda = statusVendaFactory.statusVenda(cl.get(), vd);
			
			//pg.setVenda(vd);
			//cp.setVenda(vd);
			
			//Registra as informações da venda no banco de dados.
			//vdR.save(vd);
			//pgR.save(pg);
			//cpR.save(cp);
			
			return statusVenda;

		
	}
	
	
	
}
