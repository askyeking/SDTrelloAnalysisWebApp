package com.skilldistillery.tat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.tat.entities.TrelloCsvFile;

public interface TrelloCsvFileRepository extends JpaRepository<TrelloCsvFile, Integer> {

}
