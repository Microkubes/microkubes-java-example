package com.microkubes.examples.todo.service;

import com.microkubes.examples.todo.Todo;

import java.util.List;

public interface TodoService {
    Todo getTodoById(String id);
    Todo addTodo(Todo todo);
    Todo updateTodo(Todo todo);
    List<Todo> getTodos(int page, int pageSize);
    void removeTodo(String id);
}
