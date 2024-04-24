package com.kisaragiLab.demo.springboot.webApp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "Todo")
public class Todo {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "username")
    private String username;

    @Size(min=5, message="Enter at least 5 character(s)")
    private String description;
    
    private LocalDate targetDate;
    private boolean completed;

    public Todo() {}
    
    public Todo(long id, String username, String description, LocalDate targetDate, boolean completed) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate=" + targetDate + ", done=" + completed + "]";
    }

}
