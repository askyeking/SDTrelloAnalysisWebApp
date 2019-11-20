package com.skilldistillery.tat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tat.entities.Instructor;
import com.skilldistillery.tat.repositories.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	
	@Autowired
	InstructorRepository instructorRepo;

	@Override
	public List<Instructor> index() {
		return instructorRepo.findAll();
	}
	
	

}
