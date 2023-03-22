package com.dayoajayi.springboottodo.controllers;

import com.dayoajayi.springboottodo.models.TodoItem;
import com.dayoajayi.springboottodo.services.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class TodoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test
    void getAllTodos() throws Exception {
        List<TodoItem> todoItems = new ArrayList<>();
        todoItems.add(new TodoItem(1L,"eat", true));
        todoItems.add(new TodoItem(2L,"sleep", true));
        when(todoService.findAll()).thenReturn(todoItems);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/todoItems")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", hasSize(2))).andDo(print());
    }

    @Test
    void createATodoItem() throws Exception {

        // given
        TodoItem sleepTodo = new TodoItem(1L, "Sleep 8 hours", true);
        when(todoService.save(any(TodoItem.class))).thenReturn(sleepTodo);

        ObjectMapper objectMapper = new ObjectMapper();
        String sleepTodoJson = objectMapper.writeValueAsString(sleepTodo);

        // when
        ResultActions result = mockMvc.perform(post("/api/todoItems")
                .contentType(MediaType.APPLICATION_JSON)
                .content(sleepTodoJson));

        // then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.description").value("Sleep 8 hours"))
                .andExpect(jsonPath("$.done").value(true));

    }
}