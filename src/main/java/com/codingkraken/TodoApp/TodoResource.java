package com.codingkraken.TodoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codingkraken.TodoApp.model.Todo;
import com.codingkraken.TodoApp.model.Label;
import com.codingkraken.TodoApp.model.User;
import com.codingkraken.TodoApp.service.LabelService;
import com.codingkraken.TodoApp.service.TodoService;
import com.codingkraken.TodoApp.service.UserService;

@Controller

@RequestMapping(path = "/todo")
public class TodoResource {
    @Autowired
    private final TodoService todoService;
    @Autowired
    private final LabelService labelService;
    @Autowired
    private final UserService userService;

    public TodoResource(TodoService todoService, LabelService labelService, UserService userService) {
        this.todoService = todoService;
        this.labelService = labelService;
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Todo>> getAllTodos() {
        Iterable<Todo> todos = todoService.findAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Integer id) {
        Todo todo = todoService.findTodoById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {

        Todo newTodo = todoService.addTodo(todo, labelService, userService);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);

    }

    @PutMapping(path = "/update")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(todo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);

    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Integer id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping(path = "/all/label")
    public ResponseEntity<Iterable<Label>> getAllLabels() {
        Iterable<Label> labels = labelService.findAllLabels();
        return new ResponseEntity<>(labels, HttpStatus.OK);
    }

    @GetMapping(path = "/find/label/{id}")
    public ResponseEntity<Label> getLabelById(@PathVariable("id") Integer id) {
        Label label = labelService.findLabelById(id);
        return new ResponseEntity<>(label, HttpStatus.OK);
    }

    @PostMapping(path = "/add/label")
    public ResponseEntity<Label> addLabel(@RequestBody Label label) {
        Label newLabel = labelService.addLabel(label);
        return new ResponseEntity<>(newLabel, HttpStatus.CREATED);

    }

    @PutMapping(path = "/update/label")
    public ResponseEntity<Label> updateLabel(@RequestBody Label label) {
        Label updatedLabel = labelService.updateLabel(label);
        return new ResponseEntity<>(updatedLabel, HttpStatus.OK);

    }

    @DeleteMapping(path = "/delete/label/{id}")
    public ResponseEntity<?> deleteLabel(@PathVariable("id") Integer id) {
        labelService.deleteLabel(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping(path = "/all/user")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path = "/find/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/add/user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @PutMapping(path = "/update/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    @DeleteMapping(path = "/delete/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
