package com.snorlax.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snorlax.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	List<Categoria> findAllByNomeContaining (String nome);
}
