package com.cursonc.demo.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.cursonc.demo.domain.enums.EstadoPagamento;

@Entity
public class PagamentoBoleto extends Pagamento{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date DataPagamento;
	private Date DataVencimento;
	
	public Date getDataPagamento() {
		return DataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		DataPagamento = dataPagamento;
	}
	
	public PagamentoBoleto() {
		super();
		
	}
	public PagamentoBoleto(Date dataPagamento, Date dataVencimento) {
		DataPagamento = dataPagamento;
		setDataVencimento(dataVencimento);
	}
	
	public PagamentoBoleto(Integer id,EstadoPagamento estado,Pedido pedido,Date dataPagamento, Date dataVencimento) {
		super(id,estado,pedido);
		this.DataPagamento = dataPagamento;
		this.DataVencimento =dataVencimento;
	}
	
	public Date getDataVencimento() {
		return DataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		DataVencimento = dataVencimento;
	}
	
	

}
