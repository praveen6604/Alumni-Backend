package com.alumni.backend.model;

import javax.persistence.*;


@Entity
@Table(name = "Give")
public class Give {
	
	@Id
	@Column(name = "Give_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int giveId;
	
	
	@Column(name = "User_id")
	private int userId;
	
	
	@Column(name = "Amount")
	private Double amount;
	
	@Column(name = "Comment")
	private String Comment;

	public int getGiveId() {
		return giveId;
	}

	public void setGiveId(int giveId) {
		this.giveId = giveId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
	
	
	

}
