package com.skilldistillery.tat.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.*;

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
	public List<Topic> findByDate(String startDate, String endDate) {
		LocalDate startLocalDate = LocalDate.parse(startDate);
		LocalDate endLocalDate = LocalDate.parse(endDate);
		return topicRepo.findByDateLecturedBetween(startLocalDate, endLocalDate);
	}
	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndDate(String keyword, String startDate, String endDate) {
		keyword = "%" + keyword + "%";
		LocalDate startLocalDate = LocalDate.parse(startDate);
		LocalDate endLocalDate = LocalDate.parse(endDate);
		return topicRepo.findByNameLikeOrDescriptionLikeAndDateLecturedBetween(keyword, keyword, startLocalDate, endLocalDate);
	}

	@Override
	public List<Topic> findByInstructorId(int instructorId) {
		return topicRepo.findByInstructorsId(instructorId);
	}

//	@Override
//	public List<Topic> findByInstructorName(String instructorName) {
//		return topicRepo.findByInstructors_NameLike(instructorName);
//	}

	@Override
	public List<Topic> findByInstructorIdAndDate(int instructorId, String startDate, String endDate) {
		LocalDate startLocalDate = LocalDate.parse(startDate);
		LocalDate endLocalDate = LocalDate.parse(endDate);
		return topicRepo.findByInstructors_IdAndDateLecturedBetween(instructorId, startLocalDate, endLocalDate);
	}
//	@Override
//	public List<Topic> findByInstructorNameAndDate(String instructorName, String startDate, String endDate) {
//		LocalDate startLocalDate = LocalDate.parse(startDate);
//		LocalDate endLocalDate = LocalDate.parse(endDate);
//		return topicRepo.findByInstructorsNameLikeAndDateLecturedBetween(instructorName, startLocalDate, endLocalDate);
//	}
	
	// Methods with LIKE need to have a wildcard somewhere in the parameters
//	@Override
//	public List<Topic> findByKeywordAndInstructorName(String keyword, String instructorName) {
//		keyword = "%" + keyword + "%";
//		return topicRepo.findByNameLikeOrDescriptionLikeAndInstructors_NameLike(keyword, keyword, instructorName);
//	}
	
	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorId(String keyword, int instructorId) {
		keyword = "%" + keyword + "%";
		return topicRepo.findByNameLikeOrDescriptionLikeAndInstructorsId(keyword, keyword, instructorId);
	}

	// Methods with LIKE need to have a wildcard somewhere in the parameters
//	@Override
//	public List<Topic> findByKeywordAndInstructorNameAndDate(String keyword, String instructorName, String startDate, String endDate) {
//		keyword = "%" + keyword + "%";
//		LocalDate startLocalDate = LocalDate.parse(startDate);
//		LocalDate endLocalDate = LocalDate.parse(endDate);
//		return topicRepo.findByNameLikeAndDescriptionLikeAndInstructors_NameLikeAndDateLecturedBetween(keyword, keyword, instructorName, startLocalDate, endLocalDate);
//	}

	// Methods with LIKE need to have a wildcard somewhere in the parameters
	@Override
	public List<Topic> findByKeywordAndInstructorIdAndDate(String keyword, int instructorId, String startDate, String endDate) {
		keyword = "%" + keyword + "%";
		LocalDate startLocalDate = LocalDate.parse(startDate);
		LocalDate endLocalDate = LocalDate.parse(endDate);
		return topicRepo.findByNameLikeOrDescriptionLikeAndInstructorsIdAndDateLecturedBetween(keyword, keyword, instructorId, startLocalDate, endLocalDate);
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
