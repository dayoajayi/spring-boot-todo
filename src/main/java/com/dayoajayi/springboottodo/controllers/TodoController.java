package com.dayoajayi.springboottodo.controllers;


import com.dayoajayi.springboottodo.models.TodoItem;
import com.dayoajayi.springboottodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    // fetch all todo items
    @GetMapping("/api/todoItems")
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {

//        List<TodoItem> todoItems =  todoService.findAll();
//
//        return ResponseEntity.ok(todoItems);

        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }
}
