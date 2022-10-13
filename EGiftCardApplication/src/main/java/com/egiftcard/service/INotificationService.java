package com.egiftcard.service;

import java.util.List;

import com.egiftcard.entity.GiftReceivedDetails;
import com.egiftcard.entity.GiftRedeemDetails;
import com.egiftcard.exception.InvalidReceiveIdException;
import com.egiftcard.exception.NoReceivedDetailsFoundException;
import com.egiftcard.exception.NoRedeemDetailsFoundException;

//Notification Service Interface
public interface INotificationService {

	// Methods
	List<GiftReceivedDetails> getAllGiftRecddetails() throws NoReceivedDetailsFoundException;

	List<GiftRedeemDetails> getAllGiftRedeemdetails() throws NoRedeemDetailsFoundException;

	GiftRedeemDetails sendGiftRedeemdetailsNotification(int gift_redeem_id) throws InvalidReceiveIdException;

	GiftReceivedDetails sendGiftRecdDetailsNotification(int gift_received_id) throws InvalidReceiveIdException;

}
