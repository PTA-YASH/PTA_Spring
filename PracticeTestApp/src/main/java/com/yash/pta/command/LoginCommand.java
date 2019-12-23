package com.yash.pta.command;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

/**
 * Login DTO for performing validations on login properties.
 * It is a DTO(Data Transfer Object) which don't have any table.
 */
@Component
public class LoginCommand {
	
	/**
	 * This is login name
	 * @NotBlank validate that login name should not be blank
	 * @Length restricts that login name should be 5 - 10 characters.
	 */
	@NotBlank(message = "User email cannot be empty")
	@Length( message = "Your yash email should be valid")
	private String email;
	
	/**
	 * This is login password
	 * @Length restricts that login name should be 5 - 10 characters.
	 */
	@NotBlank(message = "Password cannot be empty")
	@Length(min = 5, max = 10, message = "Password should be between 5 - 10 charactes")
	private String password;

	
	/**
	 * Setter and getters of login entity
	 */

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @toString It prints String representation of login object
	 */
	
	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + "]";
	}
}
