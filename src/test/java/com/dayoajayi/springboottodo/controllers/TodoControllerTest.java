package com.dayoajayi.springboottodo.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Test
    public void fetchAllTodoItems() {
        //todo: back-fill this test
    }

    @Test
    public void posting_a_new_todo_should_create_new_todoItem(){
        // given
        // request is received by controller


        // when
        // if request is POST

        // then
        // the todoService is called...

    }
}