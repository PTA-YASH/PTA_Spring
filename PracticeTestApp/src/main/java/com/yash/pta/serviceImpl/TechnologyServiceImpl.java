package com.yash.pta.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yash.pta.model.Technology;
import com.yash.pta.repository.TechnologyRepository;
import com.yash.pta.service.TechnologyService;

/**
 * This is service implementation class for TechnologyService interface methods implementation
 * @Service annotation is used in your service layer and annotates classes that perform service tasks
 * @Transactional annotation itself defines the scope of a single database transaction
 */
@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService {

	/**
	 * This is TechnologyRepository instance.
	 */
	@Autowired
	TechnologyRepository techRepo;
	
	/**
	 * This method fetches technology list from DB
	 * @return technology list
	 */
	@Override
	public List<Technology> getTechnoloyList() {
		// TODO Auto-generated method stub
		return  (List<Technology>) techRepo.findAll();
		
		
		
//		List<Technology> list = (List<Technology>) techRepo.findAll(); 
//		if(list!=null) {
//			return  new ResponseEntity<>(list, HttpStatus.OK);
//		}else {
//			return  new ResponseEntity<>("List is empty", HttpStatus.NOT_FOUND);
//		}
		
	}

}
