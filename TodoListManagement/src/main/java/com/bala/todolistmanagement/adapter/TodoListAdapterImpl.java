package com.bala.todolistmanagement.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bala.todolistmanagement.builder.SqlParameterSourceBuilder;
import com.bala.todolistmanagement.dao.TodoListDAO;
import com.bala.todolistmanagement.exception.ResourceNotFoundException;
import com.bala.todolistmanagement.model.TodoItemDO;
import com.bala.todolistmanagement.model.TodoListDO;
import com.bala.todolistmanagement.model.TodoListResult;

@Component
public class TodoListAdapterImpl implements TodoListAdapter{

	@Autowired
	private TodoListDAO todoListDAO;
	
	@Autowired
	private SqlParameterSourceBuilder sqlParameterSourceBuilder;
	
	@Override
	public TodoListDO createTodoList(TodoListDO todoListDO) {
		return todoListDAO.createTodoList(sqlParameterSourceBuilder.build(todoListDO));
	}

	@Override
	public void updateTodoList(TodoListDO todoListDO) {
		if (todoListDAO.updateTodoList(sqlParameterSourceBuilder.build(todoListDO)) == null) {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public void deleteTodoList(TodoListDO todoListDO) {
		if (todoListDAO.deleteTodoList(sqlParameterSourceBuilder.build(todoListDO)) == null) {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public TodoItemDO createTodoItem(TodoItemDO todoItemDO) {
		return todoListDAO.createTodoItem(sqlParameterSourceBuilder.build(todoItemDO));
	}

	@Override
	public void updateTodoItem(TodoItemDO todoItemDO) {
		if (todoListDAO.updateTodoItem(sqlParameterSourceBuilder.build(todoItemDO)) == null) {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public void deleteTodoItem(TodoItemDO todoItemDO) {
		if (todoListDAO.deleteTodoItem(sqlParameterSourceBuilder.build(todoItemDO)) == null) {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public List<TodoListResult> getTodoList() {
		List<TodoListResult> TodoListResults = todoListDAO.getTodoList();
	
		if (TodoListResults.isEmpty()) {
			throw new ResourceNotFoundException();
		}
		return TodoListResults;
	}

}
