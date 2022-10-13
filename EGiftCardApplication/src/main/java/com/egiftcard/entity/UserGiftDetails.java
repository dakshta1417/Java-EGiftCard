package com.egiftcard.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

//Specifies class is an entity and is mapped to a database table.
@Entity

//Specifies the name of the database table to be used for mapping
@Table(name = "user_gift_details")

public class UserGiftDetails {

	@Id // Specifies the primary key of an entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// @Column annotation used for adding the name of the column in database
	@Column(name = "user_gift_id")
	private int userGiftId;
	@Column(name = "gift_card_amount")
	private float giftCardAmount;
	@Column(name = "card_issue_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Temporal(value = TemporalType.DATE)
	private Date cardIssueDate;
	@Column(name = "card_reloadable")
	private boolean cardReloadable;
	@NotBlank(message = "Name is mandatory")
	@Column(name = "recepient_name")
	private String recepientName;
	// @Range(min = 10, max = 10)
	@Column(name = "recepient_mobile")
	private long receipientMobile;

	@Column(name = "recepient_email")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email is not valid")
	private String recepientEmail;

	@Column(name = "delivery_type")
	private String deliveryType;

	@FutureOrPresent
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "schedule_delivery")
	private LocalDate scheduleDelivery;

	@ManyToOne 
	@JoinColumn(name = "userid")
	private User user;

	@ManyToOne
	@JoinColumn(name = "gift_card_id")
	private GiftCard giftCard;

	@ManyToOne 
	@JoinColumn(name = "personalize_id")
	private Personalize personalize;

	public int getUserGiftId() {
		return userGiftId;
	}

	public void setUserGiftId(int userGiftId) {
		this.userGiftId = userGiftId;
	}

	public float getGiftCardAmount() {
		return giftCardAmount;
	}

	public void setGiftCardAmount(float giftCardAmount) {
		this.giftCardAmount = giftCardAmount;
	}

	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}

	public boolean isCardReloadable() {
		return cardReloadable;
	}

	public void setCardReloadable(boolean cardReloadable) {
		this.cardReloadable = cardReloadable;
	}

	public String getRecepientName() {
		return recepientName;
	}

	public void setRecepientName(String recepientName) {
		this.recepientName = recepientName;
	}

	public long getReceipientMobile() {
		return receipientMobile;
	}

	public void setReceipientMobile(long receipientMobile) {
		this.receipientMobile = receipientMobile;
	}

	public String getRecepientEmail() {
		return recepientEmail;
	}

	public void setRecepientEmail(String recepientEmail) {
		this.recepientEmail = recepientEmail;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public LocalDate getScheduleDelivery() {
		return scheduleDelivery;
	}

	public void setScheduleDelivery(LocalDate scheduleDelivery) {
		this.scheduleDelivery = scheduleDelivery;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public GiftCard getGiftCard() {
		return giftCard;
	}

	public void setGiftCard(GiftCard giftCard) {
		this.giftCard = giftCard;
	}

	public Personalize getPersonalize() {
		return personalize;
	}

	public void setPersonalize(Personalize personalize) {
		this.personalize = personalize;
	}

	@Override
	public String toString() {
		return "UserGiftDetails [userGiftId=" + userGiftId + ", giftCardAmount=" + giftCardAmount + ", cardIssueDate="
				+ cardIssueDate + ", cardReloadable=" + cardReloadable + ", recepientName=" + recepientName
				+ ", receipientMobile=" + receipientMobile + ", recepientEmail=" + recepientEmail + ", deliveryType="
				+ deliveryType + ", scheduleDelivery=" + scheduleDelivery + ", user=" + user + ", giftCard=" + giftCard
				+ ", personalize=" + personalize + "]";
	}

	public UserGiftDetails(int userGiftId, float giftCardAmount, Date cardIssueDate, boolean cardReloadable,
			String recepientName, long receipientMobile, String recepientEmail, String deliveryType,
			LocalDate scheduleDelivery, User user, GiftCard giftCard, Personalize personalize) {
		super();
		this.userGiftId = userGiftId;
		this.giftCardAmount = giftCardAmount;
		this.cardIssueDate = cardIssueDate;
		this.cardReloadable = cardReloadable;
		this.recepientName = recepientName;
		this.receipientMobile = receipientMobile;
		this.recepientEmail = recepientEmail;
		this.deliveryType = deliveryType;
		this.scheduleDelivery = scheduleDelivery;
		this.user = user;
		this.giftCard = giftCard;
		this.personalize = personalize;
	}

	public UserGiftDetails() {
		super();
	}

}
