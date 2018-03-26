package com.krisbijan.fitit.controller;

import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.model.Exercise;
import com.krisbijan.fitit.service.exercise.ExerciseService;

@RestController
public class ExerciseController {

	private final Logger LOGGER = LoggerFactory.getLogger("exercise");

	@Autowired
	private ExerciseService service;

	@PostMapping("/exercise")
	public ResponseEntity<Exercise> createExercise(Authentication authentication, @RequestBody Exercise exercise)
			throws URISyntaxException {
		Exercise createdExercise = service.createExercise(exercise, authentication.getName(), new Action());
		return new ResponseEntity<>(createdExercise, HttpStatus.CREATED);
	}
	
	@GetMapping("/exercise")
	public ResponseEntity<List<Exercise>> getAllExerciseForUser(Authentication authentication) {
		List<Exercise> exercises = service.getAllExercise(authentication.getName(), new Action());
		return new ResponseEntity<>(exercises, HttpStatus.OK);
	}
	
	@DeleteMapping("/exercise/{id}")
	public ResponseEntity<Exercise> deleteExercise(Authentication authentication, @PathVariable Integer id) {
		Exercise deletedExercise = service.deleteExercise(id, authentication.getName(), new Action());
		return new ResponseEntity<>(deletedExercise, HttpStatus.OK);
	}
	
	@PutMapping("/exercise")
	public ResponseEntity<Exercise> updateExercise(@RequestBody Exercise exercise, Authentication authentication) {
		Exercise updatedExercise = service.updateExercise(exercise, authentication.getName(), new Action());
		return new ResponseEntity<>(updatedExercise, HttpStatus.OK);
	}

}
