package com.bala.todolistmanagement.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.bala.todolistmanagement.model.TodoList;

import com.bala.todolistmanagement.service.TodoListManagementProcessor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "TodoListManagement/v2.0.0")
@Api(tags = {"Todo List Management"})
public class TodoListManagementController {

	@Autowired 
	private TodoListManagementProcessor todoListManagementProcessorDirector;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get All Todo List and item under a list")
	public List<TodoList> getTodoList() {
		return todoListManagementProcessorDirector.getTodoList();
	}
   
   @RequestMapping(value = "/list/{listId}", method = RequestMethod.GET)
   @ResponseStatus(HttpStatus.OK)
   @ApiOperation(value = "Get Todo List and item under a list")
   public TodoList getTodoList(@PathVariable(value = "listId") Long listId) {
		return todoListManagementProcessorDirector.getTodoList(listId);
	}

   @RequestMapping(value = "/list",method = RequestMethod.POST)
   @ResponseStatus(HttpStatus.CREATED)
   @ApiOperation(value = "Create a Todo List")
	public TodoList createTodoList(@Valid @RequestBody TodoList todoList) {
      	return todoListManagementProcessorDirector.createTodoList(todoList);
	}
   
    @RequestMapping(value = "/list/{listId}",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a Todo List")
	public TodoList updateTodoList(@PathVariable(value = "listId") Long listId, @Valid @RequestBody TodoList todoList) {
       	return todoListManagementProcessorDirector.updateTodoList(listId,todoList);
	}

    @RequestMapping(value = "/list/{listId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a Todo List")
	public void deleteTodoList(@PathVariable(value = "listId") long listId) {
    	todoListManagementProcessorDirector.deleteTodoList(listId);
	}


}
