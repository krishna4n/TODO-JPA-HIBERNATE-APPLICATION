// Write your code here
package com.example.todo.repository;

import java.util.ArrayList;

import com.example.todo.model.Todo;

public interface TodoRepository{
    ArrayList<Todo> getAllTodos();
    Todo addTodo(Todo todo);
    Todo getTodoById(int id);
    Todo updateTodo(Todo todo, int id);
    ArrayList<Todo> deleteTodo(int id);
}