package com.yash.pta.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.pta.model.Technology;

/**
 * This is service interface which contains User entity related methods.
 *  @Service annotation is used in your service layer and annotates classes that perform service tasks
 */
@Service
public interface TechnologyService 
{
 	/**
	 * This method fetches all technology from DB
	 * @return Technology list
	 */
	List<Technology> getTechnoloyList();
}
