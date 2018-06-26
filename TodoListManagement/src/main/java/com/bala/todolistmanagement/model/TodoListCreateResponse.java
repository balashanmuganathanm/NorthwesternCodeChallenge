package com.bala.todolistmanagement.model;

import java.io.Serializable;

public class TodoListCreateResponse implements Serializable{

	private static final long serialVersionUID = 3835846746883323079L;

	private long listId;

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}
}
