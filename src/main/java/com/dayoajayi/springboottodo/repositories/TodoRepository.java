package com.dayoajayi.springboottodo.repositories;

import com.dayoajayi.springboottodo.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("todoRepository")
public interface TodoRepository extends JpaRepository<TodoItem, Long> {
}
