package com.dayoajayi.springboottodo;

import com.dayoajayi.springboottodo.models.TodoItem;
import com.dayoajayi.springboottodo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootTodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(TodoRepository todoRepository) {
		return (args -> {
			todoRepository.save(new TodoItem("Add a new test case", true));
			todoRepository.save(new TodoItem("Make it fail", true));
			todoRepository.save(new TodoItem("Make changes to the code", true));
			todoRepository.save(new TodoItem("Make the test pass", true));
		});
	}
}
