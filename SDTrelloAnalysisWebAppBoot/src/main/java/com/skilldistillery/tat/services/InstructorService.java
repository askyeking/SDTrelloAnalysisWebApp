package com.skilldistillery.tat.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.tat.entities.Instructor;

@Service
public interface InstructorService {
	
	List<Instructor> findAll();
	List<Instructor> findByActive(boolean isActive);
	Instructor create(Instructor newInstructor);
	Instructor update(int instructorId, Instructor newInstructorInfo);
	Instructor findByName(String instructorName);
}
