package com.skilldistillery.tat.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.tat.entities.Instructor;

@Service
public interface InstructorService {
	
	List<Instructor> index();
	
}
