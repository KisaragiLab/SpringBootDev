package com.kisaragiLab.demo.springboot.webApp.contollers.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kisaragiLab.demo.springboot.webApp.contollers.model.Todo;
import com.kisaragiLab.demo.springboot.webApp.services.TodoService;

import jakarta.validation.Valid;

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
        String username = (String)model.get("username");
        Todo todo = new Todo(0, username, "Default description", LocalDate.now().plusDays(14), false);
        model.put("todo", todo);
        return PREFIX + "/newTodo";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.POST)
    public String gotoTodoList(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return PREFIX + "/newTodo";
        }
        String username = (String)model.get("username");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusDays(15), false);
        return "redirect:list-todos";
    }

}
