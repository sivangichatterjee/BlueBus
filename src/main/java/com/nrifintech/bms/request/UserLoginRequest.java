package com.nrifintech.bms.request;

import javax.validation.constraints.Pattern;

/**
 * @author	Debopam
 * @email	debpal07@gmail.com
 * @created	Nov 9, 2021
 */
public class UserLoginRequest {
	/* USERNAME Pattern Description
	 * 
	 * username is 8-20 characters long
	 * no _ or . at the beginning
	 * no __ or _. or ._ or .. inside
	 * allowed characters - a-z, A-Z, 0-9, ., _
	 * no _ or . at the end
	 */
	@Pattern(regexp = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", message = "Username must be 8-20 characters long with allowed characters - a-z, A-Z, 0-9, ., _")
	private String username;
	
	/*
	 * PASSWORD Pattern - Same as username pattern
	 */
	@Pattern(regexp = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", message = "Password must be 8-20 characters long with allowed characters - a-z, A-Z, 0-9, ., _")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
