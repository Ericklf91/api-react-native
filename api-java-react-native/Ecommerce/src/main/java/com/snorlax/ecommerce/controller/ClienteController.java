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

import com.snorlax.ecommerce.DTO.ClienteDTO;
import com.snorlax.ecommerce.DTO.ClienteInserirDTO;
import com.snorlax.ecommerce.service.ClienteService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> listar (){
		return ResponseEntity.ok(clienteService.listar());
	}
	
	@GetMapping("{email}")
	public ResponseEntity<List<ClienteDTO>> buscarPorEmail(@PathVariable String email){
		return ResponseEntity.ok(clienteService.burcarPorEmail(email));
	}
	
	@GetMapping("/validar/{email}/{senha}")
	public ResponseEntity<ClienteDTO> buscarPorEmailESenha(@PathVariable String email, @PathVariable String senha){
		return ResponseEntity.ok(clienteService.buscarPorEmailESenha(email, senha));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Cadastrar um determinado cliente", notes = "Cadastrar cliente")
	public ClienteDTO inserir(@RequestBody ClienteInserirDTO clienteIDTO) {
		ClienteDTO clienteDTO = clienteService.inserir(clienteIDTO);
		return clienteDTO;
	}
	@PutMapping("{id}")
	public ResponseEntity<ClienteDTO> atualizar (@PathVariable Long id, @RequestBody ClienteInserirDTO clienteInserirDTO) {
		ClienteDTO att = clienteService.atualizar(clienteInserirDTO, id);
		if(att.equals(null)){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(att);
	}
	
	/*@PutMapping("trocarFoto/{id}")
	public ResponseEntity<String> atualizarFoto (@PathVariable Long id, @RequestParam MultipartFile file){
		boolean att = clienteService.atualizarFoto(file, id);
		if(att) {
		return ResponseEntity.ok("Foto atualizada com sucesso!!!");
		}else {
			return ResponseEntity.notFound().build();
		}
	}*/
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id){
		boolean del = clienteService.deletar(id);
		if(del) {
			return ResponseEntity.ok("Cliente deletado");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
