package com.bala.todolistmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bala.todolistmanagement.adapter.TodoListAdapter;
import com.bala.todolistmanagement.builder.CreateResponseBuilder;
import com.bala.todolistmanagement.builder.TodoItemDOBuilder;
import com.bala.todolistmanagement.builder.TodoListDOBuilder;
import com.bala.todolistmanagement.builder.TodoListRetrieveResponseBuilder;
import com.bala.todolistmanagement.model.TodoItemCreateRequest;
import com.bala.todolistmanagement.model.TodoItemCreateResponse;
import com.bala.todolistmanagement.model.TodoItemModifyRequest;
import com.bala.todolistmanagement.model.TodoListCreateRequest;
import com.bala.todolistmanagement.model.TodoListCreateResponse;
import com.bala.todolistmanagement.model.TodoListModifyRequest;
import com.bala.todolistmanagement.model.TodoListRetrieveResponse;

@Component
public class TodoListManagementProcessorDirector implements TodoListManagementProcessor{

	@Autowired
	private TodoListAdapter todoListAdapterImpl;
	
	@Autowired
	private CreateResponseBuilder createResponseBuilder;
	
	@Autowired
	private TodoListDOBuilder todoListDOBuilder;
	
	@Autowired
	private TodoItemDOBuilder todoItemDOBuilder;
	
	@Autowired 
	private TodoListRetrieveResponseBuilder todoListRetrieveResponseBuilder;
	
	@Override
	public TodoListCreateResponse createTodoList(TodoListCreateRequest todoListCreateRequest) {
		return createResponseBuilder.build(todoListAdapterImpl.createTodoList(todoListDOBuilder.build(todoListCreateRequest)));
	}

	@Override
	public void updateTodoList(TodoListModifyRequest todoListModifyRequest, long listId) {
		todoListAdapterImpl.updateTodoList(todoListDOBuilder.build(todoListModifyRequest, listId));
	}

	@Override
	public void deleteTodoList(long listId) { 
		todoListAdapterImpl.deleteTodoList(todoListDOBuilder.build(listId));
	}

	@Override
	public TodoItemCreateResponse createTodoItem(TodoItemCreateRequest todoItemCreateRequest) {
		return createResponseBuilder.build(todoListAdapterImpl.createTodoItem(todoItemDOBuilder.build(todoItemCreateRequest)));
	}

	@Override
	public void updateTodoItem(TodoItemModifyRequest todoItemModifyRequest, long itemId) {
		todoListAdapterImpl.updateTodoItem(todoItemDOBuilder.build(todoItemModifyRequest, itemId));
		
	}

	@Override
	public void deleteTodoItem(long itemId) {
		todoListAdapterImpl.deleteTodoItem(todoItemDOBuilder.build(itemId));
	}

	@Override
	public TodoListRetrieveResponse getTodoList() {
		return todoListRetrieveResponseBuilder.build(todoListAdapterImpl.getTodoList());
	}
	
	
}
