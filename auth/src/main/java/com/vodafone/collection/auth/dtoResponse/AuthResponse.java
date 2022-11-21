package com.vodafone.collection.auth.dtoResponse;

import java.io.Serializable;


public class AuthResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private  String jwttoken;
	private String username;
	private long isExpiredDate;

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getIsExpiredDate() {
		return isExpiredDate;
	}

	public void setIsExpiredDate(long isExpiredDate) {
		this.isExpiredDate = isExpiredDate;
	}
}