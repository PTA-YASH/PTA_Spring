package com.yash.pta.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yash.pta.exception.InvalidHeaderException;
import com.yash.pta.model.Questions;
import com.yash.pta.model.Technology;
import com.yash.pta.repository.QuestionRepository;
import com.yash.pta.repository.TechnologyRepository;
import com.yash.pta.service.QuestionService;
/**
 * This is service implementation class for QuestionService interface methods implementation
 * @Service annotation is used in your service layer and annotates classes that perform service tasks
 * @Transactional annotation itself defines the scope of a single database transaction
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
	
	/**
	 * This is QuestionRepository instance.
	 */
	@Autowired
	QuestionRepository questionRepo;
	
	/**
	 * This is TechnologyRepository instance.
	 */
	@Autowired
	TechnologyRepository techRepo;

	/**
	 * This method fetches question list from DB
	 * @return Questions list
	 */
	public List<Questions> getAllQuestions() {

		List<Questions> queslst = questionRepo.findAll();
			return queslst;
	}
	
	/**
	 * This method is used to add questions in DB
	 * @param Technology id, Questions object
	 * @return Question object
	 */
	@Override
	public Questions addQuestion(int id, Questions ques) {

		Optional<Technology> techOpt = techRepo.findById(id);
		Technology technology = techOpt.get();

		/// tie Subject to Questions
		ques.setTechnology(technology);
		Questions question = questionRepo.save(ques);

		/// tie Questions to Subject
		Technology techObj = new Technology();
		Set<Questions> setQues = new HashSet<Questions>();
		setQues.add(question);
		techObj.setQue(setQues);
		return question;
	}

	/**
	 * This method fetches the questions list based on TechnologyId from DB
	 * @param Technology Id
	 * @return Questions list
	 */
	@Override
	public List<Questions> getQuestionsById(int techID) 
	{
		return questionRepo.getQuesByTechID(techID);
	}
	
	/**
	 * This method saves the data from excel file to DB
	 * @param File
	 * @throws InvalidHeaderException if Excel header not matched with criteria 
	 */
	@Override
	public void saveExelData(MultipartFile file) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		
		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.rowIterator();

		Questions question = null;

		List<Questions> listOfquestion = new ArrayList<>();

		List<String> headers = new ArrayList<>();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			question = new Questions();

			if (headers.isEmpty()) {
				headers = builderHeaders(row);
				continue; // skip header row
			}
			//System.out.println(headers.get);
				Iterator<Cell> cellIterator = row.cellIterator();
				int cellCount = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (headers.get(cellCount).toUpperCase()) {
					case "S.NO":
						question.setNo((int) cell.getNumericCellValue());

						break;
					case "QUESTION":
						question.setQues(cell.getStringCellValue());
						break;
					case "OPTION1":
						question.setOption1(cell.getStringCellValue());
						break;
					case "OPTION2":
						question.setOption2(cell.getStringCellValue());
						break;
					case "OPTION3":
						question.setOption3(cell.getStringCellValue());
						break;
					case "OPTION4":

						question.setOption4(cell.getStringCellValue());
						break;
					case "RIGHT":
						question.setRightOption(cell.getStringCellValue());
						break;
					default:
						System.out.println("not matching header found...");
						throw new InvalidHeaderException("File headers are not accepted..!");
					}
					cellCount++;
				}
				listOfquestion.add(question);
			}

		System.out.println(listOfquestion);

		questionRepo.saveAll(listOfquestion);
	}
	/**
	 * This method creates the header of excel file
	 * @param row
	 * @return headers list
	 */
	private static List<String> builderHeaders(Row row) {
		Iterator<Cell> cellIterator = row.cellIterator();
		List<String> headers = new ArrayList<String>();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (cell.getCellType() == 0) {
				headers.add(cell.getNumericCellValue() + "");
			} else if (cell.getCellType() == 1) {
				headers.add(cell.getStringCellValue());
			}
		}
		return headers;
	}
}
