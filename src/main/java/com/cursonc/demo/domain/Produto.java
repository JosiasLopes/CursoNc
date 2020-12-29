package com.cursonc.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable{
	
	
	//mapeia os objetos em muitos pra muitos gerando a outra tabela
	
	@ManyToMany
	@JoinTable(name = "Produto_Categoria",
			joinColumns=@JoinColumn(name="produto_id"),
			inverseJoinColumns =@JoinColumn(name="categoria_id")
			)
	//o back reference é colocado no objeto que fornece os dados
	@JsonBackReference
	private List<Categoria> categorias = new ArrayList<>();
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	
	private String nome;
	
	private Double preço;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}
	
	//O produto tambem conhece os itens pedidos associados a ele
	//um objeto do tipo set é uma lista onde os itens não se repetem
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido>itens = new HashSet<>();

	public Set<ItemPedido> getItens() {
		return itens;
	}
	
	//lembremos que o item pedido tem o id composto tambem pelo id do pedido
	//forra que essa classe tem o metodo getPedido tambem

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}
	
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();
		//pra percorrer uma lista de x tipo 
		//usamos o contador que nesse caso é do tipo da Lista : a lista
		//assim fazemos um for que percorre todos os elementos sem excessão
		for(ItemPedido x : itens ) {
			lista.add(x.getPedido());
		}
		return lista;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preço == null) {
			if (other.preço != null)
				return false;
		} else if (!preço.equals(other.preço))
			return false;
		return true;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Produto(Integer id, String nome, Double preço) {
		super();
		Id = id;
		this.nome = nome;
		this.preço = preço;
	}

	public Produto() {
		super();
	}

	
	
	

	
}
