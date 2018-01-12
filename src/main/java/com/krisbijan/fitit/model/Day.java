package com.krisbijan.fitit.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
@Entity
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	@Size(min = 1, message = "Name should have at least 1 characters")
	@Column
	private String name;
	@Column
	private String userId;
	@Column
	private Date date;

	@Column
	private ArrayList<Exercise> exercises;

	public ArrayList<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(ArrayList<Exercise> exercises) {
		this.exercises = exercises;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Day [id=" + id + ", name=" + name + ", userId=" + userId + ", date=" + date + "]";
	}

	public Day(Integer id, @Size(min = 1, message = "Name should have at least 1 characters") String name,
			String userId, Date date, ArrayList<Exercise> exercises) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.date = date;
		this.exercises = exercises;
	}

	public Day(@Size(min = 1, message = "Name should have at least 1 characters") String name, String userId,
			Date date, ArrayList<Exercise> exercises) {
		super();
		this.name = name;
		this.userId = userId;
		this.date = date;
		this.exercises = exercises;
	}

	public Day() {
		super();
	}

}
