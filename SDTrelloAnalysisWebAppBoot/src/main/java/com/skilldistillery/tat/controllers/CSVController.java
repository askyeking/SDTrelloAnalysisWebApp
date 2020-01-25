package com.skilldistillery.tat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class CSVController {
	
	ProcessBuilder processBuilder = new ProcessBuilder();

	
	//this method will allow user to upload a CSV file to AWS.
	public Boolean csvFileInProcessing() {
//		processBuilder.command("bash", "")
		
		Process process;
		
		
		return null;
	}
	
	
	
	
	
	

}
