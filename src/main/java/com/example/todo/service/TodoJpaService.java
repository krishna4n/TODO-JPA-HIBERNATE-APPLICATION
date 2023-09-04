/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoJpaService implements TodoRepository{

    @Autowired
    private TodoJpaRepository todoJpaRepository;

	@Override
	public ArrayList<Todo> getAllTodos() {
		try{
			List<Todo> todoList = todoJpaRepository.findAll();
			ArrayList<Todo> todos = new ArrayList<>(todoList);
			return todos;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Todo addTodo(Todo todo) {
		todoJpaRepository.save(todo);
		return todo;
	}

	@Override
	public Todo getTodoById(int id) {
		try{
			Todo todo = todoJpaRepository.findById(id).get();
			return todo;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Todo updateTodo(Todo todo, int id) {
		try{
			Todo updatedTodo = todoJpaRepository.findById(id).get();
			if(todo.getTodo() != null){
				updatedTodo.setTodo(todo.getTodo());
			}
			if(todo.getStatus() != null){
				updatedTodo.setStatus(todo.getStatus());
			}
			if(todo.getPriority() != null){
				updatedTodo.setPriority(todo.getPriority());
			}

			todoJpaRepository.save(updatedTodo);
			return updatedTodo;

		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ArrayList<Todo> deleteTodo(int id) {
		try{
			todoJpaRepository.deleteById(id);
			return getAllTodos();
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

}
