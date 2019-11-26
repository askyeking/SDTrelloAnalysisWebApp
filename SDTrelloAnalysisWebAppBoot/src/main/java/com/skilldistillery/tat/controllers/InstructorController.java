package com.skilldistillery.tat.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tat.entities.Instructor;
import com.skilldistillery.tat.services.InstructorService;


/*
 * keyword = keyword in topic name OR description
 * xGET | /api/topics 															| Get all topics 
 * xGET | /api/topics/{topic.id} 												| Get topic by ID 
 * xGET | /api/topics/keyword/{keyword} 											| Get all topics by keyword 
 * GET | /api/topics/startDate/{startDate}/endDate/{endDate} 					| Get all topics by start/end date 
 * GET | /api/topics/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get all topics by keyword + date 
 * GET | /api/topics/instructor/{instructor} 									| Get all topics by Instructor 
 * GET | /api/topics/instructor/{instructor}/startDate/{startDate}/endDate/{endDate} 					| Get all topics by Instructor + Date 
 * GET | /api/topics/instructor/{instructor}/keyword/{keyword} 											| Get all topics by Instructor + Keyword 
 * GET | /api/topics/instructor/{instructor}/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get topics by Instructor, Keyword, Date
 */
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
