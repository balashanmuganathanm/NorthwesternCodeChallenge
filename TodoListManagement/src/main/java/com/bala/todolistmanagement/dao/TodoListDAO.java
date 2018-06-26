package com.bala.todolistmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bala.todolistmanagement.constants.SqlConstant;
import com.bala.todolistmanagement.model.TodoItemDO;
import com.bala.todolistmanagement.model.TodoListDO;
import com.bala.todolistmanagement.model.TodoListResult;

@Component
@Transactional
public class TodoListDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private RowMapper<TodoListDO> todoListDORowMapper;
	private RowMapper<TodoItemDO> todoItemDORowMapper;
	private RowMapper<TodoListResult> todoListResultRowMapper;
	
	//TODO:Move to config class
	public TodoListDAO() {
		todoListDORowMapper = new BeanPropertyRowMapper<TodoListDO>(TodoListDO.class);
		todoItemDORowMapper = new BeanPropertyRowMapper<TodoItemDO>(TodoItemDO.class);
		todoListResultRowMapper = new BeanPropertyRowMapper<TodoListResult>(TodoListResult.class);
	}
			
	public TodoListDO createTodoList(SqlParameterSource sqlParameterSource) {
		return DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(SqlConstant.CREATE_LIST_SQL, sqlParameterSource,
				todoListDORowMapper));
	}

	public TodoListDO updateTodoList(SqlParameterSource sqlParameterSource) {
		return DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(SqlConstant.UPDATE_LIST_SQL, sqlParameterSource,
				todoListDORowMapper));
	}
	
	public TodoListDO deleteTodoList(SqlParameterSource sqlParameterSource) {
		return DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(SqlConstant.DELETE_LIST_SQL, sqlParameterSource,
				todoListDORowMapper));
	}
	
	public TodoItemDO createTodoItem(SqlParameterSource sqlParameterSource) {
		return DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(SqlConstant.CREATE_ITEM_SQL, sqlParameterSource,
				todoItemDORowMapper));
	}
	
	public TodoItemDO updateTodoItem(SqlParameterSource sqlParameterSource) {
		return DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(SqlConstant.UPDATE_ITEM_SQL, sqlParameterSource,
				todoItemDORowMapper));
	}
	
	public TodoItemDO deleteTodoItem(SqlParameterSource sqlParameterSource) {
		return DataAccessUtils.singleResult(namedParameterJdbcTemplate.query(SqlConstant.DELETE_ITEM_SQL, sqlParameterSource,
				todoItemDORowMapper));
	}
	
	public List<TodoListResult> getTodoList() {
		return namedParameterJdbcTemplate.query(SqlConstant.GET_LIST_SQL, todoListResultRowMapper);
	}


}
