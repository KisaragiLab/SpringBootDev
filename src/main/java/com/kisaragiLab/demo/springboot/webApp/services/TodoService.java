package com.kisaragiLab.demo.springboot.webApp.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kisaragiLab.demo.springboot.webApp.contollers.model.Todo;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<Todo>();
    static {
        todos.add(new Todo(1, "Kisaragi Lab", "AWS EC2", LocalDate.now().plusDays(14), false));
        todos.add(new Todo(2, "Kisaragi Lab", "AWS Auto scaling and ELB", LocalDate.now().plusDays(28), false));
        todos.add(new Todo(3, "Kisaragi Lab", "AWS Lamda", LocalDate.now().plusDays(50), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

}
