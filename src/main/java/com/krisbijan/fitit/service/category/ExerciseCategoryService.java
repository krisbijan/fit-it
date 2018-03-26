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
import com.krisbijan.fitit.exception.UnauthorizedAccessException;
import com.krisbijan.fitit.service.user.UserRepository;
import com.krisbijan.fitit.model.Exercise;
import com.krisbijan.fitit.model.ExerciseCategory;

@Service
public class ExerciseCategoryService {

	private final Logger LOGGER = LoggerFactory.getLogger("category");

	@Autowired
	private ExerciseCategoryRepository exerciseCategoryRepository;

	@Autowired
	private UserRepository userRepository;

	public ExerciseCategory createCategories(ExerciseCategory category, String userEmail, Action action) {
		category.setUserEmail(userEmail);
		return exerciseCategoryRepository.save(category);
	}

	public ExerciseCategory updateCategory(ExerciseCategory category, String userEmail, Action action) {

		if (userEmail.equalsIgnoreCase(category.getUserEmail()))
			return exerciseCategoryRepository.save(category);
		else
			throw new UnauthorizedAccessException();
	}

	public ExerciseCategory deleteCategory(Integer id, String userEmail, Action action) {

		ExerciseCategory exerciseCategory = exerciseCategoryRepository.findOne(id);

		if (userEmail.equalsIgnoreCase(exerciseCategory.getUserEmail())) {
			exerciseCategoryRepository.delete(exerciseCategory);
			return exerciseCategory;
		} else
			throw new UnauthorizedAccessException();

	}

	public List<ExerciseCategory> getAllCategories(String userEmail, Action action) {
		return exerciseCategoryRepository.findByUserEmail(userEmail);
	}

}
