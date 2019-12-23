package com.yash.pta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.pta.model.Questions;
/**
 * CRUD repository for Questions entity
 * Which performs all operations related to Questions.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {

	
	/**
	 * This method fetches question list from DB based on Technology id.
	 * @param id
	 * @return list of question based on Technology id
	 */
	@Query(value= "Select * from Questions where technology_Id = ?1", nativeQuery= true)
	public List<Questions> getQuesByTechID(int id);
		
}
