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
	List<Topic> findAll();
	
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
	
//	* GET | /api/topics/instructor/{instructor} 	| Get all topics by Instructor NAME
	public List<Topic> findByInstructors_NameLike(String instructorName);
	
//	* GET | /api/topics/instructor/{instructor} 	| Get all topics by Instructor ID
	public List<Topic> findByInstructorsId(int instructorId);

//	* GET | /api/topics/instructor/{instructor}/startDate/{startDate}/endDate/{endDate} 	| Get all topics by Instructor + Date 
	/*
	 * SELECT * FROM topic JOIN instructor_topic ON instructor_topic.topic_id  = topic.id 
		JOIN instructor ON instructor_topic.instructor_id = instructor.id  
		WHERE instructor.name LIKE 'testInstructor' AND topic.date BETWEEN '2019-11-01' AND '2019-12-15';
	 */
	//***may need to switch the order of parameters to have instructors last***
	public List<Topic> findByInstructorsNameLikeAndDateLecturedBetween(String name, Date startDate, Date endDate);
	//may need to switch the order of parameters!
	public List<Topic> findByInstructors_IdAndDateLecturedBetween(int instructorId, Date startDate, Date endDate);
	
	
//	* GET | /api/topics/instructor/{instructor}/keyword/{keyword} 	| Get all topics by Instructor + Keyword 
	public List<Topic> findByNameLikeAndDescriptionLikeAndInstructors_NameLike(String keywordTopicName, String keywordTopicDescr, String instructorName);
	public List<Topic> findByNameLikeAndDescriptionLikeAndInstructorsId(String keywordTopicName, String keywordTopicDescr, int instructorId);

	
	//***May need to switch the order of parameters to have instructor last***
//	* GET | /api/topics/instructor/{instructor}/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get topics by Instructor, Keyword, Date
	public List<Topic> findByNameLikeAndDescriptionLikeAndInstructors_NameLikeAndDateLecturedBetween(String keywordTopicName, String keywordTopicDescr, String instructorName, Date startDate, Date endDate);
	public List<Topic> findByNameLikeAndDescriptionLikeAndInstructorsIdAndDateLecturedBetween(String keywordTopicName, String keywordTopicDescr, int instructorId, Date startDate, Date endDate);
}
