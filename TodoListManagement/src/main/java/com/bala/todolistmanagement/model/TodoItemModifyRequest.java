package com.bala.todolistmanagement.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoItemModifyRequest implements Serializable{

	private static final long serialVersionUID = 3621708564751413814L;

	@Size(max = 10)
	//TODO: Add @Pattern 
	private String status;

	@NotNull
	//TODO: Add @Pattern 
	private long itemId;
	
	@Size(max = 1000)
	//TODO: Add @Pattern 
	private String description;
	
	
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
