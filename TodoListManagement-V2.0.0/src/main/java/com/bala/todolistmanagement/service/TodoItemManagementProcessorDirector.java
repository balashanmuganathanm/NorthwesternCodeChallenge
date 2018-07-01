package com.bala.todolistmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bala.todolistmanagement.exception.ResourceNotFoundException;
import com.bala.todolistmanagement.model.TodoItem;
import com.bala.todolistmanagement.repository.TodoItemRepository;
import com.bala.todolistmanagement.repository.TodoListRepository;

@Component
public class TodoItemManagementProcessorDirector implements TodoItemManagementProcessor{

	@Autowired 
	private TodoListRepository todoLisRepository;
	
	@Autowired 
	private TodoItemRepository todoItemRepository;
	
	@Override
	public TodoItem createTodoItem(Long listId, TodoItem todoItem) {
		   return todoLisRepository.findById(listId)
	                .map(todoList -> {
	                    todoItem.setListId(todoList);
	                    return todoItemRepository.save(todoItem);
	                }).orElseThrow(() -> new ResourceNotFoundException("List not found with id " + listId));
	}

	@Override
	public TodoItem updateTodoItem(Long itemId, TodoItem todoItemRequest) {
	     return todoItemRepository.findById(itemId)
	                .map(todoItem -> {
	                	todoItem.setStatus(todoItemRequest.getStatus());
	                	todoItem.setDescription(todoItemRequest.getDescription());
	                    return todoItemRepository.save(todoItem);
	                }).orElseThrow(() -> new ResourceNotFoundException("Item  not found with id " + itemId));
	  
	}

	@Override
	public void deleteTodoItem(Long itemId) {
	      todoItemRepository.findById(itemId)
	                .map(todoItem -> {
	                	todoItemRepository.delete(todoItem);
	                    return todoItem;
	                }).orElseThrow(() -> new  ResourceNotFoundException("Item  not found with id " + itemId));

	}

	@Override
	public TodoItem getTodoItem(Long itemId) {
		return todoItemRepository.findById(itemId)
		           .map(todoItem -> {
		           	   return todoItem;
		           }).orElseThrow(() -> new ResourceNotFoundException("Item  not found with id " + itemId));
	}
	
}
