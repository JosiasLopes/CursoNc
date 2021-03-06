package com.cursonc.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursonc.demo.domain.Endereco;
import com.cursonc.demo.services.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")

//costuma-se usar o plural da 1° parte do nome da classe criada
public class EnderecoResource {

	@Autowired
	private EnderecoService catServ;
	//o resouce( camada rest) acessa o serviço
	//no padrão rest é importante atribuir os metodos
	//da classe aos metodos de requisição apropriados
	//por exemplo trazer dados com get, colocar dados com outros
	//metodos e etc
	//A classe Resource é o endpoint
	
	//O objeto ResponseEntity traz uma reposta de um request com todos os dados
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Endereco cat = catServ.buscar(id);
		return ResponseEntity.ok(cat);
	}
}
