package com.krisbijan.fitit.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.krisbijan.fitit.Action;
import com.krisbijan.fitit.model.Appuser;
import com.krisbijan.fitit.service.user.UserService;

@RestController
public class UserController {

	private final Logger LOGGER = LoggerFactory.getLogger("appuser");

	@Autowired
	private UserService service;

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody Appuser user) {
		Action action = new Action();
		LOGGER.debug(action + "Request for creating user: " + user);
		return service.createUser(user, action);
	}

	@PutMapping("/users")
	public ResponseEntity<Object> changeUserPassword(@RequestBody Appuser user) {
		Action action = new Action();
		LOGGER.debug(action + "Request for password change: " + user);
		return service.changeUserPassword(user, action);
	}

	//login
	@GetMapping("/users/{username}")
	public Appuser getUser(@PathVariable String username) {
		Action action = new Action();
		LOGGER.debug(action + "Request for get user: " + username);
		return service.getUser(username, action);
	}

	//delete user
	@DeleteMapping("/users/{username}")
	public Appuser deleteUser(@PathVariable String username) {
		Action action = new Action();
		LOGGER.debug(action + "Request for delete user: " + username);
		return service.deleteUser(username, action);
	}

}
