package com.krisbijan.fitit.model;

import javax.persistence.*;
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
	private String name;

	@Column
	private String userEmail;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workout", nullable = true)
	private Workout workout;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exercise_category", nullable = true)
	private ExerciseCategory exerciseCategory;

	//0-reps exercise, 1-time exercise
	@Column
	private Boolean reps_or_time;

	@Column
	private Boolean template;
	
	@Column
	private Integer reps;
	
	@Column
	private Integer sets;

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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public ExerciseCategory getExerciseCategory() {
		return exerciseCategory;
	}

	public void setExerciseCategory(ExerciseCategory exerciseCategory) {
		this.exerciseCategory = exerciseCategory;
	}

	public Boolean getReps_or_time() {
		return reps_or_time;
	}

	public void setReps_or_time(Boolean reps_or_time) {
		this.reps_or_time = reps_or_time;
	}

	public Boolean getTemplate() {
		return template;
	}

	public void setTemplate(Boolean template) {
		this.template = template;
	}

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

	
}
