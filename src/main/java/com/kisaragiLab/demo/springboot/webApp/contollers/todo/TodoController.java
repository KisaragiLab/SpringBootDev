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

import jakarta.validation.Valid;

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
        return PREFIX + "/TodoList";
    }

    @RequestMapping(value="/list-todos", method=RequestMethod.POST)
    public String gotoNewTodo(ModelMap model) {
        return "redirect:add-todo";
    }

    @RequestMapping(value="/update-todo", method=RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return PREFIX + "/TodoDetails";
    }
    
    @RequestMapping(value="/update-todo", method=RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return PREFIX + "/TodoDetails";
        }
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value="/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.GET)
    public String showTodo(ModelMap model) {
        String username = (String)model.get("username");
        Todo todo = new Todo(0, username, "Default description", LocalDate.now().plusDays(14), false);
        model.put("todo", todo);
        return PREFIX + "/TodoDetails";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.POST)
    public String gotoTodoList(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return PREFIX + "/TodoDetails";
        }
        String username = (String)model.get("username");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusDays(15), false);
        return "redirect:list-todos";
    }

}
