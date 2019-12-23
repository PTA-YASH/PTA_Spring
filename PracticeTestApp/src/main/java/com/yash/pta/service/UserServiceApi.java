package com.yash.pta.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.yash.pta.exception.InvalidCredentialsException;
import com.yash.pta.model.User;
/**
 * This is service interface which contains User entity related methods.
 *  @Service annotation is used in your service layer and annotates classes that perform service tasks
 */
@Service
public interface UserServiceApi 
{
	/**
	 * This method Creates User.
	 */
	User createUser(User user);
	
	/**
	 * Authenticate user credential if user is valid or not.
	 * @throws InvalidCredentialsException if incorrect details entered.
	 */
	User findByEmailAndPassword(String email, String password) throws InvalidCredentialsException;
	
	
	/**
	 * This method fetches User object from DB based on user id
	 * @param User id
	 * @return User object
	 */
	Optional<User> getUserById(Long id);
	
	/**
	 * This method updates the user and stores into DB based on user id.
	 * @param User id and User object
	 * @return User object
	 */
	User updateUser(User user, Long id);
	
	/**
	 * This method deletes User object based on user id
	 * @param user id
	 * @return void
	 */
	void deleteUser(Long id);
	
}
