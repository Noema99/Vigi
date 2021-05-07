package com.example.vigi.security.services;

import com.example.vigi.models.Todo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> findDoneTodos();
    List<Todo> findUndoneTodos();
    List<Todo> findTodosByDate(Date date);

    void setTodoDone(String id);
    void setTodoUndone(String id);

    Optional<Todo> getTodo(String id);

    String deleteTodoByDate(Date date);
    String deleteTodoByTask(String task);
    String deleteTodo(String id);
}
