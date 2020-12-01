package com.cursonc.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursonc.demo.domain.Categoria;
import com.cursonc.demo.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoncApplication implements CommandLineRunner{
	
	@Autowired
	CategoriaRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(CursoncApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		repo.saveAll(Arrays.asList(cat,cat2));
		
	}

}
