package com.microkubes.examples.todo;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @RequestMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable("id") String id) {
        return new Todo();
    }
}
