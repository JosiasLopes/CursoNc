package com.cursonc.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cursonc.demo.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer> {

}






