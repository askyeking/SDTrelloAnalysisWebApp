package com.skilldistillery.tat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.tat.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
