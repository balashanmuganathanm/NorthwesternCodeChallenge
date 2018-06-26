package com.bala.todolistmanagement.builder;

import org.springframework.stereotype.Component;

import com.bala.todolistmanagement.model.TodoListCreateRequest;
import com.bala.todolistmanagement.model.TodoListDO;
import com.bala.todolistmanagement.model.TodoListModifyRequest;

@Component
public class TodoListDOBuilder {
	
		public TodoListDO build(TodoListCreateRequest todoListCreateRequest) {
			TodoListDO todoListDO = new TodoListDO();
			todoListDO.setCategory(todoListCreateRequest.getCategory());
			todoListDO.setDescription(todoListCreateRequest.getDescription());
			return todoListDO;
		}

		public TodoListDO build(TodoListModifyRequest todoListModifyRequest, long listId) {
			TodoListDO todoListDO = new TodoListDO();
			todoListDO.setListId(listId);
			todoListDO.setCategory(todoListModifyRequest.getCategory());
			todoListDO.setDescription(todoListModifyRequest.getDescription());
			return todoListDO;
		}
		
		public TodoListDO build(long listId) {
			TodoListDO todoListDO = new TodoListDO();
			todoListDO.setListId(listId);
			return todoListDO;
		}
}
