package com.snorlax.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.snorlax.ecommerce.DTO.CategoriaDTO;
import com.snorlax.ecommerce.DTO.CategoriaInserirDTO;
import com.snorlax.ecommerce.DTO.ProdutoDTO;
import com.snorlax.ecommerce.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listar() {
		return ResponseEntity.ok(categoriaService.listar());
	}

	@GetMapping("{nome}")
	public ResponseEntity<List<CategoriaDTO>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(categoriaService.buscarListaPorNome(nome));
	}
	
	@GetMapping("/produtos/{id}")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.listarProdutos(id));
    }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaDTO inserir(@RequestBody CategoriaInserirDTO categoriaIDTO) {
		return categoriaService.inserir(categoriaIDTO);
	}

	@PutMapping("{id}")
	public ResponseEntity<CategoriaDTO> atualizar(@PathVariable Long id, @RequestBody CategoriaInserirDTO categoriaIDTO) {
		CategoriaDTO categoriaDTO = categoriaService.atualizar(categoriaIDTO, id);
		if (categoriaDTO == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(categoriaDTO);
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		Boolean del = categoriaService.deletar(id);
		if (del) {
			return ResponseEntity.ok("Categoria deletada com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
