package com.vodafone.collection.auth.dtoRequest;

import java.io.Serializable;

public class AuthRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	private String username;
	private String password;


	public AuthRequest() {
	}

	public AuthRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}



	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/*
	 * public int getIsVodafoner() { return isVodafoner; }
	 * 
	 * public void setIsVodafoner(int isVodafoner) { this.isVodafoner = isVodafoner;
	 * }
	 */

}
