package com.krisbijan.fitit.service.category;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.model.Appuser;
import com.krisbijan.fitit.service.user.UserRepository;
import com.krisbijan.fitit.model.ExerciseCategory;

@Service
public class ExerciseCategoryService {

	private final Logger LOGGER = LoggerFactory.getLogger("category");

	@Autowired
	private ExerciseCategoryRepository repository;

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<Object> createCategory(ExerciseCategory category, Action action) {
		ExerciseCategory savedCategory = repository.save(category);
		LOGGER.debug(action + "Category created: " + category);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCategory.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	public List<ExerciseCategory> getAllCategories(String username, Action action) {

		Appuser getUser = userRepository.findByName(username);
		if (getUser == null) {
			LOGGER.error(action + "No user in DB: " + username);
			throw new com.krisbijan.fitit.exception.UserNotFoundException("Username-" + username);
		}
		LOGGER.debug(action + "Got user: " + username);

		List<ExerciseCategory> categoryList = repository.findByUserId(getUser.getId());
		LOGGER.debug(action + "Got all categories for username: " + username);
		return categoryList;
	}

	public ExerciseCategory deleteCategory(String username, String categoryName, Action action) {
		Appuser getUser = userRepository.findByName(username);
		if (getUser == null) {
			LOGGER.error(action + "No user in DB: " + username);
			throw new com.krisbijan.fitit.exception.UserNotFoundException("Username-" + username);
		}
		LOGGER.debug(action + "Got user: " + username);
		
		
		
		List<ExerciseCategory> categoryList = repository.findByUserIdAndCategoryName(getUser.getId(), categoryName);
		if (categoryList == null || categoryList.size() == 0) {
			LOGGER.error(action + "No category like that in DB: " + categoryName);
			throw new com.krisbijan.fitit.exception.CategoryNotFoundException("CategoryName-" + categoryName);
		}
		LOGGER.debug(action + "Got all categories for username: " + username);
		repository.delete(categoryList.get(0));
		return categoryList.get(0);
		
	}



}
