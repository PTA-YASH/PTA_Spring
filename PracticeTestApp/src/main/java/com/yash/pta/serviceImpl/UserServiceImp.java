package com.yash.pta.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yash.pta.exception.InvalidCredentialsException;
import com.yash.pta.model.Role;
import com.yash.pta.model.RoleName;
import com.yash.pta.model.User;
import com.yash.pta.repository.RoleRepository;
import com.yash.pta.repository.UserRepository;
import com.yash.pta.service.UserServiceApi;
/**
 * This is service implementation class for UserServiceApi interface methods implementation
 * @Service annotation is used in your service layer and annotates classes that perform service tasks
 * @Transactional annotation itself defines the scope of a single database transaction
 */
@Service
@Transactional
public class UserServiceImp implements UserServiceApi{

	/**
	 * User repository instance
	 */
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/**
	 * This method registers the user.
	 * It takes User object as a input and pass it to DAO layer
	 * @param User Object
	 * @return User object
	 */
	@Override
	public User createUser(User user) {
		Role userRole = roleRepository.findByName(RoleName.ROLE_TRAINEE);

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(userRole);
		userRepo.save(user);
		return user;
	
	}
	/**
	 * This method authenticate the user 
	 * @param email
	 * @param password
	 * @return User object if user is valid.
	 * @throws if user is not valid it throws InvalidCredentialsException
	 */
	@Override
	public User findByEmailAndPassword(String email, String password) throws InvalidCredentialsException
	{
			User loginUserObj = userRepo.findByEmailAndPassword(email,password);
			if(loginUserObj==null) 
			throw new InvalidCredentialsException("User not found!");
			return loginUserObj;
	}

	/**
	 * This method fetches the user object from DB based on user id 
	 * @param user id
	 * @return User object
	 * Optional annotation avoids NullPonterException if user is not exist in DB, it returns null.
	 */
	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	/**
	 * This method updates the user and stores into DB based on user id.
	 * @param User id 
	 * @param User object
	 * @return User object
	 */
	@Override
	public User updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		User oldUser=userRepo.getOne(id);
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		oldUser.setEmail(user.getEmail());
		oldUser.setContactNo(user.getContactNo());
		userRepo.save(oldUser);
		return oldUser;
	}

	/**
	 * This method delete the user 
	 * @param user id
	 * @return void
	 */
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}
	@Override
	public User findByEmail(String username) throws InvalidCredentialsException {
	
		
		User loginUserObj = userRepo.findByEmail(username).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username: " + username));
		if (loginUserObj == null)
			throw new InvalidCredentialsException("User not found!");
		return loginUserObj;
	}
}
