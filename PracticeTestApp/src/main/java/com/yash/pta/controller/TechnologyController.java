package com.yash.pta.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pta.exception.EmptyTechListException;
import com.yash.pta.model.Technology;
import com.yash.pta.service.TechnologyService;
import com.yash.pta.util.PtaApi;
import com.yash.pta.util.UseConstants;
/**
 * This is Rest controller which handles all HTTP requests related to Technology Entity.
 * @RestController marks this class as controller which handles all HTTP requests.
 * @CrossOrigin annotation to handle Cross-Origin-Resource-Sharing (CORS). 
 */
@RestController
@CrossOrigin(origins = "*")
public class TechnologyController {

	/**
	 * This is TechnologyService instance.
	 */
	@Autowired
	private TechnologyService technologyService;
	
	/**
	 * This is logger instance.
	 */
	private final Logger LOGGER = LoggerFactory.getLogger(TechnologyController.class.getName()); 

	/**
	 * This method is used to fetch technology list from DB
	 * @return Technology list and HTTP status
	 * @throws EmptyTechListException if no technology exist in DB
	 */
	@GetMapping(PtaApi.GET_ALL_TECHNOLOGY)
	public ResponseEntity<?> getTechList() {

		List<Technology> techList = technologyService.getTechnoloyList();
		LOGGER.info("Technology list:"+techList);
		if (!techList.isEmpty()) 
			return new ResponseEntity<>(techList, HttpStatus.OK);
		else 
			throw new EmptyTechListException(UseConstants.EMPTY_TECHNOLOGY_LIST);
	}

}
