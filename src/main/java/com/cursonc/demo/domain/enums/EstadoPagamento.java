package com.cursonc.demo.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1,"Status Pendente"),
	QUITADO(2,"Status Quitado"),
	CANCELADO(3,"Status Cancelado");

	private Integer codigo;
	private String descricao;
	
	EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static EstadoPagamento ToEnum(Integer codigo) {
		if(codigo==null) {
			return null;
		}
		for(EstadoPagamento x: EstadoPagamento.values()) {
			if(x.equals(x.getCodigo())){
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido ou não encontrado "+codigo);
		
	}

}
