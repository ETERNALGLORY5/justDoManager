package com.todo.justdo.controllers;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.justdo.models.ToDo;
import com.todo.justdo.sevices.ToDoService;

@RestController
@RequestMapping("/justdo")
public class ToDoController {
	
	Logger logger = LoggerFactory.getLogger(ToDoController.class);
	
	Random random = new Random();
	@Autowired
	private ToDoService todoService ;
	
	//create todo handler
	@PostMapping
	public  ResponseEntity<ToDo> createTodoHandler(@RequestBody ToDo todo)
	{
		int id = random.nextInt(100);
		todo.setId(id);
		//create date with system default current date2023-01-25T11:25:56.400+00:00.
		Date currentDate = new Date();
		logger.info("Current date: {}", currentDate);
		todo.setAddedDate(currentDate);
		logger.info("dodo date {}",todo.getTodoDate());
		logger.info("Create todo");
		// call service to create todo
		//create
		ToDo todo1 = todoService.createToDo(todo);
		return new ResponseEntity<ToDo>(todo1, HttpStatus.CREATED);
	}
	
	//get all todo method
	
	@GetMapping
	public ResponseEntity<List<ToDo>> getAllToDoHandler()
	{
		List<ToDo> allToDos = todoService.getAllToDos();
		
		return new ResponseEntity<>(allToDos,  HttpStatus.OK);
	}
	
	
	//get single todo method
	@GetMapping("/{todoId}")
	public ResponseEntity<ToDo> getSingleToDoHandler(@PathVariable int todoId)
	{
		ToDo todo = todoService.getToDo(todoId);
		return  ResponseEntity.ok(todo);
	}
	
	
	
	// update single todo method
	@PutMapping("/{todoId}")
	public ResponseEntity<ToDo> updateToDoHandler(@RequestBody ToDo todoWithNewDetails, @PathVariable int todoId)
	{
		ToDo todo = todoService.updateToDo(todoId,todoWithNewDetails );
		return ResponseEntity.ok(todo);
		
	}
	
	
	@DeleteMapping("/{todoId}")
	public ResponseEntity<String> deleteTodo(@PathVariable int todoId)
	{
	todoService.deleteToDo(todoId);
	return ResponseEntity.ok("Successfully deleted.");
	}
	
}
