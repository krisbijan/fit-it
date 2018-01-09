package com.krisbijan.fitit.service.workout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krisbijan.fitit.service.user.UserRepository;

@Service
public class WorkoutService {
	
	private final Logger LOGGER = LoggerFactory.getLogger("workout");

	@Autowired
	private WorkoutRepository repository;

	@Autowired
	private UserRepository userRepository;


}
