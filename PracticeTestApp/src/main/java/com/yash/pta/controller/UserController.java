package com.yash.pta.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pta.command.LoginCommand;
import com.yash.pta.exception.InvalidCredentialsException;
import com.yash.pta.model.User;
import com.yash.pta.service.UserServiceApi;
import com.yash.pta.util.PtaApi;
/**
 * This is Rest controller which handles all HTTP requests related to User Entity.
 * @RestController marks this class as controller which handles all HTTP requests.
 * @CrossOrigin annotation to handle Cross-Origin-Resource-Sharing (CORS). 
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserServiceApi userServiceApi;
	
	/**
	 * This is logger instance.
	 */
	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class); 
	
	
	/**
	 * This method registers the user.
	 * It takes User object as a input and pass it to service layer
	 * @RequestBody annotation binds the HTTPRequest body to the domain object.
	 * @PostMapping is used to handle POST type of request method
	 * @param User Object
	 * @return void
	 */
	@PostMapping(PtaApi.USER_REGISTERATION)
	public void registerUser(@RequestBody User user) {
		LOGGER.info("Creating user {}",user);
		userServiceApi.createUser(user);
	}

	/**
	 * This method validate the if user is registered or not
	 * It takes Login object as input and pass it to service layer for authentication.
	 * @PostMapping is used to handle POST type of request method
	 * @Valid: This annotation validate the user name and password.
	 * @param Login Object
	 * @return User object
	 * @throws InvalidCredentialsException if invalid credentials entered.
	 */
	 @PostMapping(PtaApi.USER_LOGIN)
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginCommand login) throws InvalidCredentialsException {
		
		LOGGER.info("****************Inside the login action****************************");
		User loginUserObj = userServiceApi.findByEmailAndPassword(login.getEmail(),login.getPassword());

		LOGGER.info("Login user:", loginUserObj);
		
			if(loginUserObj!=null)
		      return new ResponseEntity<>(loginUserObj, HttpStatus.OK);
		     else
			return new ResponseEntity<>("Login failed", HttpStatus.NOT_FOUND);
	}
	 
		/**
		 * This method fetches the user from DB based on user id.
		 * @GetMapping is used to handle GET type of request method
		 * @param User id
		 * @return User object
		 */
 
	@GetMapping(PtaApi.GET_USER)
	public Optional<User> getUserById(@PathVariable Long id) {
		return userServiceApi.getUserById(id);
		
	}
	
	/**
	 * This method updates the user and stores into DB based on user id.
	 * @PutMapping is used to handle PUT type of request method to update the entity
	 * @param User id and User object
	 * @return User object
	 */
	@PutMapping(PtaApi.UPDATE_USER)
	public User updateUser(@RequestBody User user,@PathVariable Long id){
		return userServiceApi.updateUser(user, id);
		
	}
	
	/**
	 * This method delete the user from DB based on user id.
	 * @DeleteMapping annotation for mapping HTTP DELETE requests onto specific handler methods
	 * @param User id
	 * @return void
	 */
	@DeleteMapping(PtaApi.DELETE_USER)
	public void deleteUser(@PathVariable Long id) {
		userServiceApi.deleteUser(id);
	}

}
