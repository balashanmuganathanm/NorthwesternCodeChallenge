package com.bala.todolistmanagement.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoListModifyRequest implements Serializable{

	private static final long serialVersionUID = 3022259660457765066L;

	@NotNull
	//TODO: Add @Pattern 
	private long listId;
	
	@Size(max = 100)
	//TODO: Add @Pattern 
	private String category;
	 
	@Size(max = 1000)
	//TODO: Add @Pattern 
	private String description;

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}

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
