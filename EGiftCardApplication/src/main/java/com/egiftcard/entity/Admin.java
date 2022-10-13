package com.egiftcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Admin")
public class Admin
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="adminId")
	private int adminId;
	
	@Pattern(regexp = "^[A-Za-z]+$", message = "First name is invalid, must contain alphabets only.")
	@Column(name="FirstName")
	private String adminFirstName;
	
	@Pattern(regexp = "^[A-Za-z]+$", message = "Last name is invalid, must contain alphabets only.")
	@Column(name="LastName")
	private String adminLastName;

	@Column(name="Age")
	private String age;
	
	@Email
	@Column(name="Email")
	private String email;
	
	@Pattern(regexp = "[A-Za-z0-9!@#$%&*]+", message = "Password does not match the policy.")
	@Column(name="Password")
	private String password;
	
	@Pattern(regexp = "^[0-9]{10}", message = "Contact number should have 10 digits only")
	@Column(name= "Contact")
	private String contact;
	
//	@OneToMany
//	@JoinColumn(name="adminId")
//	private User user;
//	
//	@OneToMany
//	@JoinColumn(name="adminId")
//	private PaymentDetails paymentDetails;
//	
//	@OneToMany
//	@JoinColumn(name="adminId")
//	private GiftCard giftCard;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public PaymentDetails getPaymentDetails() {
//		return paymentDetails;
//	}
//
//	public void setPaymentDetails(PaymentDetails paymentDetails) {
//		this.paymentDetails = paymentDetails;
//	}
//
//	public GiftCard getGiftCard() {
//		return giftCard;
//	}
//
//	public void setGiftCard(GiftCard giftCard) {
//		this.giftCard = giftCard;
//	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

public Admin(int adminId,
		@Pattern(regexp = "^[A-Za-z]+$", message = "First name is invalid, must contain alphabets only.") String adminFirstName,
		@Pattern(regexp = "^[A-Za-z]+$", message = "Last name is invalid, must contain alphabets only.") String adminLastName,
		String age, @Email String email,
		@Pattern(regexp = "[A-Za-z0-9!@#$%&*]+", message = "Password does not match the policy.") String password,
		@Pattern(regexp = "^[0-9]{10}", message = "Contact number should have 10 digits only") String contact) {
	super();
	this.adminId = adminId;
	this.adminFirstName = adminFirstName;
	this.adminLastName = adminLastName;
	this.age = age;
	this.email = email;
	this.password = password;
	this.contact = contact;
}

@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminFirstName=" + adminFirstName + ", adminLastName=" + adminLastName
			+ ", age=" + age + ", email=" + email + ", password=" + password + ", contact=" + contact + "]";
}



}
