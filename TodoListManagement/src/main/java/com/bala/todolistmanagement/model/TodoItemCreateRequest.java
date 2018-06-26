package com.bala.todolistmanagement.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoItemCreateRequest implements Serializable{

	private static final long serialVersionUID = -4807029046962823851L;

	@NotNull
	//TODO: Add @Pattern 
	private long listId;
	
	@NotNull
	@Size(max = 10)
	//TODO: Add @Pattern 
	private String status;
	
	@NotNull
	@Size(max = 1000)
	//TODO: Add @Pattern 
	private String description;

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
