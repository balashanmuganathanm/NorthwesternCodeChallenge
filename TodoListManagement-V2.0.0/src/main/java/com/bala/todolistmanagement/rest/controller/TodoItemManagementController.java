package com.bala.todolistmanagement.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bala.todolistmanagement.model.TodoItem;
import com.bala.todolistmanagement.service.TodoItemManagementProcessor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "TodoListManagement/v2.0.0")
@Api(tags = {"Todo List Management"})
public class TodoItemManagementController {

	@Autowired 
	private TodoItemManagementProcessor todoItemManagementProcessorDirector;
	
    @RequestMapping(value = "/list/{listId}/item",
            method = RequestMethod.POST)
    @ApiOperation(value = "Create a Todo Item")
    @ResponseStatus(HttpStatus.CREATED)
	public TodoItem createTodoItem(@PathVariable(value = "listId") Long listId, @Valid @RequestBody TodoItem todoItem) {
    	return todoItemManagementProcessorDirector.createTodoItem(listId, todoItem);
	}
      
    @RequestMapping(value = "/item/{itemId}",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a Todo Item")
	public TodoItem updateTodoItem(@PathVariable(value = "itemId") Long itemId, @Valid @RequestBody TodoItem todoItem) {
    	return todoItemManagementProcessorDirector.updateTodoItem(itemId, todoItem);
	}

    @RequestMapping(value = "/item/{itemId}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a Todo Item")
	public void deleteTodoItem(@PathVariable(value = "itemId") Long itemId) {
    	todoItemManagementProcessorDirector.deleteTodoItem(itemId);
	}

    @RequestMapping(value = "/item/{itemId}",
            method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Todo item")
	public TodoItem getTodoItem(@PathVariable(value = "itemId") Long itemId) {
    	return todoItemManagementProcessorDirector.getTodoItem(itemId);
    }
	
}
