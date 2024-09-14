package com.codingkraken.TodoApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingkraken.TodoApp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}