package com.yash.pta.util;

/**
 * This is utility class for all rest services of application end points.
 */
public final class PtaApi {

	/**
	 * User Controller End points
	 */
	public final static String USER_REGISTERATION = "api/user/registerUser";
	public final static String USER_LOGIN = "api/user/loginUser";
	public final static String GET_USER = "api/user/getUser/{id}";
	public final static String GET_ALL_USER = "api/user/getAllUsers";
	public final static String DELETE_USER = "api/user/deleteUser/{id}";
	public final static String UPDATE_USER = "api/user/updateUser/{id}";

	/**
	 * Questions Controller End points
	 */
	public final static String ADD_QUESTIONS = "api/question/addQuestion/{id}";
	public final static String GET_ALL_QUESTIONS = "api/question/getAllQuestions";
	public final static String GET_QUESTION = "api/question/getQuestionById/{id}";
	public final static String UPLOAD_QUESTIONFILE = "api/question/uploadExcel";

	/**
	 * Technology Controller End points
	 */
	public final static String GET_ALL_TECHNOLOGY = "api/technology/getAllTechnology";
	
	
	/**
	 * Admin Controller End points
	 */
	public final static String GET_ALL_ACTIVE_USER="api/admin/getActiveUsers";
	public final static String GET_ALL_INACTIVE_USER="api/admin/getInActiveUsers";
	
	
	
	//public final static String

}
