package com.egiftcard.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Specifies class is an entity and is mapped to a database table.
@Entity
@Table(name = "gift_received_details")
public class GiftReceivedDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "gift_received_id")
	private int giftReceivedId;
	@Column(name = "gift_received_date")
	private Date giftReceivedDate;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	@ManyToOne
	@JoinColumn(name = "user_gift_details")
	private UserGiftDetails userGiftDetails;

	public int getGiftReceivedId() {
		return giftReceivedId;
	}

	public void setGiftReceivedId(int giftReceivedId) {
		this.giftReceivedId = giftReceivedId;
	}

	public Date getGiftReceivedDate() {
		return giftReceivedDate;
	}

	public void setGiftReceivedDate(Date giftReceivedDate) {
		this.giftReceivedDate = giftReceivedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserGiftDetails getUserGiftDetails() {
		return userGiftDetails;
	}

	public void setUserGiftDetails(UserGiftDetails userGiftDetails) {
		this.userGiftDetails = userGiftDetails;
	}

	@Override
	public String toString() {
		return "GiftReceivedDetails [giftReceivedId=" + giftReceivedId + ", giftReceivedDate=" + giftReceivedDate
				+ ", user=" + user + ", userGiftDetails=" + userGiftDetails + "]";
	}

	public GiftReceivedDetails(int giftReceivedId, Date giftReceivedDate, User user, UserGiftDetails userGiftDetails) {
		super();
		this.giftReceivedId = giftReceivedId;
		this.giftReceivedDate = giftReceivedDate;
		this.user = user;
		this.userGiftDetails = userGiftDetails;
	}

	public GiftReceivedDetails() {
		super();

	}

}
