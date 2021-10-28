package com.tourism.comparahoteles.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UpdateRequest {
	@Size(min = 3, max = 20)
	private String username;

	@Size(min = 3, max = 20)
	private String name;

	@Size(min = 3, max = 20)
	private String surname;

	@Size(max = 50)
	@Email
	private String email;

	@Size(min = 6, max = 40)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
