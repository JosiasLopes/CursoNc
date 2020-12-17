package com.cursonc.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cursonc.demo.domain.Endereco;




@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

}






