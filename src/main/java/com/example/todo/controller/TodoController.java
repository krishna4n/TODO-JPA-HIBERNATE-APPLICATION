/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.todo.controller;

import java.util.ArrayList;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController{
    
    @Autowired
    private TodoJpaService todoJpaService;

    @GetMapping("/todos")
    public ArrayList<Todo> getAllTodos(){
        return todoJpaService.getAllTodos();
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo){
        return todoJpaService.addTodo(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id){
        return todoJpaService.getTodoById(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable("id") int id){
        return todoJpaService.updateTodo(todo, id);
    }

    @DeleteMapping("/todos/{id}")
    public ArrayList<Todo> deleteTodo(@PathVariable("id") int id){
        return todoJpaService.deleteTodo(id);
    }
}