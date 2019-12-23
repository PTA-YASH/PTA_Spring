package com.yash.pta.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yash.pta.model.Questions;
import com.yash.pta.service.QuestionService;
import com.yash.pta.util.PtaApi;
import com.yash.pta.util.UseConstants;
/**
 * This is Rest controller which handles all HTTP requests related to Questions Entity.
 * @RestController marks this class as controller which handles all HTTP requests.
 * @CrossOrigin annotation to handle Cross-Origin-Resource-Sharing (CORS). 
 */
@RestController
@CrossOrigin(origins = "*")
public class QuestionsController {
	/**
	 * This is logger instance.
	 */
	private final Logger LOGGER = LoggerFactory.getLogger(QuestionsController.class);	
	
	/**
	 * This is QuestionService instance.
	 */
	@Autowired
	QuestionService questionService;
	
	
	/**
	 * This method is use to add the questions.
	 * It takes Questions object as a input and pass it to service layer
	 * @RequestBody annotation binds the HTTPRequest body to the domain object.
	 * @PostMapping is used to handle POST type of request method
	 * @param Questions Object
	 * @return Questions object
	 */
	@PostMapping(PtaApi.ADD_QUESTIONS)
	public Questions addQues(@PathVariable(value="id") int id,@Valid @RequestBody Questions ques)
	{
		return questionService.addQuestion(id,ques);
	}
	
	
	/**
	 * This method fetches the questions from DB.
	 * @GetMapping is used to handle GET type of request method
	 * @return Questions list if question list is empty it returns ResponseEntity with message and HTTP status.
	 */
	@GetMapping(PtaApi.GET_ALL_QUESTIONS)
	public ResponseEntity<?> getQuestions()
	{
		List<Questions> qList=questionService.getAllQuestions();
		
		if (!qList.isEmpty()) {
			return new ResponseEntity<>(qList,HttpStatus.OK);
		} 
		else 
		return new ResponseEntity<>(UseConstants.EMPTY_QUESTION_LIST, HttpStatus.NO_CONTENT);
	}
	
	/**
	 * This method fetches the questions from DB based on technology id.
	 * @GetMapping is used to handle GET type of request method
	 * @return List Questions object
	 */
	@GetMapping(PtaApi.GET_QUESTION)
    public List<Questions> getById(@PathVariable("id") int id)
    {
           return questionService.getQuestionsById(id);
    }
	
	/**
	 * This method is used to uploads the Excel file and stores the data into DB
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@PostMapping(PtaApi.UPLOAD_QUESTIONFILE)
	public ResponseEntity<?> saveExelData(@RequestParam MultipartFile file) throws IOException {
	LOGGER.info(file.getOriginalFilename());

		if (!file.getContentType().contentEquals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {

			return new ResponseEntity<>("Invalid file type..", HttpStatus.BAD_REQUEST);
		}

		questionService.saveExelData(file);
		return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
	}

	
}
