package com.kisaragiLab.demo.springboot.webApp.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.function.Predicate;
import org.springframework.stereotype.Service;

import com.kisaragiLab.demo.springboot.webApp.model.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {

    private static int TODO_COUNT = 0;
    private static List<Todo> todos = new ArrayList<Todo>();
    static {
        todos.add(new Todo(++TODO_COUNT, "KisaragiLab", "AWS EC2", LocalDate.now().plusDays(14), false));
        todos.add(new Todo(++TODO_COUNT, "KisaragiLab", "AWS Auto scaling and ELB", LocalDate.now().plusDays(28), false));
        todos.add(new Todo(++TODO_COUNT, "KisaragiLab", "AWS Lamda", LocalDate.now().plusDays(50), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++TODO_COUNT, username, description, targetDate, done); 
        todos.add(todo);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById((int)todo.getId());
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

}
