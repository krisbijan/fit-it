package com.krisbijan.fitit.service.exercise;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.exception.UnauthorizedAccessException;
import com.krisbijan.fitit.model.Exercise;
import com.krisbijan.fitit.service.user.UserRepository;

@Service
public class ExerciseService {

	private final Logger LOGGER = LoggerFactory.getLogger("exercise");

	@Autowired
	private ExerciseRepository exerciseRepository;

	@Autowired
	private UserRepository userRepository;

	public Exercise createExercise(Exercise exercise, String userEmail, Action action) {
		exercise.setUserEmail(userEmail);
		return exerciseRepository.save(exercise);
	}

	public Exercise updateExercise(Exercise exercise, String userEmail, Action action) {

		if (userEmail.equalsIgnoreCase(exercise.getUserEmail()))
			return exerciseRepository.save(exercise);
		else
			throw new UnauthorizedAccessException();
	}

	public Exercise deleteExercise(Integer id, String userEmail, Action action) {
		Exercise exercise = exerciseRepository.findOne(id);
		if (userEmail.equalsIgnoreCase(exercise.getUserEmail())) {
			exerciseRepository.delete(exercise);
			return exercise;
		} else
			throw new UnauthorizedAccessException();
	}

	public List<Exercise> getAllExercise(String userEmail, Action action) {
		return exerciseRepository.findByUserEmail(userEmail);
	}
}
