package com.cursonc.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursonc.demo.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")

//costuma-se usar o plural da 1° parte do nome da classe criada
public class CategoriaResource {

	//no padrão rest é importante atribuir os metodos
	//da classe aos metodos de requisição apropriados
	//por exemplo trazer dados com get, colocar dados com outros
	//metodos e etc
	@RequestMapping(method=RequestMethod.GET)
	public List listar() {
		
		Categoria cat1 = new Categoria(1,"informatica");
		Categoria cat2 = new Categoria(2,"escritório");
		List<Categoria> lista_categoria = new ArrayList<>();
		lista_categoria.add(cat1);
		lista_categoria.add(cat2);
		return lista_categoria;
	}
}
