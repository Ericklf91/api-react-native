package com.snorlax.ecommerce.DTO;

public class ProdutoInserirDTO {
	private String nome;
	private String descricao;
	private Integer quantidade;
	private Double valor;
	private Long id_categoria;
	private Boolean destacado; 
	private String fotoProduto;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ProdutoInserirDTO(String nome, String descricao, Integer quantidade, Double valor, Long id_categoria,
			Boolean destacado, String fotoProduto) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		this.id_categoria = id_categoria;
		this.destacado = destacado;
		this.fotoProduto = fotoProduto;
	}
	
	public Long getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}
	public Boolean getDestacado() {
		return destacado;
	}
	public void setDestacado(Boolean destacado) {
		this.destacado = destacado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public String getFotoProduto() {
		return fotoProduto;
	}
	public void setFotoProduto(String fotoProduto) {
		this.fotoProduto = fotoProduto;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Long getIdCategoria() {
		return id_categoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.id_categoria = idCategoria;
	}
	
	
}
