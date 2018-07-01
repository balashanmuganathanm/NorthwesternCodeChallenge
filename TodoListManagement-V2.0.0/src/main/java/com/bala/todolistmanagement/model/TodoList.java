package com.bala.todolistmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todo_list")
public class TodoList extends Audit {
	private static final long serialVersionUID = -1174152827107792060L;

    @Id
    @GeneratedValue(generator = "list_seq_generator")
    @SequenceGenerator(
            name = "list_seq_generator",
            sequenceName = "list_seq",
            initialValue = 1000)
	private Long listId;

    @NotBlank
    @Size(min = 3, max = 100)
	private String category;

    @NotBlank
    @Column(columnDefinition = "text")
	private String description;
	
    @OneToMany(mappedBy = "listId", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
    private List<TodoItem> todoItems;

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

	public Long getListId() {
		return listId;
	}

	public void setListId(Long listId) {
		this.listId = listId;
	}

	public List<TodoItem> getTodoItems() {
		return todoItems;
	}

	public void setTodoItems(List<TodoItem> todoItems) {
		this.todoItems = todoItems;
	}
	
}
