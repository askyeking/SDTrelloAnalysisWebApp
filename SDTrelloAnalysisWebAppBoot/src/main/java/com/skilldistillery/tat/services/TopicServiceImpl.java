package com.skilldistillery.tat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tat.entities.Topic;
import com.skilldistillery.tat.repositories.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	TopicRepository topicRepo;
	
	/*
	 * Get	| /api/topics
	 */

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
	public Topic updateTopic(Topic topicToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteTopic(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
