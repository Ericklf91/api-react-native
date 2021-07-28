package com.snorlax.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snorlax.ecommerce.DTO.ProdutoDTO;
import com.snorlax.ecommerce.DTO.ProdutoInserirDTO;
import com.snorlax.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listar(){
		return ResponseEntity.ok(produtoService.listar());
	}
	@GetMapping("{nome}")
	public ResponseEntity<List<ProdutoDTO>> buscaPorNome(String nome){
		return ResponseEntity.ok(produtoService.listarPorNome(nome));
	}
	@GetMapping("/destacados")
	public ResponseEntity<List<ProdutoDTO>> listarPorDestaque() {
		return ResponseEntity.ok(produtoService.listarPorDestaque());
	}
	@PostMapping
	public ResponseEntity<ProdutoDTO> inserir(@RequestBody ProdutoInserirDTO produtoIDTO){
		return ResponseEntity.ok(produtoService.inserir(produtoIDTO));
	}
	@PutMapping("{id}")
	public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id, @RequestBody ProdutoInserirDTO produtoIDTO){
		ProdutoDTO produto = produtoService.atualizar(produtoIDTO, id);
		if(produto==null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(produto);
		}
	}
	/*@PutMapping("/foto/{id}")
	public ResponseEntity<String> atualizarFoto(@PathVariable Long id, @RequestParam MultipartFile file){
		Boolean att = produtoService.trocarFoto(id, file);
		if(att) {
			return ResponseEntity.ok("Foto trocada com sucesso");
		}else {
			return ResponseEntity.notFound().build();
		}
	}*/
	/*@PutMapping("/destaque/{id}")
	public ResponseEntity<String> destacar (@PathVariable Long id){
		Boolean att = produtoService.destacar(id);
		if(att) {
			return ResponseEntity.ok("Produto destacado");
		}else {
			return ResponseEntity.notFound().build();
		}
	}*/
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> apagar (@PathVariable Long id){
		Boolean del = produtoService.deletar(id);
		if(del) {
			return ResponseEntity.ok("Produto apagado");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
