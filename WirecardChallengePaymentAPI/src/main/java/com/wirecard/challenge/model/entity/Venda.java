package com.wirecard.challenge.model.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vendas")
public class Venda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_venda;
	
	@Column(name="status")
	private String status;
	
	@Column(name="datadavenda")
	private LocalDate data;
	
	@OneToOne(mappedBy = "venda", targetEntity = Comprador.class, cascade=CascadeType.ALL)
	private Comprador comprador;
	
	@OneToOne(mappedBy = "venda", targetEntity = Pagamento.class, cascade=CascadeType.ALL)
	private Pagamento pagamento;

	
	public Long getId() {
		return id_venda;
	}
	public void setId(Long id) {
		this.id_venda = id;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate date) {
		this.data = date;
	}
	

}
