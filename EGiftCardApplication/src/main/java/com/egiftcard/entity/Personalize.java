package com.egiftcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Specifies class is an entity and is mapped to a database table.
@Entity
@Table(name = "personalize")
public class Personalize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personalizeId;
	private String image;

	enum PersonalizeType {
		Birthday, Teacher, Wedding, Congratulations, Thankyou, WellDone, Love, Anniversary, MissYou
	};

	@Column(name = "personalize_type")
	@Enumerated(EnumType.STRING)
	private PersonalizeType personalizeType;

	public int getPersonalizeId() {
		return personalizeId;
	}

	public void setPersonalizeId(int personalizeId) {
		this.personalizeId = personalizeId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public PersonalizeType getPersonalizeType() {
		return personalizeType;
	}

	public void setPersonalizeType(PersonalizeType personalizeType) {
		this.personalizeType = personalizeType;
	}

	@Override
	public String toString() {
		return "Personalize [personalizeId=" + personalizeId + ", image=" + image + ", personalizeType="
				+ personalizeType + "]";
	}

	public Personalize(int personalizeId, String image, PersonalizeType personalizeType) {
		super();
		this.personalizeId = personalizeId;
		this.image = image;
		this.personalizeType = personalizeType;
	}

	public Personalize() {
		super();
	}

}
