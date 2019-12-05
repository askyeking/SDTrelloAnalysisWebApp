package com.skilldistillery.tat.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tat.entities.Topic;
import com.skilldistillery.tat.repositories.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	TopicRepository topicRepo;


	@Override
	public List<Topic> findAll() {
		return topicRepo.findAll();
	}

	@Override
	public Topic findById(int id) {
		return topicRepo.findById(id);
	}

	@Override
	public Topic createTopic(Topic newTopic) {
		return topicRepo.saveAndFlush(newTopic);
	}

	@Override
	public List<Topic> findByKeyword(String keyword) {
		return topicRepo.findByKeyword(keyword, keyword);
	}

	@Override
	public List<Topic> findByDate(Date startDate, Date endDate) {
		return topicRepo.findByDateLecturedBetween(startDate, endDate);
	}
	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndDate(String keyword, Date startDate, Date endDate) {
		keyword = "%" + keyword + "%";
		return topicRepo.findByKeywordLikeAndDateLecturedBetween(keyword, startDate, endDate);
	}

	@Override
	public List<Topic> findByInstructorId(int instructorId) {
		return topicRepo.findByInstructorsId(instructorId);
	}

	@Override
	public List<Topic> findByInstructorName(String instructorName) {
		return topicRepo.findByInstructors_NameLike(instructorName);
	}

	@Override
	public List<Topic> findByInstructorIdAndDate(int instructorId, Date startDate, Date endDate) {
		return topicRepo.findByInstructors_IdAndDateLecturedBetween(instructorId, startDate, endDate);
	}
	@Override
	public List<Topic> findByInstructorNameAndDate(String instructorName, Date startDate, Date endDate) {
		return topicRepo.findByInstructorsNameLikeAndDateLecturedBetween(instructorName, startDate, endDate);
	}
	
	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorName(String keyword, String instructorName) {
		keyword = "%" + keyword + "%";
		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructors_NameLike(keyword, keyword, instructorName);
	}
	
	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorId(String keyword, int instructorId) {
//		keyword = "%" + keyword + "%";
		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructorsId(keyword, keyword, instructorId);
	}

	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorNameAndDate(String keyword, String instructorName, Date startDate, Date endDate) {
		keyword = "%" + keyword + "%";
		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructors_NameLikeAndDateLecturedBetween(keyword, keyword, instructorName, startDate, endDate);
	}

	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorIdAndDate(String keyword, int instructorId, Date startDate, Date endDate) {
		keyword = "%" + keyword + "%";
		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructorsIdAndDateLecturedBetween(keyword, keyword, instructorId, startDate, endDate);
	}
	
	

//	@Override
//	public Topic updateTopic(Topic topicToUpdate) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Boolean deleteTopic(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}
