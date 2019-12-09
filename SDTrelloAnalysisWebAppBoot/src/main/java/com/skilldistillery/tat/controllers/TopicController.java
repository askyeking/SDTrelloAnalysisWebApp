package com.skilldistillery.tat.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

	// success
	@GetMapping("/")
	public List<Topic> index() {
		return topicSvc.findAll();
	}

	// success
	@GetMapping("/{id}")
	public Topic getTopicById(@PathVariable int id) {
		return topicSvc.findById(id);
	}
	
	//success
	@GetMapping("keyword/{keyword}")
	public List<Topic> findTopicsByKeyword(@PathVariable String keyword) {
		return topicSvc.findByKeyword(keyword);
	}

	//success
	@GetMapping("/startDate/{startDate}/endDate/{endDate}")
	public List<Topic> findTopicsInDateRange(@PathVariable String startDate, @PathVariable String endDate) {
		return topicSvc.findByDate(startDate, endDate);
	}

	
	@GetMapping("/keyword/{keyword}/startDate/{startDate}/endDate/{endDate}")
	public List<Topic> findTopicsByKeywordInDateRange(@PathVariable String keyword, @PathVariable String startDate,
			@PathVariable String endDate) {
		return topicSvc.findByKeywordAndDate(keyword, startDate, endDate);
	}
	
	//success
	@GetMapping("/instructor/{instructorId}")
	public List<Topic> findTopicsByInstructor(@PathVariable int instructorId) {
		return topicSvc.findByInstructorId(instructorId);
	}

	//success
	@GetMapping("instructor/{instructorId}/startDate/{startDate}/endDate/{endDate}")
	public List<Topic> findTopicsByInstructorInDateRange(@PathVariable int instructorId, @PathVariable String startDate,
			@PathVariable String endDate) {
		return topicSvc.findByInstructorIdAndDate(instructorId, startDate, endDate);
	}
	//success
	@GetMapping("instructor/{instructorId}/keyword/{keyword}")
	public List<Topic> findTopicsByInstructorAndTopicKeyword(@PathVariable int instructorId,
			@PathVariable String keyword) {
		return topicSvc.findByKeywordAndInstructorId(keyword, instructorId);
	}

	//success
	@GetMapping("instructor/{instructorId}/keyword/{keyword}/startDate/{startDate}/endDate/{endDate}")
	public List<Topic> findTopicsByInstructorAndTopicKeywordInDateRange(@PathVariable int instructorId,
			@PathVariable String keyword, @PathVariable String startDate, @PathVariable String endDate) {
		return topicSvc.findByKeywordAndInstructorIdAndDate(keyword, instructorId, startDate, endDate);
	}

}
