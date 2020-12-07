package com.cursonc.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursonc.demo.domain.Categoria;
import com.cursonc.demo.domain.Cidade;
import com.cursonc.demo.domain.Estado;
import com.cursonc.demo.domain.Produto;
import com.cursonc.demo.repositories.CategoriaRepository;
import com.cursonc.demo.repositories.CidadeRepository;
import com.cursonc.demo.repositories.EstadoRepository;
import com.cursonc.demo.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoncApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository repo;
	
	@Autowired
	ProdutoRepository produtoRepo;
	
	@Autowired
	CidadeRepository citRepo;
	
	@Autowired
	EstadoRepository estRepo;
	public static void main(String[] args) {
		SpringApplication.run(CursoncApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Produto p1 = new Produto(null,"Computador",2000.0);
		Produto p2 = new Produto(null,"Ipressoara",800.0);
		Produto p3 = new Produto(null,"Mouse",80.0);
		
		//adiciona os produtos ao objeto das categorias
		cat.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat.getProdutos().addAll(Arrays.asList(p2));
		
		//vincula as categorias aos produtos
		p1.getCategorias().addAll(Arrays.asList(cat));
		p2.getCategorias().addAll(Arrays.asList(cat,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat));
		
		Estado sp = new Estado(null,"São Paulo");
		Estado mg = new Estado(null,"Minas Gerais");
		Cidade Campinas = new Cidade(null,"Campinas",sp);
		Cidade Bh = new Cidade(null,"Belo Horizonte",mg);
		
		//é necessario interligar as duas entidades nesse caso o estado com a cidade
		//adiciona a cidade de campinas à lista de cidaddes do estado sp
		sp.getCidades().addAll(Arrays.asList(Campinas));
		mg.getCidades().addAll(Arrays.asList(Bh));
		
		
		
		repo.saveAll(Arrays.asList(cat,cat2));
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		estRepo.saveAll(Arrays.asList(sp,mg));
		citRepo.saveAll(Arrays.asList(Campinas,Bh));
		
		
	}

}
