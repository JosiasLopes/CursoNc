package com.cursonc.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursonc.demo.domain.Cliente;
import com.cursonc.demo.repositories.ClienteRepository;
import com.cursonc.demo.services.exception.ObjectNotFoundException;

@Service
public class ClienteService{

	//a classe de serviço conversa com a Repository
	@Autowired
	private ClienteRepository repo;
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(()->new ObjectNotFoundException(
				"Objeto não encontrado: "+"id: "+id+" Tipo da classe :"+Cliente.class.getName()));
		
	}
	
	
}
