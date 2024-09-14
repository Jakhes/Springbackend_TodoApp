package com.codingkraken.TodoApp.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String password;

    @OneToMany(mappedBy = "assigned_user")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Todo> todos;

    public User(String name, String password, Set<Todo> todos) {
        this.name = name;
        this.password = password;
        this.todos = todos;
    }

    @PreRemove
    private void removeTodosFromUser() {
        for (Todo todo : todos) {
            todo.setAssigned_user(null);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
