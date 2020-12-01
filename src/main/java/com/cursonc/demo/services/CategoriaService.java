package com.cursonc.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursonc.demo.domain.Categoria;
import com.cursonc.demo.repositories.CategoriaRepository;
import com.cursonc.demo.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService{

	//a classe de serviço conversa com a Repository
	@Autowired
	private CategoriaRepository repo;
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		//if(obj.isPresent()) {
		//	return obj.get();
		//}else {
			
	//	}
		return obj.orElseThrow(()->new ObjectNotFoundException(
				"Objeto não encontrado: "+"id: "+id+" Tipo:"+Categoria.class.getName()));
		
	}
	
	
}
