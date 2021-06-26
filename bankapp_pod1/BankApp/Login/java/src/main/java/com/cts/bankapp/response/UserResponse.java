package com.cts.bankapp.response;

public class UserResponse {
	private String token;
	private String type = "Bearer";
	private int id;
	private String username;

	public UserResponse(String accessToken, int id, String username) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
