package com.krisbijan.fitit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthTest {
	
	@GetMapping("/test/guest")
	public String guest() {
		return "guest Auth OK";
	}
	
	@GetMapping("/test/admin")
	public String admin() {
		return "admin Auth OK";
	}
	
	@GetMapping("/test/user")
	public String user() {
		return "user Auth OK";
	}

}

