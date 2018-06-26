package com.bala.todolistmanagement.model;

public class TodoListResult {

	private String category;

	private String listDescription;
	
	private long listId;
	
	private String listCreatedTimestamp;
	
	private String listLastUpdatedTimestamp;
	
	private String status;

	private String itemDescription;
	
	private long itemId;
	
	private String itemCreatedTimestamp;
	
	private String itemLastUpdatedTimestamp;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getListDescription() {
		return listDescription;
	}

	public void setListDescription(String listDescription) {
		this.listDescription = listDescription;
	}

	public long getListId() {
		return listId;
	}

	public void setListId(long listId) {
		this.listId = listId;
	}

	public String getListCreatedTimestamp() {
		return listCreatedTimestamp;
	}

	public void setListCreatedTimestamp(String listCreatedTimestamp) {
		this.listCreatedTimestamp = listCreatedTimestamp;
	}

	public String getListLastUpdatedTimestamp() {
		return listLastUpdatedTimestamp;
	}

	public void setListLastUpdatedTimestamp(String listLastUpdatedTimestamp) {
		this.listLastUpdatedTimestamp = listLastUpdatedTimestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemCreatedTimestamp() {
		return itemCreatedTimestamp;
	}

	public void setItemCreatedTimestamp(String itemCreatedTimestamp) {
		this.itemCreatedTimestamp = itemCreatedTimestamp;
	}

	public String getItemLastUpdatedTimestamp() {
		return itemLastUpdatedTimestamp;
	}

	public void setItemLastUpdatedTimestamp(String itemLastUpdatedTimestamp) {
		this.itemLastUpdatedTimestamp = itemLastUpdatedTimestamp;
	}
	
	

}
