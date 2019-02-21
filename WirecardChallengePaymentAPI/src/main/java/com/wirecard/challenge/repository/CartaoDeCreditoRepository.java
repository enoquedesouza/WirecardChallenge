package com.wirecard.challenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirecard.challenge.model.entity.CartaoDeCredito;


@Repository
public interface CartaoDeCreditoRepository extends JpaRepository<CartaoDeCredito, Long> {
	
	Optional<CartaoDeCredito> findByNumero(String numero);
	
}
