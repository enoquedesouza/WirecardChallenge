package com.wirecard.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wirecard.challenge.model.entity.EnderecoCliente;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoCliente, Long> {

}
