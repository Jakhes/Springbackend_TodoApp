package com.codingkraken.TodoApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.codingkraken.TodoApp.repo.TodoRepository;

@SpringBootApplication(scanBasePackages = { "controller", "service", "model", "repository" })
@ComponentScan(basePackageClasses = TodoResource.class)
public class TodoAppApplication implements CommandLineRunner {

	private final TodoRepository todoRepository;

	public TodoAppApplication(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			todoRepository.findAll().forEach(todo -> {
				System.out.println(todo.toString());
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}