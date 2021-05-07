package com.example.vigi.security.services;

import com.example.vigi.models.Todo;
import com.example.vigi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public String deleteTodo(String id) {
        todoRepository.deleteById(id);
        return "todo deleted :" + id;
    }

    @Override
    public List<Todo> findDoneTodos() {
        List<Todo> allTodos= todoRepository.findAll();
        List<Todo> doneTodos=new ArrayList<>();
        for(Todo item: allTodos) {
            if(item.getDone()==true) {
                doneTodos.add(item);
            }
        }
        return doneTodos;
    }

    @Override
    public List<Todo> findUndoneTodos() {
        List<Todo> allTodos= todoRepository.findAll();
        List<Todo> undoneTodos=new ArrayList<>();
        for(Todo item: allTodos) {
            if(item.getDone()==false) {
                undoneTodos.add(item);
            }
        }
        return undoneTodos;
    }

    @Override
    public List<Todo> findTodosByDate(Date date) {
        List<Todo> allTodos= todoRepository.findAll();
        List<Todo> todosByDate=new ArrayList<>();
        for(Todo item: allTodos) {
            if(item.getDate().equals(date)) {
                todosByDate.add(item);
            }
        }
        return todosByDate;
    }


    @Override
    public Optional<Todo> getTodo(@PathVariable String id) {
        return todoRepository.findById(id);
    }

    @Override
    public void setTodoDone(String id) {
        List<Todo> allTodos= todoRepository.findAll();
        for(Todo item: allTodos) {
            if(item.getId().equals(id)) {
                item.setDone(true);
            }
            todoRepository.save(item);
        }
        return;
    }

    @Override
    public void setTodoUndone(String id) {
        List<Todo> allTodos= todoRepository.findAll();
        for(Todo item: allTodos) {
            if(item.getId().equals(id)) {
                item.setDone(false);
            }
            todoRepository.save(item);
        }
        return;

    }

    @Override
    public String deleteTodoByDate(Date date){
        List<Todo> allTodos= todoRepository.findAll();
        for(Todo item: allTodos) {
            if(item.getDate().equals(date)) {
                todoRepository.deleteById(item.getId());
            }
        }
        return "deleting todo done by its date"+date;
    }

    @Override
    public String deleteTodoByTask(String task){
        List<Todo> allTodos= todoRepository.findAll();
        for(Todo item: allTodos) {
            if(item.getTask().equals(task)) {
                todoRepository.deleteById(item.getId());
            }
        }
        return "deleting todo done"+task;
    }

}
