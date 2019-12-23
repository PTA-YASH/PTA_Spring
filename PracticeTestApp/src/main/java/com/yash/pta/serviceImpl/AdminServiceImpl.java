package com.yash.pta.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pta.model.User;
import com.yash.pta.repository.UserRepository;
import com.yash.pta.service.AdminService;
/**
 * This is service interface which contains AdminService related methods.
 *  @Service annotation is used in your service layer and annotates classes that perform service tasks
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	UserRepository userRepository;
	
	/**
	 * This method fetches the active user list from DB
	 * @return Active user list
	 */
	@Override
	public List<User> getActiveUsers() {
		// TODO Auto-generated method stub
		return userRepository.findByStatus("active");
	}

	/**
	 * This method fetches the In-active user list from DB
	 * @return In-Active user list
	 */
	@Override
	public List<User> getInActiveUsers() {
		// TODO Auto-generated method stub
		return userRepository.findByStatus("inactive");
	}

}
