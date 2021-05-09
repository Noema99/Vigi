package com.example.vigi.controllers;

import com.example.vigi.models.Todo;
import com.example.vigi.payload.request.TodoRequest;
import com.example.vigi.repository.TodoRepository;
import com.example.vigi.repository.UserRepository;
import com.example.vigi.security.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/todos")

public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    UserRepository userRepository;

    private TodoService todoService;

    @Autowired
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Todo> getTodo(@PathVariable String id) {
        return todoRepository.findById(id);
    }

    @PostMapping("/create")
    public String createTodo(@RequestBody TodoRequest todoRequest) {
        Todo todoAdded = new Todo(todoRequest.getId(), todoRequest.getTask(), todoRequest.getDate(),todoRequest.isDone(),todoRequest.getUser());
        todoRepository.save(todoAdded);
        userRepository.save(todoAdded.getUser());
        return "todos added : " + todoAdded.getTask()+" by "+todoAdded.getUser().getUsername();
    }

    @PutMapping("/update")
    public String updateTodo(@RequestBody Todo todoUpdated) {
        todoRepository.save(todoUpdated);

        return "todo updated : " + todoUpdated.getTask();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTodo(@RequestBody @PathVariable String id) {
        todoService.deleteTodo(id);
    }


    @PutMapping("/completeTodo/{id}")
    public String completeTodo( @PathVariable String id) {
       todoService.setTodoDone(id);
       return "todo is now done, its id is "+id;
    }

    @PutMapping("/incompleteTodo/{id}")
    public String incompleteTodo(@PathVariable String id) {
        todoService.setTodoUndone(id);
        return "todo is now undone, its id is "+id;
    }

    @GetMapping("/alldone")
    public List<Todo> getAllTodosDone(){
        return todoService.findDoneTodos();
    }

    @GetMapping("/todosByDate/{date}")
    public List<Todo> getTodosById(@PathVariable  @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return todoService.findTodosByDate(date);
    }


    @GetMapping("/allundone")
    public List<Todo> getAllTodosUndone(){
        return todoService.findUndoneTodos();
    }

    @DeleteMapping("/deleteByDate/{date}")
    public String deleteTodoByDate( @PathVariable  @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return todoService.deleteTodoByDate(date);
    }

    @DeleteMapping("/deleteByTask/{task}")
    public String deleteTodoByTask( @PathVariable String task){
        return todoService.deleteTodoByTask(task);
    }

}/*

  a revoir encore une fois.

    @DeleteMapping("/deleteByDate/{date}")
    public String deleteTodoByDate(@RequestBody @PathVariable Date date){
        System.out.println(date);
        todoRepository.deleteByDate(date);
        return "all todos are deleted on "+date;
    }
    @DeleteMapping("/deleteByTask/{task}")
    public String deleteTodoByTask(@RequestBody @PathVariable String task){
        System.out.println(task);
        todoRepository.deleteByTask(task);
        return "all todos are deleted on "+task;
    }
 */

