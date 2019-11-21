package com.skilldistillery.tat.services;

import java.util.List;

import com.skilldistillery.tat.entities.Topic;

public interface TopicService {
	List<Topic> findAll();
	Topic findById(int id);
	Topic createTopic(Topic topic);
	Topic updateTopic(Topic topicToUpdate);
	Boolean deleteTopic(int id);
	
	
}
