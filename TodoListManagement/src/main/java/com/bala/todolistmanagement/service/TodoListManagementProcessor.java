package com.bala.todolistmanagement.service;

import com.bala.todolistmanagement.model.TodoItemCreateRequest;
import com.bala.todolistmanagement.model.TodoItemCreateResponse;
import com.bala.todolistmanagement.model.TodoItemModifyRequest;
import com.bala.todolistmanagement.model.TodoListCreateRequest;
import com.bala.todolistmanagement.model.TodoListCreateResponse;
import com.bala.todolistmanagement.model.TodoListModifyRequest;
import com.bala.todolistmanagement.model.TodoListRetrieveResponse;

public interface TodoListManagementProcessor {

	public TodoListCreateResponse createTodoList(TodoListCreateRequest todoListCreateRequest); 
	public void updateTodoList(TodoListModifyRequest todoListModifyRequest, long listId);
	public void deleteTodoList(long listId);
	public TodoItemCreateResponse createTodoItem(TodoItemCreateRequest todoItemCreateRequest); 
	public void updateTodoItem(TodoItemModifyRequest todoItemModifyRequest, long itemId);
	public void deleteTodoItem(long itemId);
	public TodoListRetrieveResponse getTodoList(); 
	
}
