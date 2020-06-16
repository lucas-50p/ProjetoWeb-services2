package com.lucas.springweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.springweb.entities.Order;

/*@Repository	Anotação que serve para definir uma classe
 *  como pertencente à camada de persistência.*/

public interface OrderRepository extends JpaRepository<Order, Long>{

}
