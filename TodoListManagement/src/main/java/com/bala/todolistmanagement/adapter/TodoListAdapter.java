package com.bala.todolistmanagement.adapter;

import java.util.List;
import com.bala.todolistmanagement.model.TodoItemDO;
import com.bala.todolistmanagement.model.TodoListDO;
import com.bala.todolistmanagement.model.TodoListResult;

public interface TodoListAdapter {

	public TodoListDO createTodoList(TodoListDO todoListDO); 
	public void updateTodoList(TodoListDO todoListDO);
	public void deleteTodoList(TodoListDO todoListDO);
	public TodoItemDO createTodoItem(TodoItemDO todoItemDO); 
	public void updateTodoItem(TodoItemDO todoItemDO);
	public void deleteTodoItem(TodoItemDO todoItemDO);
	public List<TodoListResult> getTodoList(); 
	
}
