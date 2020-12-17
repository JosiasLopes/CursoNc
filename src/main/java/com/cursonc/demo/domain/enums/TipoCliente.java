package com.cursonc.demo.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1,"pessoa fisica"),
	PESSOAJURIDICA(2,"pessoa juridica");

	private int codigo;
	private String descricao;
	
	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoCliente ToEnum(Integer codigo) {
		if(codigo==null) {
			return null;
		}
		for(TipoCliente x: TipoCliente.values()) {
			if(x.equals(x.getCodigo())){
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalido ou não encontrado "+codigo);
		
	}
}
