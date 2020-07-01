package com.example.model;


public class Teams {
	
	private Officer officerOne;
	private Officer offcerTwo;
	
	public Officer getOfficerOne() {
		return officerOne;
	}
	
	public void setOfficerOne(Officer officerOne) {
		this.officerOne = officerOne;
	}
	
	public Officer getOffcerTwo() {
		return offcerTwo;
	}
	
	public void setOffcerTwo(Officer offcerTwo) {
		this.offcerTwo = offcerTwo;
	}
	
	public Teams(Officer one, Officer two) {
		this.officerOne = getOfficerOne();
		this.offcerTwo = getOffcerTwo();
	}
	
	@Override
	public String toString() {
		return officerOne.toString() + "\n" + offcerTwo.toString();
	}

}
