package com.krisbijan.fitit.service.day;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krisbijan.fitit.service.user.UserRepository;

@Service
public class DayService {
	
	private final Logger LOGGER = LoggerFactory.getLogger("day");

	
	@Autowired
	private DayRepository repository;

	@Autowired
	private UserRepository userRepository;


}
