package com.bala.todolistmanagement.model;

import java.io.Serializable;
import java.util.List;

public class TodoListRetrieveResponse implements Serializable{

	private static final long serialVersionUID = -1118248507665539441L;

	private List<TodoList> todoLists;

	public List<TodoList> getTodoLists() {
		return todoLists;
	}

	public void setTodoLists(List<TodoList> todoLists) {
		this.todoLists = todoLists;
	}
}
