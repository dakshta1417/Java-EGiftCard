package com.egiftcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

//Specifies class is an entity and is mapped to a database table.
@Entity
@Table(name = "gift_redeem_details")
public class GiftRedeemDetails {

	@Id
	@Column(name = "gift_redeem_id")
	private int giftRedeemId;
	@Column(name = "gift_redeem_status")
	private boolean redeemStatus;
	@Column(name = "gift_redeem_date")
	private Date giftRedeemDate;
	@Column(name = "gift_redeem_amount")
	private float giftRedeemAmount;
	private float balance;

	@ManyToOne
	@JoinColumn(name = "user_gift_id")
	private UserGiftDetails userGiftDetails;

	public GiftRedeemDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiftRedeemDetails(int giftRedeemId, boolean redeemStatus, Date giftRedeemDate, float giftRedeemAmount,
			float balance, UserGiftDetails userGiftDetails) {
		super();
		this.giftRedeemId = giftRedeemId;
		this.redeemStatus = redeemStatus;
		this.giftRedeemDate = giftRedeemDate;
		this.giftRedeemAmount = giftRedeemAmount;
		this.balance = balance;
		this.userGiftDetails = userGiftDetails;
	}

	@Override
	public String toString() {
		return "GiftRedeemDetails [giftRedeemId=" + giftRedeemId + ", redeemStatus=" + redeemStatus
				+ ", giftRedeemDate=" + giftRedeemDate + ", giftRedeemAmount=" + giftRedeemAmount + ", balance="
				+ balance + ", userGiftDetails=" + userGiftDetails + "]";
	}

	public int getGiftRedeemId() {
		return giftRedeemId;
	}

	public void setGiftRedeemId(int giftRedeemId) {
		this.giftRedeemId = giftRedeemId;
	}

	public boolean isRedeemStatus() {
		return redeemStatus;
	}

	public void setRedeemStatus(boolean redeemStatus) {
		this.redeemStatus = redeemStatus;
	}

	public Date getGiftRedeemDate() {
		return giftRedeemDate;
	}

	public void setGiftRedeemDate(Date giftRedeemDate) {
		this.giftRedeemDate = giftRedeemDate;
	}

	public float getGiftRedeemAmount() {
		return giftRedeemAmount;
	}

	public void setGiftRedeemAmount(float giftRedeemAmount) {
		this.giftRedeemAmount = giftRedeemAmount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public UserGiftDetails getUserGiftDetails() {
		return userGiftDetails;
	}

	public void setUserGiftDetails(UserGiftDetails userGiftDetails) {
		this.userGiftDetails = userGiftDetails;
	}

}
