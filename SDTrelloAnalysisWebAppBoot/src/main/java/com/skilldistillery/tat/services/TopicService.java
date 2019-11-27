package com.skilldistillery.tat.services;

import java.util.Date;
import java.util.List;

import com.skilldistillery.tat.entities.Topic;

public interface TopicService {
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
	
	List<Topic> findAll();
	Topic findById(int id);
	List<Topic> findByKeyword(String keyword);
	List<Topic> findByDate (Date startDate, Date endDate);
	List<Topic> findByKeywordAndDate (String keyword, Date startDate, Date endDate);
	List<Topic> findByInstructorId(int instructorId);
	//we'll use the id one, but just in case we need to find by name as well
	List<Topic> findByInstructorName(String instructorName);
	List<Topic> findByInstructorNameAndDate(String instructorName, Date startDate, Date endDate);
	List<Topic> findByInstructorIdAndDate(int instructorId, Date startDate, Date endDate);
	List<Topic>	findByKeywordAndInstructorName(String keywordTopicName, String keywordTopicDesc, String instructorName);
	List<Topic>	findByKeywordAndInstructorId(String keywordTopicName, String keywordTopicDesc, int instructorId);
	List<Topic> findByKeywordAndInstructorNameAndDate(String keywordTopicName, String keywordTopicDescr, String instructorName, Date startDate, Date endDate);
	List<Topic> findByKeywordAndInstructorIdAndDate(String keywordTopicName, String keywordTopicDescr, int instructorId, Date startDate, Date endDate);
	Topic createTopic(Topic topic);
//	Topic updateTopic(Topic topicToUpdate);
//	Boolean deleteTopic(int id);
	
	
}
