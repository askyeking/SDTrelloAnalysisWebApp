package com.skilldistillery.tat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.tat.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
