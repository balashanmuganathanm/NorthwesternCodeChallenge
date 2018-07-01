package com.bala.todolistmanagement.service;

import java.util.List;
import com.bala.todolistmanagement.model.TodoList;

public interface TodoListManagementProcessor {
	public TodoList createTodoList(TodoList todoList); 
	public TodoList updateTodoList(Long listId, TodoList todoList);
	public void deleteTodoList(Long listId);
	public List<TodoList> getTodoList(); 
	public TodoList getTodoList(Long listId); 
}
