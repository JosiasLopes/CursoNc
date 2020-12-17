package com.cursonc.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursonc.demo.domain.Endereco;
import com.cursonc.demo.repositories.EnderecoRepository;
import com.cursonc.demo.services.exception.ObjectNotFoundException;

@Service
public class EnderecoService{

	//a classe de serviço conversa com a Repository
	@Autowired
	private EnderecoRepository repo;
	public Endereco buscar(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		
		return obj.orElseThrow(()->new ObjectNotFoundException(
				"Objeto não encontrado: "+"id: "+id+" Tipo:"+Endereco.class.getName()));
		
	}
	
	
}
