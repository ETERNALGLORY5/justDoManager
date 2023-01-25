package com.todo.justdo.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ToDo {

	
	private int id;
	private String title;
	private String content;
	private String status;
	private Date addedDate;
	@JsonFormat(pattern ="dd/mm/yy")
	private Date todoDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public Date getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(Date todoDate) {			
		this.todoDate = todoDate;
	}
    public ToDo() {
		
	}
	public ToDo(int id, String title, String content, String status, Date addedDate, Date todoDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.status = status;
		this.addedDate = addedDate;
		this.todoDate = todoDate;
	}
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", title=" + title + ", content=" + content + ", status=" + status + ", addedDate="
				+ addedDate + ", todoDate=" + todoDate + "]";
	}
	
	
	
	
	
}
