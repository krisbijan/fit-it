package com.krisbijan.fitit.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.model.ExerciseCategory;
import com.krisbijan.fitit.service.category.ExerciseCategoryService;

@RestController
public class ExerciseCategoryController {

	private final Logger LOGGER = LoggerFactory.getLogger("category");
	
	@Autowired
	private ExerciseCategoryService service;
	
	@PostMapping("/category")
	public ResponseEntity<Object> createCategory(@Valid @RequestBody ExerciseCategory category,Authentication authentication) {
		Action action = new Action();
		LOGGER.debug(action+" Request for creating category: " +category);
		return service.createCategory(category,action);
	}
	

	@GetMapping("/category/{username}")
	public List<ExerciseCategory> getAllUserCategories(@PathVariable String username,Authentication authentication) {
		Action action = new Action();
		LOGGER.debug(action+" Request for getting all categories for userId: " +username);
		return service.getAllCategories(username, action);
	}
	
	@DeleteMapping("/category")
	public ExerciseCategory deleteCategory(@RequestBody Map<String,Object> body,Authentication authentication) {
		Action action = new Action();
		String categoryName= (String) body.get("categoryName");
		String username= (String) body.get("username");
		
		LOGGER.debug(action + "Request for delete category: "+categoryName+"for user: " + username);
		return service.deleteCategory(username, categoryName, action);
	}

}