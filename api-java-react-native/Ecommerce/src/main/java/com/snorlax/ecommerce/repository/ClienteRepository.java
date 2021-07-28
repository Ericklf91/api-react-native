package com.snorlax.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snorlax.ecommerce.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findAllByEmailContaining(String email);
	Cliente findByEmailAndSenha(String email, String senha);
}
