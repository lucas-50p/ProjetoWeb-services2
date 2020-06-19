package com.lucas.springweb.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.springweb.entities.User;
import com.lucas.springweb.services.UserService;

/*Um endpoint de um web service é a URL 
 * onde seu serviço pode ser acessado por uma aplicação cliente.

	Uma API é um conjunto de rotinas, protocolos e 
	ferramentas para construir aplicações.*/
@RestController
@RequestMapping(value= "/users")//
public class UserResource {

	@Autowired
	private UserService service;
	
	/*acessar os usuarios*/
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		 List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	/*end point buscar usuario por id*/
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
	User obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	/*end point deletar
	 * noContent: vai retornar uma resposta vazia(204)
	 * 500 erro: quando usuario tem pedidos associados(constraintViolationException)
	 * 404 ERRO: não encontrado*/
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
