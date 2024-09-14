package com.codingkraken.TodoApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingkraken.TodoApp.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
