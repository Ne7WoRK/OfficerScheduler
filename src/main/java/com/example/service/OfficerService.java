package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import com.example.model.*;
import com.example.repositories.OfficersRepository;

@Service
public class OfficerService {
	
	@Autowired
	private OfficersRepository officersRepository;
	
	//Adding officer to the database
	public void addOfficer(Officer officer) {
		officersRepository.save(officer);
	}
	
	//Delete officer from database
	public void deleteOfficer (long id) {
		officersRepository.deleteById(id);
	}
	
	//Get an officer by his id.
	public Officer getOfficer(int id) {
		return officersRepository.getOfficer(id);
	}
	
	//Gives back all officers in a list.
	public List<Officer> findAll(){
		List<Officer> officers = new ArrayList<Officer>(officersRepository.findAll());
		
		return officers;
	}
	
	//Get officer photo by officer id.
	public byte[] loadPhoto (int officerID) {
		return officersRepository.loadPhoto(officerID);
	}

}
