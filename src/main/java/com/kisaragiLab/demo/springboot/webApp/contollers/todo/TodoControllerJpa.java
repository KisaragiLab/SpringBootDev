package com.kisaragiLab.demo.springboot.webApp.contollers.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

import com.kisaragiLab.demo.springboot.webApp.model.Todo;
import com.kisaragiLab.demo.springboot.webApp.repository.TodoRepository;

@Controller
@SessionAttributes("username")
public class TodoControllerJpa {

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    private static String PREFIX = "/webApp/todo";

    @RequestMapping(value="/list-todos", method=RequestMethod.GET)
    public String showTodoList(ModelMap model) {
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return PREFIX + "/TodoList";
    }

    @RequestMapping(value="/list-todos", method=RequestMethod.POST)
    public String gotoNewTodo(ModelMap model) {
        return "redirect:add-todo";
    }

    @RequestMapping(value="/update-todo", method=RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return PREFIX + "/TodoDetails";
    }
    
    @RequestMapping(value="/update-todo", method=RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return PREFIX + "/TodoDetails";
        }

        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value="/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.GET)
    public String showTodoDetails(ModelMap model) {
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0, username, "Default description", LocalDate.now().plusDays(14), false);
        model.put("todo", todo);
        return PREFIX + "/TodoDetails";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.POST)
    public String submitTodoDetails(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return PREFIX + "/TodoDetails";
        }

        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
