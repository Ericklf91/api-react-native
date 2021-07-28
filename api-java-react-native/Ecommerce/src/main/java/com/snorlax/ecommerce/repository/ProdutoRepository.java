package com.snorlax.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snorlax.ecommerce.model.Categoria;
import com.snorlax.ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findAllByCategoria (Categoria categoria);
	List<Produto> findAllByNomeContaining (String nome);
	List<Produto> findAllByDestacadoTrue();
}
