package com.snorlax.ecommerce.DTO;

public class ClienteInserirDTO {
	private String nome;
	private String email;
	private String role;
	private String senha;
	
	public ClienteInserirDTO(String nome, String email, String role, String senha) {
		super();
		this.nome = nome;
		this.email = email;
	    this.role = role;
		this.senha = senha;
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
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "ClienteInserirDTO [nome=" + nome + ", email=" + email + ", role=" + role + ", senha=" + senha + "]";
	}
	
	
}
