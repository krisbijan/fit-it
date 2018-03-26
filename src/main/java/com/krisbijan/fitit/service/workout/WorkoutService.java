package com.krisbijan.fitit.service.workout;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.exception.UnauthorizedAccessException;
import com.krisbijan.fitit.model.Workout;
import com.krisbijan.fitit.service.user.UserRepository;

@Service
public class WorkoutService {

	private final Logger LOGGER = LoggerFactory.getLogger("workout");

	@Autowired
	private WorkoutRepository workoutRepository;

	@Autowired
	private UserRepository userRepository;

	public Workout createWorkout(Workout workout, String userEmail, Action action) {
		workout.setUserEmail(userEmail);
		return workoutRepository.save(workout);
	}

	public Workout updateWorkout(Workout workout, String userEmail, Action action) {
		if (userEmail.equalsIgnoreCase(workout.getUserEmail()))
			return workoutRepository.save(workout);
		else
			throw new UnauthorizedAccessException();
	}

	public Workout deleteWorkout(Integer id, String userEmail, Action action) {
		Workout workout = workoutRepository.findOne(id);
		if (userEmail.equalsIgnoreCase(workout.getUserEmail())) {
			workoutRepository.delete(workout);
			return workout;
		} else
			throw new UnauthorizedAccessException();

	}

	public List<Workout> getAllWorkout(String userEmail, Action action) {
		return workoutRepository.findByUserEmail(userEmail);
	}

}
