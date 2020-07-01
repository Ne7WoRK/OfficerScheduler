package com.example.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "officers")
public class Officer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	
	
	@Column(name = "mobile", nullable = false)
	private String mobile;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "photo", nullable =  true)
	private String photo;

	
	
	@Column(name = "isAvailable", nullable =  false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isAvailable;
	

	@Column(name = "dateFrom")
	private Date absentFrom;

	@Column(name = "dateTo")
	private Date absentTo;

	public long getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String surname) {
		this.lastName = surname;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Date getAbsentFrom() {
		return absentFrom;
	}

	public void setAbsentFrom(Date absentFrom) {
		this.absentFrom = absentFrom;
	}

	public Date getAbsentTo() {
		return absentTo;
	}

	public void setAbsentTo(Date absentTo) {
		this.absentTo = absentTo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	//Default constructor
	public Officer() {
		super();
	}

	// Constructor for availability
	public Officer(int ID, String name, String lastName, String mobile, boolean isAvailable,String photo) {
		this.ID = ID;
		this.firstName = name;
		this.lastName = lastName;
		this.photo = photo;
		this.mobile = mobile;
		this.isAvailable = isAvailable;

	}

	// Constructor for absence
	public Officer(int ID, String name, String lastname,String photo, String mobile, Date absentFrom, Date absentTo) {
		this.ID = ID;
		this.firstName = name;
		this.lastName = lastname;
		this.photo = photo;
		this.mobile = mobile;
		this.isAvailable = false;
		this.absentFrom = absentFrom;
		this.absentTo = absentTo;
	}

	@Override
	public String toString() {
		if (isAvailable == false) {
			return ("ID:" + getID() + "\nFirst name: " + getFirstName() + "\nLast name: " + getLastName()
					+ "\nPhoto: " + photo + "\nMobile number: " + mobile + "\nAvailable: " + isAvailable + "\nAbsent from: " + absentFrom + "\nAbsent to: " + absentTo);
		} else {
			return ("ID:" + getID() + "\nFirst name: " + getFirstName() + "\nLast name: " + getLastName()
					+ "\nPhoto: " + photo + "\nMobile: number: " + "\nAvailable: " + isAvailable);
		}
	}

}
