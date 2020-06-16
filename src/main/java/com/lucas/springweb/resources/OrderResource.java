package com.lucas.springweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.springweb.entities.Order;
import com.lucas.springweb.services.OrderService;

/*Um endpoint de um web service é a URL 
 * onde seu serviço pode ser acessado por uma aplicação cliente.

	Uma API é um conjunto de rotinas, protocolos e 
	ferramentas para construir aplicações.*/
@RestController
@RequestMapping(value= "/orders")//
public class OrderResource {

	@Autowired
	private OrderService service;
	
	/*acessar os usuarios*/
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		 List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	/*end point buscar usuario por id*/
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
	Order obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
	}
}
