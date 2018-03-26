package com.krisbijan.fitit.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.krisbijan.fitit.model.Exercise;
import com.krisbijan.fitit.model.ExerciseCategory;
import com.krisbijan.fitit.service.category.ExerciseCategoryService;
import com.krisbijan.fitit.service.exercise.ExerciseService;

@RestController
public class ExerciseCategoryController {

	private final Logger LOGGER = LoggerFactory.getLogger("category");
	
	@Autowired
	private ExerciseCategoryService service;
	
	@PostMapping("/category")
	public ResponseEntity<ExerciseCategory> createCategory(Authentication authentication, @RequestBody ExerciseCategory category)
			throws URISyntaxException {
		ExerciseCategory createdCategory = service.createCategories(category, authentication.getName(), new Action());
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<ExerciseCategory>> getAllcategoriesForUser(Authentication authentication) {
		List<ExerciseCategory> categories = service.getAllCategories(authentication.getName(), new Action());
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<ExerciseCategory> deleteCategory(Authentication authentication, @PathVariable Integer id) {
		ExerciseCategory deletedCategory = service.deleteCategory(id, authentication.getName(), new Action());
		return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
	}
	
	@PutMapping("/category")
	public ResponseEntity<ExerciseCategory> updateCategory(@RequestBody ExerciseCategory category, Authentication authentication) {
		ExerciseCategory updatedCategory = service.updateCategory(category, authentication.getName(), new Action());
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}

}