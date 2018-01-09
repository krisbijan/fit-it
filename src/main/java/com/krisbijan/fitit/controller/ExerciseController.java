package com.krisbijan.fitit.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.model.Exercise;
import com.krisbijan.fitit.service.exercise.ExerciseService;
import com.krisbijan.fitit.service.user.UserService;

@RestController
public class ExerciseController {
	
	private final Logger LOGGER = LoggerFactory.getLogger("exercise");

	@Autowired
	private ExerciseService service;
	
	@PostMapping("/exercise")
	public ResponseEntity<Object> createExercise(@Valid @RequestBody Exercise exercise) {
		Action action = new Action();
		LOGGER.debug(action+" Request for creating exercise: " +exercise);
		return service.createExercise(exercise, action);
	}

}
