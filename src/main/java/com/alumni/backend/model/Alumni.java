package com.alumni.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Alumni_details")
public class Alumni {
	
	
	@Id
	@Column(name = "Alumni_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int alumniId;
	
	@Column(name = "Alumni_name")
	private String alumniName;
	
	@Column(name = "Alumni_Email")
	private String alumniEmail;
	
	@Column(name = "Current_work_place")
	private String alumniWorkPlace;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Contact_number")
	private String contactPhoneNumber;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Industry")
	private String industry;
	
	@Column(name = "Experience")
	private String experience;
	
	@Column(name = "Graduation_year")
	private String graduationYear;
	

	public int getAlumniId() {
		return alumniId;
	}

	public void setAlumniId(int alumniId) {
		this.alumniId = alumniId;
	}

	public String getAlumniName() {
		return alumniName;
	}

	public void setAlumniName(String alumniName) {
		this.alumniName = alumniName;
	}

	public String getAlumniEmail() {
		return alumniEmail;
	}

	public void setAlumniEmail(String alumniEmail) {
		this.alumniEmail = alumniEmail;
	}

	public String getAlumniWorkPlace() {
		return alumniWorkPlace;
	}

	public void setAlumniWorkPlace(String alumniWorkPlace) {
		this.alumniWorkPlace = alumniWorkPlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPriorWorkPlace(String password) {
		this.password = password;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}


}
