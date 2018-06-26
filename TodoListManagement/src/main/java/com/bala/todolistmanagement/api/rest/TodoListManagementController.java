package com.bala.todolistmanagement.api.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bala.todolistmanagement.model.TodoItemCreateRequest;
import com.bala.todolistmanagement.model.TodoItemCreateResponse;
import com.bala.todolistmanagement.model.TodoItemModifyRequest;
import com.bala.todolistmanagement.model.TodoListCreateRequest;
import com.bala.todolistmanagement.model.TodoListCreateResponse;
import com.bala.todolistmanagement.model.TodoListModifyRequest;
import com.bala.todolistmanagement.model.TodoListRetrieveResponse;
import com.bala.todolistmanagement.service.TodoListManagementProcessor;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "TodoListManagement/v1.0.0")
@Api(tags = {"Todo List Management"})
public class TodoListManagementController {

	@Autowired 
	private TodoListManagementProcessor todoListManagementProcessorDirector;
	
   @RequestMapping(value = "/list",
	            method = RequestMethod.POST,
	            consumes = {"application/json", "application/xml"},
	            produces = {"application/json", "application/xml"})
   @ApiOperation(value = "Create a Todo List")
   public ResponseEntity<TodoListCreateResponse> createTodoList(@Valid @RequestBody TodoListCreateRequest todoListCreateRequest) {
		return new ResponseEntity<TodoListCreateResponse>(todoListManagementProcessorDirector.createTodoList(todoListCreateRequest),
				HttpStatus.CREATED);
	}

    @RequestMapping(value = "/list/{listId}",
           method = RequestMethod.POST,
           consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a Todo List")
	public void updateTodoList(@Valid @RequestBody TodoListModifyRequest todoListModifyRequest, @PathVariable(value = "listId") long listId) {
       	todoListManagementProcessorDirector.updateTodoList(todoListModifyRequest, listId);
	}

    @RequestMapping(value = "/list/{listId}",
           method = RequestMethod.DELETE,
           consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a Todo List")
	public void deleteTodoList(@PathVariable(value = "listId") long listId) {
    	todoListManagementProcessorDirector.deleteTodoList(listId);
	}

    @RequestMapping(value = "/item",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ApiOperation(value = "Create a Todo Item")
	public ResponseEntity<TodoItemCreateResponse> createTodoItem(@Valid @RequestBody TodoItemCreateRequest todoItemCreateRequest) {
    	return new ResponseEntity<TodoItemCreateResponse>(todoListManagementProcessorDirector.createTodoItem(todoItemCreateRequest),
    			HttpStatus.CREATED);
	}

    @RequestMapping(value = "/item/{itemId}",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a Todo Item")
	public void updateTodoItem(@Valid @RequestBody TodoItemModifyRequest todoItemModifyRequest, @PathVariable(value = "itemId") long itemId) {
    	todoListManagementProcessorDirector.updateTodoItem(todoItemModifyRequest, itemId);
	}

    @RequestMapping(value = "/item/{itemId}",
            method = RequestMethod.DELETE,
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a Todo Item")
	public void deleteTodoItem(@PathVariable(value = "itemId") long itemId) {
    	todoListManagementProcessorDirector.deleteTodoItem(itemId);
	}

    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    @ApiOperation(value = "Get Todo List and item under a list")
	public ResponseEntity<TodoListRetrieveResponse> getTodoList() {
		return new ResponseEntity<TodoListRetrieveResponse>(todoListManagementProcessorDirector.getTodoList(),HttpStatus.OK);
	}
	
}
