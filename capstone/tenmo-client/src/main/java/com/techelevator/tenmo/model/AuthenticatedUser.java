package com.techelevator.tenmo.model;

public class AuthenticatedUser {
	
	private String token; //authentication token as a string, like a ticket for access to API, short lived
	private User user;  //user ID and password
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
