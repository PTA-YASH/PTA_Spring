package com.yash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.yash.pta.controller.UserController;

//Main class which starts the application. 
@SpringBootApplication
public class PtaSpringApplication {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class.getName());

	public static void main(String[] args) {
		

		ConfigurableApplicationContext context = SpringApplication.run(PtaSpringApplication.class, args);
		PreDefinedData preDefinedData = context.getBean(PreDefinedData.class);
		LOGGER.info("\n\n*******PTA application is started!********");
	
		
	}
}
