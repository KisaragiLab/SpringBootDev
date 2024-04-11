package com.kisaragiLab.demo.springboot.webApp.contollers.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kisaragiLab.demo.springboot.webApp.contollers.model.Todo;
import com.kisaragiLab.demo.springboot.webApp.contollers.services.TodoService;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private static String PREFIX = "/webApp/todo";

    @RequestMapping(value="/list-todos")
    public String todo(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("Kisaragi Lab");
        model.addAttribute("todos", todos);
        return PREFIX + "/Todo";
    }

}
