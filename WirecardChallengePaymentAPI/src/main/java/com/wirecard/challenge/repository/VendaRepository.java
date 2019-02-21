package com.wirecard.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirecard.challenge.model.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

	
}
