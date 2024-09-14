package com.codingkraken.TodoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingkraken.TodoApp.exception.TodoNotFoundException;
import com.codingkraken.TodoApp.model.Todo;
import com.codingkraken.TodoApp.model.User;
import com.codingkraken.TodoApp.model.Label;
import com.codingkraken.TodoApp.repo.TodoRepository;
import java.util.Set;
import java.util.HashSet;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addTodo(Todo todo, LabelService labelService, UserService userService) {
        Set<Label> mergedLabels = new HashSet<Label>();
        for (Label label : todo.getLabels()) {
            Label mergedLabel;
            if (label.getId() != null) {
                mergedLabel = labelService.findLabelById(label.getId());
            } else {
                mergedLabel = labelService.addLabel(label);
            }
            mergedLabels.add(mergedLabel);
        }
        User mergedUser;
        if (todo.getAssigned_user() != null) {
            mergedUser = userService.findUserById(todo.getAssigned_user().getId());
            todo.setAssigned_user(mergedUser);
        }
        todo.setLabels(mergedLabels);
        return todoRepository.save(todo);
    }

    public Iterable<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findTodoById(Integer id) {
        return todoRepository.findById(
                id)
                .orElseThrow(() -> new TodoNotFoundException("Todo by id " + id + " was not found."));
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }
}
