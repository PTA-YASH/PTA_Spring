package com.yash.pta.service;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yash.pta.model.Questions;

/**
 * This is service interface which contains User entity related methods.
 *  @Service annotation is used in your service layer and annotates classes that perform service tasks
 */
@Service
public interface QuestionService 
{
	/**
	 * This method fetch all questions from DB.
	 * @return question list
	 */
	List<Questions> getAllQuestions();

	/**
	 * This method add question based on technology id
	 * @param technology id
	 * @param Questions object
	 * @return
	 */
	Questions addQuestion(int id, Questions ques);

	/**
	 * This method fetch question list by technology id
	 * @param techID
	 * @return question list
	 */
	List<Questions> getQuestionsById(int techID);

	/**
	 * This method saves excel data into DB
	 * @param file
	 * @throws IOException
	 */
	void saveExelData(MultipartFile file)throws IOException;
}
