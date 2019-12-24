package com.yash.pta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
/**
 * The class helps listens to the user request
 * User model class which represents user
 */
@Entity
@Table(name = "User")
@Component
public class User 
{
	/**
	 * This is User Id
	 * @Id represents auto-generated primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userId;

	/**
	 * This is User firstName
	 * @size restricts that User name should be 3 - 10 character.
	 */
	@NotBlank(message = "Name cannot be empty!")
	@Size(min = 3, max = 10, message = "Your name should be between 3 - 10 characters.")
	private String firstName;
	
	/**
	 * This is User lastName
	 * @size restricts that User name should be 2 - 10 character.
	 */
	
	private String lastName;
	/**
	 * This is Contact number
	 */
	@Pattern(regexp = "(^$|[0-9]{10})")
	@Column(name  = "contactNo", unique = true) 
	private String contactNo;

	/**
	 * This is email Id of User
	 */
	@Pattern(regexp = ".+@yash.com", message = "Not authorize user!")
	@Column(name  = "email", unique = true) 
	private String email;

	/**
	 * This is password which is use for login
	 * @Length validate that password should be 5 -10 characters
	 */
	@NotBlank(message = "Password Name cannot be empty!")
	@Length(min = 5, message = "Password should be more than 5 charactes")
	private String password;
	
	/**
	 * This is status of User
	 */
	private String status;

	@ManyToOne
	@JoinColumn(name = "Role_id") // 
	private Role role;
	
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * Setter and getters of User entity
	 */
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 *@toString It prints String representation of User object
	 */

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo="
				+ contactNo + ", email=" + email + ", password=" + password + ", status=" + status + ", role=" + role
				+ "]";
	}

	

	
	
}
