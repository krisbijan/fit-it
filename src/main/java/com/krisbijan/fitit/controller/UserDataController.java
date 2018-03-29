package com.krisbijan.fitit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.model.Exercise;
import com.krisbijan.fitit.model.UserData;
import com.krisbijan.fitit.service.category.ExerciseCategoryService;
import com.krisbijan.fitit.service.exercise.ExerciseService;
import com.krisbijan.fitit.service.workout.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class UserDataController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private ExerciseCategoryService exerciseCategoryService;
	

	@CrossOrigin
	@GetMapping("/user")
	public ResponseEntity<UserData> guest(Authentication authentication) {
		UserData userData = new UserData();
		Action action = new Action();
		userData.setEmail(authentication.getName());
		userData.setCategories(exerciseCategoryService.getAllCategories(authentication.getName(), action));
		userData.setExercises(exerciseService.getAllExercise(authentication.getName(), action));
		userData.setWorkouts(workoutService.getAllWorkout(authentication.getName(), action));
		return new ResponseEntity<>(userData, HttpStatus.OK);
	}
	


}

