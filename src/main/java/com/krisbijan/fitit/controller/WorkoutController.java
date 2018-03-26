package com.krisbijan.fitit.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.model.Workout;
import com.krisbijan.fitit.service.workout.WorkoutService;

@RestController
public class WorkoutController {
	
	private final Logger LOGGER = LoggerFactory.getLogger("workout");

	@Autowired
	private WorkoutService service;
	
	@PostMapping("/workout")
	public ResponseEntity<Workout> createWorkout(Authentication authentication, @RequestBody Workout Workout)
			throws URISyntaxException {
		Workout createdWorkout = service.createWorkout(Workout, authentication.getName(), new Action());
		return new ResponseEntity<>(createdWorkout, HttpStatus.CREATED);
	}
	
	@GetMapping("/workout")
	public ResponseEntity<List<Workout>> getAllWorkoutForUser(Authentication authentication) {
		List<Workout> Workouts = service.getAllWorkout(authentication.getName(), new Action());
		return new ResponseEntity<>(Workouts, HttpStatus.OK);
	}
	
	@DeleteMapping("/workout/{id}")
	public ResponseEntity<Workout> deleteWorkout(Authentication authentication, @PathVariable Integer id) {
		Workout deletedWorkout = service.deleteWorkout(id, authentication.getName(), new Action());
		return new ResponseEntity<>(deletedWorkout, HttpStatus.OK);
	}
	
	@PutMapping("/workout")
	public ResponseEntity<Workout> updateWorkout(@RequestBody Workout Workout, Authentication authentication) {
		Workout updatedWorkout = service.updateWorkout(Workout, authentication.getName(), new Action());
		return new ResponseEntity<>(updatedWorkout, HttpStatus.OK);
	}

}
