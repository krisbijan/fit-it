package com.krisbijan.fitit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.krisbijan.fitit.service.user.UserService;
import com.krisbijan.fitit.service.workout.WorkoutService;

@RestController
public class WorkoutController {
	
	private final Logger LOGGER = LoggerFactory.getLogger("workout");

	@Autowired
	private WorkoutService service;

}
