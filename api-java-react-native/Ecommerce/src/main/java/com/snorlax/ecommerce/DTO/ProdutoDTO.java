package com.snorlax.ecommerce.DTO;

import com.snorlax.ecommerce.model.Produto;

public class ProdutoDTO {
	private Long id;
	private String nome;
	private String descricao;
	private Integer quantidade;
	private String fotoProduto;
	private Boolean destacado;
	private Double valor;
	
	public ProdutoDTO(Produto produto) {
		super();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.fotoProduto = produto.getFotoProduto();
		this.valor = produto.getValor();
		this.destacado = produto.getDestacado();
		this.quantidade = produto.getQuantidadeEstoque();
		this.id = produto.getId();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getFotoProduto() {
		return fotoProduto;
	}

	public void setFotoProduto(String fotoProduto) {
		this.fotoProduto = fotoProduto;
	}

	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Boolean getDestacado() {
		return destacado;
	}
	public void setDestacado(Boolean destacado) {
		this.destacado = destacado;
	}
	
	
}
