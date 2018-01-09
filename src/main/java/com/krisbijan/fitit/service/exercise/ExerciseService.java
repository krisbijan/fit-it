package com.krisbijan.fitit.service.exercise;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.model.Exercise;
import com.krisbijan.fitit.model.ExerciseCategory;
import com.krisbijan.fitit.service.category.ExerciseCategoryRepository;
import com.krisbijan.fitit.service.user.UserRepository;

@Service
public class ExerciseService {
	
	private final Logger LOGGER = LoggerFactory.getLogger("exercise");

	@Autowired
	private ExerciseRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ExerciseCategoryRepository categoryRepository;

	public ResponseEntity<Object> createExercise(Exercise exercise, Action action) {
		
		
		
		Exercise savedExercise = repository.save(exercise);
		LOGGER.debug(action + "Exercise created: " + exercise);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedExercise.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
