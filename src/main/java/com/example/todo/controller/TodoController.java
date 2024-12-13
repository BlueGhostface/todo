package com.example.todo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.TodoItem;
import com.example.todo.repo.TodoRepo;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<TodoItem> findAll(){
        return todoRepo.findAll();

    }

    @PostMapping
    public TodoItem addnew(@RequestBody TodoItem todoitem){
        return todoRepo.save(todoitem);
    }

    @DeleteMapping("/{id}")
    public void DeleteTodo(@PathVariable UUID id){
        todoRepo.deleteById(id);
    }

    

}
