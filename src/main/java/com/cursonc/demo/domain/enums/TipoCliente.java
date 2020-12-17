package com.cursonc.demo.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1,"pessoa fisica"),
	PESSOAJURIDICA(2,"pessoa juridica");

	//os enums podem ser criados atribuindo valores e strings
	//para isso é necessario um construtor para passar os valores
	//os valores de um enum não podemser alterados por em podem ser acessados
	//atraves de metodos get 
	private Integer codigo;
	private String descricao;
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	private TipoCliente(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//criamos um metodo statico para que não seja necessario instanciar 
	//um novo objeto quando formos buscar
	@SuppressWarnings("unlikely-arg-type")
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
