package com.krisbijan.fitit.model;

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
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	@Size(min = 1, message = "Name should have at least 1 characters")
	@Column
	private String name;

	@Column
	private Integer userId;
	
	@Column
	private Integer categoryId;
	
	@Column
	private Integer reps;
	
	@Column
	private Integer sets;

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	public Integer getSets() {
		return sets;
	}

	public void setSets(Integer sets) {
		this.sets = sets;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", userId=" + userId + ", categoryId=" + categoryId + "]";
	}

	public Exercise(Integer id, @Size(min = 1, message = "Name should have at least 1 characters") String name,
			Integer userId, Integer categoryId, Integer reps, Integer sets) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.categoryId = categoryId;
		this.reps = reps;
		this.sets = sets;
	}

	public Exercise(@Size(min = 1, message = "Name should have at least 1 characters") String name, Integer userId,
			Integer categoryId, Integer reps, Integer sets) {
		super();
		this.name = name;
		this.userId = userId;
		this.categoryId = categoryId;
		this.reps = reps;
		this.sets = sets;
	}

	public Exercise() {
		super();
	}

}
