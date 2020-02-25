package com.skilldistillery.tat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tat.entities.Instructor;
import com.skilldistillery.tat.repositories.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	
	@Autowired
	InstructorRepository instructorRepo;

	@Override
	public List<Instructor> findAll() {
		return instructorRepo.findAll();
	}

	@Override
	public Instructor create(Instructor newInstructor) {
		return instructorRepo.saveAndFlush(newInstructor);
	}

	@Override
	public Instructor update(int instructorId, Instructor newInstructorInfo) {
		Optional<Instructor> oldInstructorInfoOpt = instructorRepo.findById(instructorId);
		Instructor managedInstructor = null;
		if (oldInstructorInfoOpt.isPresent()) {
			managedInstructor = oldInstructorInfoOpt.get();
			
			managedInstructor.setName(newInstructorInfo.getName());
			managedInstructor.setActive(newInstructorInfo.isActive());
		
			instructorRepo.saveAndFlush(managedInstructor);
		}
		
		return managedInstructor;
	}

	@Override
	public Instructor findByName(String instructorName) {
		return instructorRepo.findByName(instructorName);
	}

	@Override
	public List<Instructor> findByActive(boolean isActive) {
		return instructorRepo.findByActive(isActive);
	}
	
	
	
	

}
