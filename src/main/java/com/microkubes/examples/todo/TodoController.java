package com.microkubes.examples.todo;


import com.microkubes.examples.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable("id") String id) {
        return todoService.getTodoById(id);
    }
}
