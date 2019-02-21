package com.wirecard.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirecard.challenge.model.entity.ContatoCliente;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoCliente, Long> {

}
