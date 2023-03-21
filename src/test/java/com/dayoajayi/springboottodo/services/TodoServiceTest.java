package com.dayoajayi.springboottodo.services;

import com.dayoajayi.springboottodo.models.TodoItem;
import com.dayoajayi.springboottodo.repositories.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void getAllTodos() {

        TodoItem todoSample = new TodoItem("Sample todo", true);
        todoRepository.save(todoSample);
        TodoService todoService = new TodoService(todoRepository);

        List<TodoItem> todoList = todoService.findAll();
        TodoItem lastTodoItem = todoList.get(todoList.size() - 1);

        assertEquals(todoSample.getDescription(), lastTodoItem.getDescription());
    }
}