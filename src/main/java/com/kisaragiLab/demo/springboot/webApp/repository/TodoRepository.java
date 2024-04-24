package com.kisaragiLab.demo.springboot.webApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kisaragiLab.demo.springboot.webApp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    public List<Todo> findByUsername(String username);

}
