package com.lucas.springweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucas.springweb.entities.Category;
import com.lucas.springweb.entities.Order;
import com.lucas.springweb.entities.User;
import com.lucas.springweb.entities.enums.OrderStatus;
import com.lucas.springweb.repositories.CategoryRepository;
import com.lucas.springweb.repositories.OrderRepository;
import com.lucas.springweb.repositories.UserRepository;


/*
 * @Component	Anotação genérica para qualquer componente gerenciado pelo Spring. Esta anotação faz com que o bean registrado no Spring possa ser utilizado em qualquer bean, seja ele um serviço, um DAO, um controller, etc. No nosso exemplo, ele será responsável por um Bean que representa uma entidade.
	@Repository	Anotação que serve para definir uma classe como pertencente à camada de persistência.
	@Service	Anotação que serve para definir uma classe como pertencente à camada de Serviço da aplicação.
	@Autowired	A anotação @ Autowired fornece controle sobre onde e como a ligação entre os beans deve ser realizada. Pode ser usado para em métodos setter, no construtor, em uma propriedade ou métodos com nomes arbitrários e / ou vários argumentos.*/

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;


	/*Como é uma interface precisa implementar, tudo que colocar nesse metodo vai ser executado*/
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WATING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WATING_PAYMENT, u1); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}



}
