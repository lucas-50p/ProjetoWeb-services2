package com.lucas.springweb.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.springweb.entities.User;

/*Um endpoint de um web service é a URL 
 * onde seu serviço pode ser acessado por uma aplicação cliente.

	Uma API é um conjunto de rotinas, protocolos e 
	ferramentas para construir aplicações.*/
@RestController
@RequestMapping(value= "/users")//
public class UserResource {

	/*acessar os usuarios*/
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "Maria@gmail.com", "99999999", "123456");
		return ResponseEntity.ok().body(u);
	}
}
