package com.skilldistillery.tat.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tat.entities.Instructor;
import com.skilldistillery.tat.entities.Topic;
import com.skilldistillery.tat.services.TopicService;

@RestController
@RequestMapping(path = "api/topics")
public class TopicController {
	@Autowired
	private TopicService topicSvc;

	/*
	 * keyword = keyword in topic name -GET | /api/topics | Get all topics -GET |
	 * /api/topics/{topic.id} | Get topic by ID -GET | /api/topics/keyword/{keyword}
	 * | Get all topics by keyword -GET |
	 * /api/topics/startDate/{startDate}/endDate/{endDate} | Get all topics by
	 * start/end date -GET |
	 * /api/topics/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} | Get
	 * all topics by keyword + date -GET | /api/topics/instructor/{instructor} | Get
	 * all topics by Instructor -GET |
	 * /api/topics/instructor/{instructor}/startDate/{startDate}/endDate/{endDate} |
	 * Get all topics by Instructor + Date -GET |
	 * /api/topics/instructor/{instructor}/keyword/{keyword} | Get all topics by
	 * Instructor + Keyword GET |
	 * /api/topics/instructor/{instructor}/keyword/{keyword}/startDate/{startDate}/
	 * endDate/{endDate} | Get topics by Instructor, Keyword, Date
	 */

	@GetMapping("/")
	public List<Topic> index() {
		return topicSvc.findAll();
	}

	@GetMapping("/{id}")
	public Topic getTopicById(@PathVariable int id) {
		return topicSvc.findById(id);
	}

	@GetMapping("/keyword/{keyword}")
	public List<Topic> findTopicsByKeyword(@PathVariable String keyword) {

		return null;
	}

	@GetMapping("/startDate/{startDate}/endDate/{endDate}")
	public List<Topic> findTopicsInDateRange(@PathVariable Date startDate, @PathVariable Date endDate) {

		return null;

	}

	@GetMapping("/keyword/{keyword}/startDate/{startDate}/endDate/{endDate}")
	public List<Topic> findTopicsByKeywordInDateRange(@PathVariable String keyword, @PathVariable Date startDate,
			@PathVariable Date endDate) {

		return null;
	}

	@GetMapping("/instructor/{instructor}")
	public List<Topic> findTopicsByInstructor(@PathVariable Instructor instructor) {

		return null;
	}

	@GetMapping("instructor/{instructor}/startDate/{startDate}/endDate/{endDate}")
	public List<Topic> findTopicsByInstructorInDateRange(@PathVariable Instructor instructor,
			@PathVariable Date startDate, @PathVariable Date endDate) {
		return null;
	}

	@GetMapping("instructor/{instructor}/keyword/{keyword}")
	public List<Topic> findTopicsByInstructorAndTopicKeyword(@PathVariable Instructor instructor,
			@PathVariable String keyword) {

		return null;
	}

	@GetMapping("instructor/{instructor}/keyword/{keyword}/startDate/{startDate}/endDate/{endDate}")
	public List<Topic> findTopicsByInstructorAndTopicKeywordInDateRange(@PathVariable Instructor instructor,
			@PathVariable String keyword, @PathVariable Date startDate, @PathVariable Date endDate) {
		return null;
	}

}
