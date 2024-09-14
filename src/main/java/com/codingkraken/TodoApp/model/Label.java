package com.codingkraken.TodoApp.model;

import java.io.Serializable;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "labels")
@Getter
@Setter
@NoArgsConstructor
public class Label implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "labels")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Todo> todos = new HashSet<>();

    @PreRemove
    private void removeTodosFromLabels() {
        for (Todo todo : todos) {
            todo.getLabels().remove(this);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}