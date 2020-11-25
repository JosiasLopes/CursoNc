package com.cursonc.demo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categorias")

//costuma-se usar o plural da 1° parte do nome da classe criada
public class CategoriaResource {

	//no padrão rest é importante atribuir os metodos
	//da classe aos metodos de requisição apropriados
	//por exemplo trazer dados com get, colocar dados com outros
	//metodos e etc
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "REST esta funcionando";
	}
}
