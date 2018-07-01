package com.bala.todolistmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bala.todolistmanagement.model.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {}
