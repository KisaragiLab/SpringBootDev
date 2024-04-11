package com.kisaragiLab.demo.springboot.webApp.contollers.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kisaragiLab.demo.springboot.webApp.contollers.model.Todo;
import com.kisaragiLab.demo.springboot.webApp.services.TodoService;

@Controller
@SessionAttributes("username")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private static String PREFIX = "/webApp/todo";

    @RequestMapping(value="/list-todos", method=RequestMethod.GET)
    public String todo(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("Kisaragi Lab");
        model.addAttribute("todos", todos);
        return PREFIX + "/Todo";
    }

    @RequestMapping(value="/list-todos", method=RequestMethod.POST)
    public String gotoNewTodo(ModelMap model) {
        return "redirect:add-todo";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.GET)
    public String newTodo(ModelMap model) {
        return PREFIX + "/newTodo";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.POST)
    public String gotoTodoList(ModelMap model) {
        return "redirect:list-todos";
    }

}
