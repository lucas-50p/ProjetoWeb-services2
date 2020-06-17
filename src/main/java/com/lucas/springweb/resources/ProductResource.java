package com.lucas.springweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.springweb.entities.Product;
import com.lucas.springweb.services.ProductService;

/*Um endpoint de um web service é a URL 
 * onde seu serviço pode ser acessado por uma aplicação cliente.

	Uma API é um conjunto de rotinas, protocolos e 
	ferramentas para construir aplicações.*/
@RestController
@RequestMapping(value= "/products")//
public class ProductResource {

	@Autowired
	private ProductService service;
	
	/*acessar os usuarios*/
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		 List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	/*end point buscar usuario por id*/
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
	Product obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
	}
}
