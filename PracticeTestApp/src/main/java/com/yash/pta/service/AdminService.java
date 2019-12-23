package com.yash.pta.service;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.yash.pta.model.User;
/**
 * This is service interface which contains AdminService related methods.
 *  @Service annotation is used in your service layer and annotates classes that perform service tasks
 */
@Service
@Component
public interface AdminService 
{
	/**
	 * This method fetches active users from DB
	 * @return list of active user
	 */
	List<User>getActiveUsers();
	
	/**
	 * This method fetches in-active users from DB
	 * @return list of in-active user
	 */
	List<User>getInActiveUsers();
}
