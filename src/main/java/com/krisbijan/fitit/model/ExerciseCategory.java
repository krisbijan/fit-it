package com.krisbijan.fitit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Table
@Entity
public class ExerciseCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	@Size(min = 1, message = "Name should have at least 1 characters")
	private String name;

	@Column
	private Integer userId;

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

	@JsonProperty
	public Integer getUserId() {
		return userId;
	}

	@JsonIgnore
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ExerciseCategory [id=" + id + ", name=" + name + ", userId=" + userId + "]";
	}

	public ExerciseCategory(@Size(min = 1, message = "Name should have at least 1 characters") String name,
			Integer userId) {
		super();
		this.name = name;
		this.userId = userId;
	}

	public ExerciseCategory() {
		super();
	}

	public ExerciseCategory(Integer id, @Size(min = 1, message = "Name should have at least 1 characters") String name,
			Integer userId) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
	}

}
