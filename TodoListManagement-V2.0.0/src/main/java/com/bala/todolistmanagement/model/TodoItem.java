package com.bala.todolistmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "todo_item")
public class TodoItem extends Audit{
	private static final long serialVersionUID = 8759496554685693439L;

	@Id
	@GeneratedValue(generator = "item_seq_generator")
	@SequenceGenerator(
	            name = "item_seq_generator",
	            sequenceName = "item_seq",
	            initialValue = 1000)
	private Long itemId;
	
    @NotBlank
    @Size(min = 3, max = 10)
	private String status;

    @NotBlank
    @Column(columnDefinition = "text")
	private String description;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TodoList listId;
    
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

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public TodoList getListId() {
		return listId;
	}

	public void setListId(TodoList listId) {
		this.listId = listId;
	}

	
}
