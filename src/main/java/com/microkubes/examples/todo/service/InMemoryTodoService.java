package com.microkubes.examples.todo.service;

import com.microkubes.examples.todo.Todo;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryTodoService implements TodoService {

    private Map<String, Todo> todos = new ConcurrentHashMap<>();

    @Override
    public Todo getTodoById(String id) {
        Todo todo = todos.get(id);
        if (todo == null) {
            throw new ResourceNotFoundException(id);
        }
        return null;
    }

    @Override
    public Todo addTodo(Todo todo) {
        Todo existing = todos.get(todo.getId());
        if (existing != null){
            throw new BadRequestException("Already exists: " + todo.getId());
        }
        existing = todos.putIfAbsent(todo.getId(), todo);
        if (existing != null){
            throw new BadRequestException("Already exists: " + todo.getId());
        }
        return todo;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        Todo existing = getTodoById(todo.getId());
        existing.setTitle(todo.getTitle());
        existing.setContent(todo.getContent());
        existing.setTimestamp(todo.getTimestamp());

        todos.putIfAbsent(todo.getId(), existing);

        return existing;
    }

    @Override
    public List<Todo> getTodos(int page, int pageSize) {
        List<Todo> allTodos = new ArrayList<>();

        for(Map.Entry<String, Todo> entry: todos.entrySet()) {
            allTodos.add(entry.getValue());
        }

        Collections.sort(allTodos, new Comparator<Todo>() {
            @Override
            public int compare(Todo o1, Todo o2) {
                return o1.getTimestamp().compareTo(o2.getTimestamp());
            }
        });

        int start = (page - 1)*pageSize;
        if (start >= allTodos.size()) {
            return new LinkedList<>();
        }
        int end = start + pageSize;
        if (end >= allTodos.size()){
            end = allTodos.size()-1;
        }

        return allTodos.subList(start, end);
    }

    @Override
    public void removeTodo(String id) {
        Todo existing = getTodoById(id);
        todos.remove(existing.getId());
    }
}
