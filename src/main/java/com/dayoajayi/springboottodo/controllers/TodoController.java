package com.dayoajayi.springboottodo.controllers;


import com.dayoajayi.springboottodo.models.TodoItem;
import com.dayoajayi.springboottodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080
@RestController
public class TodoController {

    /*
    * front-end             java server
    * HttpRequest ----->    Controller  ----> Service ----> Repository
    * front-end   <----     Controller  <----  Service <----
    *
    * */

    @Autowired
    private TodoService todoService;

    // fetch all todoItems
    @GetMapping("/api/todoItems")
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {

        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    // create a todoItem
    @PostMapping("/api/todoItems")
    public ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItem todoItem) {
        return new ResponseEntity<>(todoService.save(todoItem), HttpStatus.CREATED);
    }
}
