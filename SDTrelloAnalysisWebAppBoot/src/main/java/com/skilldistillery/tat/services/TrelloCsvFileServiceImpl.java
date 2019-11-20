package com.skilldistillery.tat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tat.entities.TrelloCsvFile;
import com.skilldistillery.tat.repositories.TrelloCsvFileRepository;

@Service
public class TrelloCsvFileServiceImpl implements TrelloCsvFileService{
	
	@Autowired
	TrelloCsvFileRepository csvRepo;

	@Override
	public List<TrelloCsvFile> index() {
		return csvRepo.findAll();
	}
	
	

}
