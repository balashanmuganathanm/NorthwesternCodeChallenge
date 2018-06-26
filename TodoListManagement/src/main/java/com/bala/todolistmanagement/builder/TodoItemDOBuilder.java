package com.bala.todolistmanagement.builder;

import org.springframework.stereotype.Component;

import com.bala.todolistmanagement.model.TodoItemCreateRequest;
import com.bala.todolistmanagement.model.TodoItemDO;
import com.bala.todolistmanagement.model.TodoItemModifyRequest;

@Component
public class TodoItemDOBuilder {

	public TodoItemDO build(TodoItemCreateRequest todoItemCreateRequest) {
		TodoItemDO todoItemDO = new TodoItemDO();
		todoItemDO.setListId(todoItemCreateRequest.getListId());
		todoItemDO.setStatus(todoItemCreateRequest.getStatus());
		todoItemDO.setDescription(todoItemCreateRequest.getDescription());
		return todoItemDO;
	}

	public TodoItemDO build(TodoItemModifyRequest todoItemModifyRequest, long itemId) {
		TodoItemDO todoItemDO = new TodoItemDO();
		todoItemDO.setItemId(itemId);
		todoItemDO.setStatus(todoItemModifyRequest.getStatus());
		todoItemDO.setDescription(todoItemModifyRequest.getDescription());
		return todoItemDO;
	}
	
	public TodoItemDO build(long itemId) {
		TodoItemDO todoItemDO = new TodoItemDO();
		todoItemDO.setItemId(itemId);
		return todoItemDO;
	}
	
	
}
