package com.dayoajayi.springboottodo.services;

import com.dayoajayi.springboottodo.models.TodoItem;
import com.dayoajayi.springboottodo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired // injecting the instantiated
    private TodoRepository todoRepo;

    public List<TodoItem> fetchAllTodoItems(){
        return todoRepo.fetchAllTodoItems();
    }
}
