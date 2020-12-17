package com.cursonc.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cursonc.demo.domain.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome,email,cpfOuCnpj;
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private Integer id;
	private String tipo;
	
	//1 cliente possuem 1 ou muitos endereços
	//libera a serialização
	@JsonManagedReference
	@OneToMany(mappedBy="cliente")
	private List<Endereco>enderecos =  new ArrayList<>();
	
	//a classe Set gera uma especie de lista sem repetição(ou seja os itens não podem ser iguais)
	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String>telefones = new HashSet<>();
	
	public Cliente() {}

	public Cliente(String nome, String email, String cpfOuCnpj, Integer id, TipoCliente tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.id = id;
		this.tipo = tipo.getDescricao();
	}

	public Cliente(String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String string) {
		this.tipo = string;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	
	
	
	
	

}
