package com.alumni.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Event")
public class Event {
	
	@Id
	@Column(name = "Event_id")
	private int eventId;
	
	@Column(name = "Event_name")
	private String eventName;
	
	@Column(name = "Event_description")
	private String eventDescription;
	
	@Column(name = "Enrol_user")
	private Boolean enrolUser;
	
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public Boolean getEnrolUser() {
		return enrolUser;
	}

	public void setEnrolUser(Boolean enrolUser) {
		this.enrolUser = enrolUser;
	}
	
	

}
