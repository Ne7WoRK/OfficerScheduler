package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;
import com.example.model.*;
import com.example.repositories.OfficersRepository;

@Service
@Transactional
public class OfficerService implements com.example.interfaces.OfficerService {
	
	@Autowired
	private OfficersRepository officersRepository;
	
	//Get officer by his unique id.
	public Officer getOfficer(long id) {
		return officersRepository.findById(id).get();
	}
	
	//Gives back all officers in a list.
	public List<Officer> findAll(){
		return officersRepository.findAll();
	}
	
	//Adding officer to the database
	public void addOfficer(Officer officer) {
		officersRepository.save(officer);
	}
	
	//Delete officer from database
	public void deleteOfficer (long id) {
		officersRepository.deleteById(id);
	}
}
