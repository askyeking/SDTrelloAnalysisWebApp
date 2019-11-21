package com.skilldistillery.tat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tat.entities.Topic;
import com.skilldistillery.tat.services.TopicService;

@RestController
@RequestMapping(path = "api/topics")
public class TopicController {
	@Autowired
	private TopicService topicSvc;

	/*
	 * keyword = keyword in topic name
	 * GET | /api/topics 															| Get all topics 
	 * GET | /api/topics/{topic.id} 												| Get topic by ID 
	 * GET | /api/topics/keyword/{keyword} 											| Get all topics by keyword 
	 * GET | /api/topics/startDate/{startDate}/endDate/{endDate} 					| Get all topics by start/end date 
	 * GET | /api/topics/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get all topics by keyword + date 
	 * GET | /api/topics/instructor/{instructor} 									| Get all topics by Instructor 
	 * GET | /api/topics/instructor/{instructor}/startDate/{startDate}/endDate/{endDate} 					| Get all topics by Instructor + Date 
	 * GET | /api/topics/instructor/{instructor}/keyword/{keyword} 											| Get all topics by Instructor + Keyword 
	 * GET | /api/topics/instructor/{instructor}/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get topics by Instructor, Keyword, Date
	 */

	@GetMapping("/{id}")
	public Topic getTopicById(@PathVariable int id) {
	return topicSvc.findById(id);
	}
}
