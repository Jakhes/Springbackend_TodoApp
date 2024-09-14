package com.codingkraken.TodoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingkraken.TodoApp.exception.UserNotFoundException;
import com.codingkraken.TodoApp.model.User;
import com.codingkraken.TodoApp.repo.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Integer id) {
        return userRepository.findById(
                id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}