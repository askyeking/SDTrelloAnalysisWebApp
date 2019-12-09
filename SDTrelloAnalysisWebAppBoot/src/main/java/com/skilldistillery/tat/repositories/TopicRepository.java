package com.skilldistillery.tat.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.*;

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
	
	// works
	//GET | /api/topics 			| Get all topics 
	List<Topic> findAll();
	
	//works
	//GET | /api/topics/{topic.id} 	| Get topic by ID 
	Topic findById(int id);
	
	//works
	//GET | /api/topics/keyword/{keyword} 	| Get all topics by keyword 
//	@Query("SELECT topic FROM Topic topic WHERE topic.name LIKE :keyword OR topic.description LIKE :keyword")
	@Query(value="select * from topic where name like %:nameKeyword% or description like %:descKeyword%", nativeQuery=true)
	public  List<Topic> findByKeyword(@Param("nameKeyword")String nameKeyword, @Param("descKeyword")String descKeyword);
	
	//works
	//GET | /api/topics/startDate/{startDate}/endDate/{endDate}		| Get all topics by start/end date 
	List<Topic> findByDateLecturedBetween(LocalDate startDate, LocalDate endDate);
	
	//works
//	* GET | /api/topics/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get all topics by keyword + date 
	public List<Topic> findByNameLikeOrDescriptionLikeAndDateLecturedBetween(String keywordTopicName, String keywordTopicDescr, LocalDate startDate, LocalDate endDate);
//	* GET | /api/topics/instructor/{instructor} 	| Get all topics by Instructor NAME
	//public List<Topic> findByInstructors_NameLike(String instructorName);
	
	//works
//	* GET | /api/topics/instructor/{instructor} 	| Get all topics by Instructor ID
	public List<Topic> findByInstructorsId(int instructorId);

//	* GET | /api/topics/instructor/{instructor}/startDate/{startDate}/endDate/{endDate} 	| Get all topics by Instructor + Date 
	/*
	 * SELECT * FROM topic JOIN instructor_topic ON instructor_topic.topic_id  = topic.id 
		JOIN instructor ON instructor_topic.instructor_id = instructor.id  
		WHERE instructor.name LIKE 'testInstructor' AND topic.date BETWEEN '2019-11-01' AND '2019-12-15';
	 */
	//public List<Topic> findByInstructorsNameLikeAndDateLecturedBetween(String name, LocalDate startDate, LocalDate endDate);
	
	//works
	public List<Topic> findByInstructors_IdAndDateLecturedBetween(int instructorId, LocalDate startDate, LocalDate endDate);
	
	
//	* GET | /api/topics/instructor/{instructor}/keyword/{keyword} 	| Get all topics by Instructor + Keyword 
	//public List<Topic> findByNameLikeOrDescriptionLikeAndInstructors_NameLike(String keywordTopicName, String keywordTopicDescr, String instructorName);
	
	//works
	public List<Topic> findByNameLikeOrDescriptionLikeAndInstructorsId(String keywordTopicName, String keywordTopicDescr, int instructorId);

//	* GET | /api/topics/instructor/{instructor}/keyword/{keyword}/startDate/{startDate}/endDate/{endDate} 	| Get topics by Instructor, Keyword, Date
	//public List<Topic> findByNameLikeAndDescriptionLikeAndInstructors_NameLikeAndDateLecturedBetween(String keywordTopicName, String keywordTopicDescr, String instructorName, LocalDate startDate, LocalDate endDate);
	
	//works
	public List<Topic> findByNameLikeOrDescriptionLikeAndInstructorsIdAndDateLecturedBetween(String keywordTopicName, String keywordTopicDescr, int instructorId, LocalDate startDate, LocalDate endDate);
}
