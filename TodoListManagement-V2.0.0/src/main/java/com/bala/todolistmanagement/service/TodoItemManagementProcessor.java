package com.bala.todolistmanagement.service;

import com.bala.todolistmanagement.model.TodoItem;

public interface TodoItemManagementProcessor {
	public TodoItem createTodoItem(Long listId, TodoItem todoItem); 
	public TodoItem updateTodoItem(Long itemId, TodoItem todoItem);
	public void deleteTodoItem(Long itemId);
	public TodoItem getTodoItem(Long itemId); 
}
