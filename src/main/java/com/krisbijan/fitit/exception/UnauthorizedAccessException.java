package com.krisbijan.fitit.exception;

public class UnauthorizedAccessException extends RuntimeException{

	public UnauthorizedAccessException() {
		super("Not allowed - wrong user email");
	}
}
