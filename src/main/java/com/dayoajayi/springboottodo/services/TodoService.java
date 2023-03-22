package com.dayoajayi.springboottodo.services;

import com.dayoajayi.springboottodo.models.TodoItem;
import com.dayoajayi.springboottodo.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    public TodoItem save(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }
}
