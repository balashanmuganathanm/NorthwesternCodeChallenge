package com.bala.todolistmanagement.builder;

import org.springframework.stereotype.Component;

import com.bala.todolistmanagement.model.TodoItemCreateResponse;
import com.bala.todolistmanagement.model.TodoItemDO;
import com.bala.todolistmanagement.model.TodoListCreateResponse;
import com.bala.todolistmanagement.model.TodoListDO;

@Component
public class CreateResponseBuilder {

	public TodoListCreateResponse build(TodoListDO todoListDO)  {
		TodoListCreateResponse todoListCreateResponse = new TodoListCreateResponse();
		todoListCreateResponse.setListId(todoListDO.getListId());
		return todoListCreateResponse;
	}
	
	public TodoItemCreateResponse build(TodoItemDO todoItemDO)  {
		TodoItemCreateResponse todoItemCreateResponse = new TodoItemCreateResponse();
		todoItemCreateResponse.setItemId(todoItemDO.getItemId());
		return todoItemCreateResponse;
	}
}
