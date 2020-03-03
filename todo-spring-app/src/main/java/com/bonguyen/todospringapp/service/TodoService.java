package com.bonguyen.todospringapp.service;

import com.bonguyen.todospringapp.model.Todo;
import com.bonguyen.todospringapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodosByUser(String user) {
        return todoRepository.findByUsername(user);
    }

    @Override
    public Optional<Todo> getTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate) {
        todoRepository.save(new Todo(name, desc, targetDate));
    }
    @Override
    public void deleteTodo(long id) {
        Optional <Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()){
            todoRepository.delete(todo.get());
        }
    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
