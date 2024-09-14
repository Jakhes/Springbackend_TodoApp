package com.codingkraken.TodoApp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
public class Todo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private LocalDate creation_date;
    private LocalDate due_date;
    private Priority priority;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "todo_has_label", joinColumns = @JoinColumn(name = "todo_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "label_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("todos")
    private Set<Label> labels = new HashSet<Label>();

    @ManyToOne
    @JoinColumn(name = "todo_assignedTo_user", referencedColumnName = "id")
    @JsonIgnoreProperties("todos")
    private User assigned_user;

    private boolean isDone;

    public Todo(String name, LocalDate creation_date, LocalDate due_date, Priority priority, HashSet<Label> labels,
            User assigned_user, boolean isDone) {
        this.name = name;
        this.creation_date = creation_date;
        this.due_date = due_date;
        this.priority = priority;
        this.labels = labels;
        this.assigned_user = assigned_user;
        this.isDone = isDone;
    }

    @PreRemove
    private void removeUsersAndLabelsFromTasks() {

        assigned_user.getTodos().remove(this);

        for (Label label : labels) {
            label.getTodos().remove(this);
        }

    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id + '\'' +
                "name=" + name + '\'' +
                "created=" + creation_date + '\'' +
                "dueDate=" + due_date + '\'' +
                "priority=" + priority + '\'' +
                "labels=" + labels + '\'' +
                "user=" + assigned_user + '\'' +
                "isDone=" + isDone + '\'' +
                "}";
    }

}

enum Priority {
    P1, P2, P3, P4
}
