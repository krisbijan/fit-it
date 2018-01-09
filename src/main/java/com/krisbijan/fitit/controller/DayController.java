package com.krisbijan.fitit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.krisbijan.fitit.service.day.DayService;
import com.krisbijan.fitit.service.user.UserService;

@RestController
public class DayController {
	
	private final Logger LOGGER = LoggerFactory.getLogger("day");

	@Autowired
	private DayService service;

}
