package com.skilldistillery.tat.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.tat.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	Instructor findByName(String name);
	List<Instructor> findByActive(boolean isActive);
}
