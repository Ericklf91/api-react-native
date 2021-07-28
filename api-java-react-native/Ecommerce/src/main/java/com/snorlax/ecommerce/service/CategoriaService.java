package com.snorlax.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snorlax.ecommerce.DTO.CategoriaDTO;
import com.snorlax.ecommerce.DTO.CategoriaInserirDTO;
import com.snorlax.ecommerce.DTO.ProdutoDTO;
import com.snorlax.ecommerce.model.Categoria;
import com.snorlax.ecommerce.model.Produto;
import com.snorlax.ecommerce.repository.CategoriaRepository;
import com.snorlax.ecommerce.repository.ProdutoRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	public CategoriaDTO inserir (CategoriaInserirDTO categoriaIDTO) {
		Categoria categoria = new Categoria(categoriaIDTO);
		categoriaRepository.save(categoria);
		return new CategoriaDTO(categoria);
	}
	
	public List<CategoriaDTO> listar(){
		List<Categoria> categorias = categoriaRepository.findAll();
		List<CategoriaDTO> categoriasDTO = new ArrayList<CategoriaDTO>();
		for (Categoria categoria : categorias) {
			categoria.setProdutos(produtoRepository.findAllByCategoria(categoria));
			CategoriaDTO categoriaDTO = new CategoriaDTO(categoriaRepository.save(categoria));
			categoriasDTO.add(categoriaDTO);
		}
		return categoriasDTO;
	}
	
	public List<ProdutoDTO> listarProdutos(Long id){
        List<Produto >produtos = produtoRepository.findAllByCategoria(categoriaRepository.getById(id));
        List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = new ProdutoDTO(produto);
            produtosDTO.add(produtoDTO);
        }
        return produtosDTO;
    }
	
	public CategoriaDTO buscaPorId(Long id){
		Categoria categoria = categoriaRepository.findById(id).get();
		CategoriaDTO categoriaDTO = new CategoriaDTO(categoria);
		return categoriaDTO;
	}
	
	public List<CategoriaDTO> buscarListaPorNome(String nome){
		List<Categoria> categorias = categoriaRepository.findAllByNomeContaining(nome);
		List<CategoriaDTO> categoriasDTO = new ArrayList<CategoriaDTO>();
		for (Categoria categoria : categorias) {
			categoria.setProdutos(produtoRepository.findAllByCategoria(categoria));
			CategoriaDTO categoriaDTO = new CategoriaDTO(categoria);
			categoriasDTO.add(categoriaDTO);
		}
		return categoriasDTO;
	}
	public CategoriaDTO atualizar(CategoriaInserirDTO categoriaIDTO, Long id) {
		if(categoriaRepository.existsById(id)) {
			Categoria categoria = categoriaRepository.findById(id).get();
			categoria.setId(id);
			categoria.setNome(categoriaIDTO.getNome());
			categoria.setDescricao(categoriaIDTO.getDescricao());
			categoria.setProdutos(produtoRepository.findAllByCategoria(categoria));
			return new CategoriaDTO(categoriaRepository.save(categoria));
		}else {
			return null;
		}
	}
	public Boolean deletar (Long id) {
		if(categoriaRepository.existsById(id)) {
			categoriaRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
