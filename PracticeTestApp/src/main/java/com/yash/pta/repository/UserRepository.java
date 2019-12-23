package com.yash.pta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.yash.pta.model.User;

/**
 * CRUD repository for User entity
 * Which performs all operations related to user.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
	/**
	 * This method validates the user credentials are valid or not.
	 * @param username
	 * @param password
	 * @return User object if credentials are valid
	 */
	User findByEmailAndPassword(String username, String password);
	
	/**
	 * This method fetches Users from DB based on Status
	 * @param status
	 * @return
	 */
	List<User>findByStatus(String status);
}
