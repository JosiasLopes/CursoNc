package com.cursonc.demo.domain;

import javax.persistence.Entity;

import com.cursonc.demo.domain.enums.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nParcelas;

	public Integer getnParcelas() {
		return nParcelas;
	}

	public void setnParcelas(Integer nParcelas) {
		this.nParcelas = nParcelas;
	}

	public PagamentoCartao() {
		super();
		
	}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido,Integer nParcelas) {
		super(id, estado, pedido);
		this.nParcelas = nParcelas;
	}
	
	

}
