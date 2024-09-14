package com.codingkraken.TodoApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingkraken.TodoApp.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Integer> {

}
