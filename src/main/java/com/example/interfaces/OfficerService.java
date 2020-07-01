package com.example.interfaces;

import java.util.List;

import com.example.model.Officer;

public interface OfficerService {
	
	public Officer getOfficer(long id);
	
	public void addOfficer(Officer officer);
	
	public void deleteOfficer (long id);
	
	public List<Officer> findAll();

}
