package com.capgemini.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Feedback {

	@Id
	private long id;
	private String title;
	private String name;
	private Date startDate;
	private Date endDate;
	private List<QuestionAnswer> list;
	
	public Feedback(long id, String title, String name, Date startDate, Date endDate, List<QuestionAnswer> list) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.list = list;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<QuestionAnswer> getList() {
		return list;
	}
	public void setList(List<QuestionAnswer> list) {
		this.list = list;
	}
	
	
}
