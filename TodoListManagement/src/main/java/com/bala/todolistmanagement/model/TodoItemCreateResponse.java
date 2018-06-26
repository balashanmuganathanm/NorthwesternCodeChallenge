package com.bala.todolistmanagement.model;

import java.io.Serializable;

public class TodoItemCreateResponse implements Serializable{

	private static final long serialVersionUID = -9013255311084512683L;

	private long itemId;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
}
