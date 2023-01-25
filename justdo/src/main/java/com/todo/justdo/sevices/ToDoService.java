package com.todo.justdo.sevices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.todo.justdo.models.ToDo;

@Component
public class ToDoService {
	Logger logger = LoggerFactory.getLogger(ToDoService.class);

	List<ToDo> todos = new ArrayList<>();

	
	
	public ToDo createToDo(ToDo todo)
	{
		//create ..
		todos.add(todo);
		logger.info("Todos {}" , this.todos);
		return todo;
		
	}

	public List<ToDo> getAllToDos() {
		return todos;		
	}

	public ToDo getToDo(int todoId) {
		
		ToDo todo = todos.stream().filter(t-> todoId == t.getId()).findAny().get();
		logger.info("ToDo :{} ",todo);
		return todo;
		
	}

	public ToDo updateToDo(int todoId, ToDo todo) {
		List<ToDo> newUpdateList= todos.stream().map(t -> {
			if(t.getId()==todoId) {
				t.setTitle(todo.getTitle());
				t.setContent(todo.getContent());
				t.setStatus(todo.getStatus());
				return t;
			}
			else {return t;}
			
		}).collect(Collectors.toList());
		
	//	List<ToDo> newUpdateList;
		todos=newUpdateList;
		todo.setId(todoId);;
		return todo;
		
	}

	
	public void deleteToDo(int todoId) {
		List<ToDo> newList= todos.stream()
				                        .filter(t ->t
			                            .getId()!=todoId)
				                        .collect(Collectors.toList());
		
		todos =newList;
	}

	
	
}
