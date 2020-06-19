package com.lucas.springweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.springweb.entities.User;
import com.lucas.springweb.repositories.UserRepository;
import com.lucas.springweb.services.exceptions.ResourceNotFoundException;

/*
 * @Component	Anotação genérica para qualquer componente gerenciado pelo Spring. Esta anotação faz com que o bean registrado no Spring possa ser utilizado em qualquer bean, seja ele um serviço, um DAO, um controller, etc. No nosso exemplo, ele será responsável por um Bean que representa uma entidade.
	@Repository	Anotação que serve para definir uma classe como pertencente à camada de persistência.
	@Service	Anotação que serve para definir uma classe como pertencente à camada de Serviço da aplicação.
	@Autowired	A anotação @ Autowired fornece controle sobre onde e como a ligação entre os beans deve ser realizada. Pode ser usado para em métodos setter, no construtor, em uma propriedade ou métodos com nomes arbitrários e / ou vários argumentos.*/

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	/*Atualizar user service: antes return obj.get(), 500 erro obj não encontrado;
	 * mudei para orElseThrow: Ele vai tentar o get, se nõ tiver o usuario, vou lancar uma e exceção
	 * orElseThrow((): expressão lambda */
	public User findById(Long id){
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	/*Salvar o usuario*/
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	/*Deletar usuario*/
	public void delete(long id) {
		repository.deleteById(id);
	}
	
	/*getOne ele vai instanciar o usuario, deixar monitorado pelo jpa, em seguida fazer uma operação no banco de dados*/
	/*Atualizar usuario*/
	public User update(long id, User obj) {
		User entity = repository.getOne(id);
		upadateData(entity, obj);
		return repository.save(entity);
	}

	private void upadateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
