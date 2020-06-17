package com.lucas.springweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.springweb.entities.Category;

/*@Repository	Anotação que serve para definir uma classe
 *  como pertencente à camada de persistência.*/
/*Um repositório está vinculado à regra de negócio da aplicação e está associado
 *  ao agregado dos seus objetos de negócio e retorna objetos de domínio que representam esses dados.*/

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
