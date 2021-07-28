package com.snorlax.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snorlax.ecommerce.DTO.ClienteDTO;
import com.snorlax.ecommerce.DTO.ClienteInserirDTO;
import com.snorlax.ecommerce.model.Cliente;
import com.snorlax.ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	/*@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	public List<ClienteDTO> listar() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			ClienteDTO clienteDTO = new ClienteDTO(cliente);
			clientesDTO.add(clienteDTO);
		}
		return clientesDTO;
	}
	
	public ClienteDTO buscarPorEmailESenha(String email, String senha) {
		return new ClienteDTO(clienteRepository.findByEmailAndSenha(email, senha));
	}

	public ClienteDTO buscarPorId(Long id) {
		return new ClienteDTO(clienteRepository.getById(id));
	}

	@Transactional
	public List<ClienteDTO> burcarPorEmail(String email) {
		List<Cliente> clientes = clienteRepository.findAllByEmailContaining(email);
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			ClienteDTO clienteDTO = new ClienteDTO(cliente);
			clientesDTO.add(clienteDTO);
		}
		return clientesDTO;
	}

	public ClienteDTO inserir(ClienteInserirDTO clienteInserirDTO) {
		Cliente cliente = new Cliente(clienteInserirDTO);
		cliente.setSenha(clienteInserirDTO.getSenha());
		/*try {
			cliente.setFotoPerfil(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		clienteRepository.save(cliente);
		return new ClienteDTO(cliente);
	}

	@Transactional
	public ClienteDTO atualizar(ClienteInserirDTO clienteInserirDTO, Long id) {
			Cliente clienteAntigo = clienteRepository.findById(id).get();
			Cliente cliente = new Cliente();
			cliente.setId(clienteAntigo.getId());
			System.out.println(clienteInserirDTO.toString());
			//cliente.setFotoPerfil(clienteAntigo.getFotoPerfil());
			cliente.setEmail(clienteInserirDTO.getEmail());
			cliente.setNome(clienteInserirDTO.getNome());
			cliente.setRole("usuario");
			cliente.setSenha(clienteInserirDTO.getSenha());
			cliente = clienteRepository.save(cliente);
			return new ClienteDTO(cliente);
		
	}

	/*@Transactional
	public boolean atualizarFoto(MultipartFile file, Long id) {
		if (clienteRepository.existsById(id)) {
			Cliente cliente = clienteRepository.getById(id);
			try {
				cliente.setFotoPerfil(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cliente = clienteRepository.save(cliente);
			return true;
		} else {
			return false;
		}
	}*/

	public boolean deletar(Long id) {
		if (clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
