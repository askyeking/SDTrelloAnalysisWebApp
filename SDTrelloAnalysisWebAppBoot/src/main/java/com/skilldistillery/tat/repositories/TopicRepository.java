package com.skilldistillery.tat.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skilldistillery.tat.entities.Topic;


public interface TopicRepository extends JpaRepository<Topic, Integer> {

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
	
	//GET | /api/topics 			| Get all topics 
	List<Topic> findAllTopics();
	
	//GET | /api/topics/{topic.id} 	| Get topic by ID 
	Topic findById(int id);
	
	
	//GET | /api/topics/keyword/{keyword} 	| Get all topics by keyword 
	@Query("SELECT topic FROM Topic topic WHERE topic.name LIKE %:keyword% OR topic.description LIKE %:keyword%")
	public  List<Topic> findByKeyword(String keyword);
	
	//GET | /api/topics/startDate/{startDate}/endDate/{endDate}		| Get all topics by start/end date 
	List<Topic> findAllByDateBetween(Date startDate, Date endDate);
	
//	* GET | /api/topics/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get all topics by keyword + date 
	@Query("SELECT topic FROM Topic topic WHERE topic.name LIKE %:keyword% OR topic.description LIKE %:keyword% AND topic.date BETWEEN :startDate AND :endDate ")
	public  List<Topic> findByKeywordLikeAndDateBetween(String keyword, Date startDate, Date endDate);

//	* GET | /api/topics/instructor/{instructor} 	| Get all topics by Instructor 
	public List<Topic> findByTopic_Instructors_Name

//	* GET | /api/topics/instructor/{instructor}/startDate/{startDate}/endDate/{endDate} 	| Get all topics by Instructor + Date 

	
//	* GET | /api/topics/instructor/{instructor}/keyword/{keyword} 	| Get all topics by Instructor + Keyword //	* GET | /api/topics/instructor/{instructor}/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get topics by Instructor, Keyword, Date

	
//	* GET | /api/topics/instructor/{instructor}/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get topics by Instructor, Keyword, Date
}
