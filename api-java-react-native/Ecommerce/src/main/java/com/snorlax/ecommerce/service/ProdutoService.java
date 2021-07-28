package com.snorlax.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snorlax.ecommerce.DTO.ProdutoDTO;
import com.snorlax.ecommerce.DTO.ProdutoInserirDTO;
import com.snorlax.ecommerce.model.Produto;
import com.snorlax.ecommerce.repository.CategoriaRepository;
import com.snorlax.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<ProdutoDTO> listar() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		for (Produto produto : produtos) {
			ProdutoDTO produtoDTO = new ProdutoDTO(produto);
			produtosDTO.add(produtoDTO);
		}
		return produtosDTO;
	}

	public List<ProdutoDTO> listarPorNome(String nome) {
		List<Produto> produtos = produtoRepository.findAllByNomeContaining(nome);
		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		for (Produto produto : produtos) {
			ProdutoDTO produtoDTO = new ProdutoDTO(produto);
			produtosDTO.add(produtoDTO);
		}
		return produtosDTO;
	}

	public List<ProdutoDTO> listarPorDestaque() {
		List<Produto> produtos = produtoRepository.findAllByDestacadoTrue();
		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		for (Produto produto : produtos) {
			ProdutoDTO produtoDTO = new ProdutoDTO(produto);
			produtosDTO.add(produtoDTO);
		}
		return produtosDTO;
	}

	public ProdutoDTO inserir(ProdutoInserirDTO produtoIDTO) {
		Produto produto = new Produto(produtoIDTO);
		produto.setCategoria(categoriaRepository.getById(produtoIDTO.getIdCategoria()));
		produtoRepository.save(produto);
		return new ProdutoDTO(produto);
	}

	public ProdutoDTO atualizar(ProdutoInserirDTO produtoIDTO, Long id) {
		if (produtoRepository.existsById(id)) {
			Produto produto = produtoRepository.getById(id);
			produto.setNome(produtoIDTO.getNome());
			produto.setDescricao(produtoIDTO.getDescricao());
			produto.setValor(produtoIDTO.getValor());
			produto.setQuantidadeEstoque(produtoIDTO.getQuantidade());
			produto.setFotoProduto(produtoIDTO.getFotoProduto());
			produto.setDestacado(produtoIDTO.getDestacado());
			produtoRepository.save(produto);
			return new ProdutoDTO(produto);
		} else {
			return null;
		}
	}

	/*
	 * public Boolean destacar (Long id) { if(produtoRepository.existsById(id)) {
	 * Produto produto = produtoRepository.getById(id);
	 * produto.setDestacado(!produto.getDestacado());
	 * produtoRepository.save(produto); return true; }else { return false; } }
	 */

	/*
	 * public Boolean trocarFoto (Long id, MultipartFile file) {
	 * if(produtoRepository.existsById(id)) { Produto produto =
	 * produtoRepository.getById(id); try { produto.setFotoProduto(file.getBytes());
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } produtoRepository.save(produto); return true; }else {
	 * return false; } }
	 */

	public Boolean deletar(Long id) {
		if (produtoRepository.existsById(id)) {
			produtoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
