package com.bonguyen.todospringapp.repository;

import com.bonguyen.todospringapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository < Todo, Long > {
    List<Todo> findByUsername(String user);

}
