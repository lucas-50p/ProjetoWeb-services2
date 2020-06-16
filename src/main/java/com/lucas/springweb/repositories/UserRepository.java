package com.lucas.springweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.springweb.entities.User;

/*@Repository	Anotação que serve para definir uma classe
 *  como pertencente à camada de persistência.*/
public interface UserRepository extends JpaRepository<User, Long>{

}
