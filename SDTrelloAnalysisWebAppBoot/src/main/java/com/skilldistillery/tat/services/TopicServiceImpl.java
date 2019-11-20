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

	@Override
	public List<Topic> index() {
		return topicRepo.findAll();
	}
	
	

}
