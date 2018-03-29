package com.krisbijan.fitit.model;

import java.util.List;

public class UserData {
	
	private String email;
	private List<Workout> workouts;
	private List<Exercise> exercises;
	private List<ExerciseCategory> categories;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Workout> getWorkouts() {
		return workouts;
	}
	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}
	public List<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	public List<ExerciseCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<ExerciseCategory> categories) {
		this.categories = categories;
	}
	
	

}
