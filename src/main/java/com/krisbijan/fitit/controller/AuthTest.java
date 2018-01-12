package com.krisbijan.fitit.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthTest {
	
	@GetMapping("/test/guest")
	public String guest(Authentication authentication) {
		return "Guest Auth OK... Hello " + authentication.getName();
	}
	
	@GetMapping("/test/admin")
	public String admin(Authentication authentication) {
		return "Admin Auth OK... Hello " + authentication.getName();
	}
	
	@GetMapping("/test/user")
	public String user(Authentication authentication) {
		return "User Auth OK... Hello " + authentication.getName();
	}

}

