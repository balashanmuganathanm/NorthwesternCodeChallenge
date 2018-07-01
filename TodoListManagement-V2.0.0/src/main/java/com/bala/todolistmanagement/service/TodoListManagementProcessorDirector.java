package com.bala.todolistmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bala.todolistmanagement.exception.ResourceNotFoundException;
import com.bala.todolistmanagement.model.TodoList;
import com.bala.todolistmanagement.repository.TodoListRepository;

@Component
public class TodoListManagementProcessorDirector implements TodoListManagementProcessor{

	@Autowired 
	private TodoListRepository todoListRepository;

	@Override
	public TodoList createTodoList(TodoList todoList) {
		return todoListRepository.save(todoList);
	}

	@Override
	public TodoList updateTodoList(Long listId, TodoList todoListRequest) {
	     return todoListRepository.findById(listId)
	                .map(todoList -> {
	                	todoList.setCategory(todoListRequest.getCategory());
	                	todoList.setDescription(todoListRequest.getDescription());
	                    return todoListRepository.save(todoList);
	                }).orElseThrow(() -> new ResourceNotFoundException("List not found with id " + listId));
	 
	}

	@Override
	public void deleteTodoList(Long listId) {
	       todoListRepository.findById(listId)
	                .map(todoList -> {
	                	todoListRepository.delete(todoList);
	                	return todoList;
	                }).orElseThrow(() -> new ResourceNotFoundException("List not found with id " + listId));
	}

	@Override
	public List<TodoList> getTodoList() {
		List<TodoList> todoLists = todoListRepository.findAll();
		
		if(todoLists.isEmpty()) {
			throw new ResourceNotFoundException("No List Found");
		}
	
		return todoLists;
	}

	@Override
	public TodoList getTodoList(Long listId) {
		return todoListRepository.findById(listId)
           .map(todoList -> {
           	   return todoList;
           }).orElseThrow(() -> new ResourceNotFoundException("List not found with id " + listId));
	}
}
