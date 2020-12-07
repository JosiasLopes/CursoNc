package com.cursonc.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cursonc.demo.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {

}






