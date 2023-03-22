package com.dayoajayi.springboottodo.services;

import com.dayoajayi.springboottodo.models.TodoItem;
import com.dayoajayi.springboottodo.repositories.TodoRepository;
import org.junit.jupiter.api.AfterEach;
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

        // given
        TodoItem todoSample = new TodoItem("Sample todo", true);
        todoRepository.save(todoSample);
        TodoService todoService = new TodoService(todoRepository);

        // when
        TodoItem firstTodoItem = todoService.findAll().get(0);

        // then
        assertEquals(todoSample.getId(), firstTodoItem.getId());
        assertEquals(todoSample.getDescription(), firstTodoItem.getDescription());
        assertEquals(todoSample.isDone(), firstTodoItem.isDone());
    }

    @Test
    void saveATodoItem() {
        TodoService todoService = new TodoService(todoRepository);
        TodoItem todoSample = new TodoItem("sample Todo", true);

        todoService.save(todoSample);

        assertEquals(1, todoRepository.count());
    }

    @AfterEach
    void tearDown() {
        todoRepository.deleteAll();
    }
}