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
		return topicRepo.findByKeyword(keyword);
	}

	@Override
	public List<Topic> findByDate(Date startDate, Date endDate) {
		return topicRepo.findAllByDateBetween(startDate, endDate);
	}
	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndDate(String keyword, Date startDate, Date endDate) {
		return topicRepo.findByKeywordLikeAndDateBetween(keyword, startDate, endDate);
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
	public List<Topic> findByKeywordAndInstructorName(String keywordTopicName, String keywordTopicDesc,
			String instructorName) {
		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructors_NameLike(keywordTopicName, keywordTopicDesc, instructorName);
	}
	
	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorId(String keywordTopicName, String keywordTopicDesc,
			int instructorId) {
		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructorsId(keywordTopicName, keywordTopicDesc, instructorId);
	}

	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorNameAndDate(String keywordTopicName, String keywordTopicDescr,
			String instructorName, Date startDate, Date endDate) {
		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructors_NameLikeAndDateLecturedBetween(keywordTopicName, keywordTopicDescr, instructorName, startDate, endDate);
	}

	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorIdAndDate(String keywordTopicName, String keywordTopicDescr,
			int instructorId, Date startDate, Date endDate) {
		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructorsIdAndDateLecturedBetween(keywordTopicName, keywordTopicDescr, instructorId, startDate, endDate);
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
