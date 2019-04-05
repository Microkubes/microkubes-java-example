package com.microkubes.examples.todo;


import com.microkubes.examples.todo.service.ServiceException;
import com.microkubes.examples.todo.service.TodoService;
import com.microkubes.tools.security.Auth;
import com.microkubes.tools.security.spring.AuthenticationHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    private Auth getAuth(Authentication authentication) {
        if(! (authentication instanceof AuthenticationHolder)){
            throw new ServiceException("Authentication is not AuthenticationHolder.");
        }
        return ((AuthenticationHolder)authentication).getAuth();
    }

    @RequestMapping("/todo/{id}")
    @ResponseBody
    public Todo getTodoById(@PathVariable("id") String id) {
        Todo todo = todoService.getTodoById(id);
        System.out.println("TODO: " + todo);
        return todo;
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    @ResponseBody
    public Todo addTodo(@RequestBody Todo todo, Authentication authentication){
        todo.setOwner(getAuth(authentication).getEmail());
        if(todo.getId() == null){
            todo.setId(UUID.randomUUID().toString());
        }
        return todoService.addTodo(todo);
    }
}
