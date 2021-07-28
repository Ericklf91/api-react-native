package com.snorlax.ecommerce.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.snorlax.ecommerce.DTO.ProdutoInserirDTO;

@Entity
public class Produto {

	@Id
	@Column(name = "id_produto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;
	private String fotoProduto;
	private Integer quantidadeEstoque;
	private Double valor;
	private Boolean destacado;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
	private Categoria categoria;

	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(ProdutoInserirDTO produtoInserirDTO) {
		super();
		this.nome = produtoInserirDTO.getNome();
		this.descricao = produtoInserirDTO.getDescricao();
		this.quantidadeEstoque = produtoInserirDTO.getQuantidade();
		this.valor = produtoInserirDTO.getValor();
		this.destacado = produtoInserirDTO.getDestacado();
		this.fotoProduto = produtoInserirDTO.getFotoProduto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	public Boolean getDestacado() {
		return destacado;
	}

	public void setDestacado(Boolean destacado) {
		this.destacado = destacado;
	}
	
}
