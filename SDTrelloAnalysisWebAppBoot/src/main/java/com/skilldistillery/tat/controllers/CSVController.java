package com.skilldistillery.tat.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class CSVController {
	
	ProcessBuilder processBuilder = new ProcessBuilder();

	
	
	public Boolean csvFileInProcessing() {
		
		
//		processBuilder.command("bash", "")
		
		Process process;
		
		
		return null;
	}
	
	
	
	
	
	

}
