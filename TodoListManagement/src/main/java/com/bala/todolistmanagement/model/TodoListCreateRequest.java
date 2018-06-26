package com.bala.todolistmanagement.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoListCreateRequest implements Serializable{

	private static final long serialVersionUID = 2860854485667640368L;

	@NotNull
	@Size(max = 100)
	//TODO: Add @Pattern 
	private String category;

	@NotNull
	@Size(max = 1000)
	//TODO: Add @Pattern 
	private String description;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
