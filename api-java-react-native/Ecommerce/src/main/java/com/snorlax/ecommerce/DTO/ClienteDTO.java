package com.snorlax.ecommerce.DTO;

import com.snorlax.ecommerce.model.Cliente;

public class ClienteDTO {
	private String nome;
	private String email;
	private String senha;
	//private byte[] fotoPerfil;
	
	
	public ClienteDTO(Cliente cliente) {
		super();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
		//this.fotoPerfil = cliente.getFotoPerfil();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*public byte[] getFotoPerfil() {
		return fotoPerfil;
	}
	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}*/
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}
