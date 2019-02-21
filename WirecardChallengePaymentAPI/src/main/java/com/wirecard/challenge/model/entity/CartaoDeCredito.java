package com.wirecard.challenge.model.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wirecard.challenge.utilitarios.Status;

@Entity
@Table(name="cartoesdecredito")
public class CartaoDeCredito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nomenocartao")
	private String nomeNoCartao;
	
	@Column(name="bandeira")
	private String bandeira;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="validade")
	private Date validade;// a titulo de teste estou deixando validade como uma string
	
	@Column(name="limite")
	private double limite;
	
	@Column(name="limiteutilizado")
	private double limiteUtilizado;
	
	@Column(name="limitedisponivel")
	private double limiteDisponivel;
	
	@Column(name="cvv")
	private int cvv;
	
	@Column(name="status")
	private String status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeNoCartao() {
		return nomeNoCartao;
	}
	public void setNomeNoCartao(String nomeNoCartao) {
		this.nomeNoCartao = nomeNoCartao;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		numero = numero.replace(" ", "");
		this.numero = numero;
	}
	
	public void setValidade(String dataValidade) {
		
		Month mes = Month.of(Integer.parseInt(dataValidade.substring(5,6)));
		
		LocalDate data1= LocalDate.of(Integer.parseInt(dataValidade.substring(0, 4)), 
										Integer.parseInt(dataValidade.substring(5,6)), 
										mes.maxLength());
		
        Date data = Date.valueOf(data1);
        
        validade = data;
	}
	
	public Date getValidade() {
		
		return validade;
		
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public double getLimiteUtilizado() {
		return limiteUtilizado;
	}
	public void setLimiteUtilizado(double limiteUtilizado) {
		this.limiteUtilizado = limiteUtilizado;
	}
	public double getLimiteDisponivel() {
		return limiteDisponivel;
	}
	public void setLimiteDisponivel(double limiteDisponivel) {
		this.limiteDisponivel = limiteDisponivel;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
