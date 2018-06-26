package com.bala.todolistmanagement.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bala.todolistmanagement.model.TodoItem;
import com.bala.todolistmanagement.model.TodoList;
import com.bala.todolistmanagement.model.TodoListResult;
import com.bala.todolistmanagement.model.TodoListRetrieveResponse;

@Component
public class TodoListRetrieveResponseBuilder {

	public TodoListRetrieveResponse build(List<TodoListResult> todoListResults) {
		TodoListRetrieveResponse todoListRetrieveResponse = new TodoListRetrieveResponse();
		List<TodoList> todoLists = new ArrayList<>();
		Map<Long, TodoList> listMap = new HashMap<>();
				
		for(TodoListResult todoListResult: todoListResults) {
			if(! listMap.containsKey(todoListResult.getListId()) ) {
				TodoList todoList = buildTodoList(todoListResult);
				listMap.put(todoListResult.getListId(), todoList);
				todoLists.add(todoList);
			}
			
			listMap.get(todoListResult.getListId()).getTodoItems().add(buildTodoItem(todoListResult));
			
		}
		
		todoListRetrieveResponse.setTodoLists(todoLists);
		return todoListRetrieveResponse;
	}
	
	private TodoList buildTodoList(TodoListResult todoListResult) {
		TodoList todoList = new TodoList();
		todoList.setCategory(todoListResult.getCategory());
		todoList.setCreatedTimestamp(todoListResult.getListCreatedTimestamp());
		todoList.setDescription(todoListResult.getListDescription());
		todoList.setLastUpdatedTimestamp(todoListResult.getListLastUpdatedTimestamp());
		todoList.setListId(todoListResult.getListId());
		List<TodoItem> todoItems = new ArrayList<>();
		todoList.setTodoItems(todoItems);
		return todoList;
	}
	
	private TodoItem buildTodoItem(TodoListResult todoListResult) {
		TodoItem todoItem = new TodoItem();
		todoItem.setStatus(todoListResult.getStatus());
		todoItem.setCreatedTimestamp(todoListResult.getItemCreatedTimestamp());
		todoItem.setDescription(todoListResult.getItemDescription());
		todoItem.setLastUpdatedTimestamp(todoListResult.getItemLastUpdatedTimestamp());
		todoItem.setItemId(todoListResult.getItemId());
		return todoItem;
	}
}
