package com.yash.pta.command;

import java.util.Set;

import com.yash.pta.model.RoleName;

public class JwtAuthenticationResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private RoleName roleName;
	private String name;

	public JwtAuthenticationResponse(String accessToken, RoleName roleName, String name) {
		super();
		this.accessToken = accessToken;
		this.roleName = roleName;
		this.name = name;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
