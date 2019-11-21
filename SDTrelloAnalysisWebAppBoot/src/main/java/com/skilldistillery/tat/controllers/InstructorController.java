package com.skilldistillery.tat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tat.entities.Instructor;
import com.skilldistillery.tat.services.InstructorService;

@RestController
@RequestMapping(path = "api")
public class InstructorController {
	
	
	@Autowired
	InstructorService instructorService;
	
	@GetMapping("ping")
	public String pong() {
		return "pong";
	}
	
	@GetMapping("index")
	public List<Instructor> index() {
		return instructorService.index();
	}
}
