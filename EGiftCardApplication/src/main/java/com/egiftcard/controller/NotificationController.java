package com.egiftcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.GiftReceivedDetails;
import com.egiftcard.entity.GiftRedeemDetails;
import com.egiftcard.exception.InvalidReceiveIdException;
import com.egiftcard.exception.NoReceivedDetailsFoundException;
import com.egiftcard.exception.NoRedeemDetailsFoundException;
import com.egiftcard.service.INotificationService;

@RestController
@RequestMapping("/api/Notification")
public class NotificationController {

	@Autowired
	private INotificationService Notification;

	// http://localhost:8080/EGiftCardApp/api/Notification/show
	@GetMapping(value = "/show")
	public List<GiftReceivedDetails> getAllGiftRecddetails() throws NoReceivedDetailsFoundException {
		return Notification.getAllGiftRecddetails();
	}

	// http://localhost:8080/EGiftCardApp/api/Notification/view
	@GetMapping(value = "/view")
	public List<GiftRedeemDetails> getAllGiftRedeemdetails() throws NoRedeemDetailsFoundException {

		return Notification.getAllGiftRedeemdetails();

	}

	// http://localhost:8080/EGiftCardApp/api/Notification/GiftReceivedId/
	@GetMapping("/GiftReceivedId/{gift_redeem_id}")
	public ResponseEntity<GiftRedeemDetails> sendGiftRedeemdetailsNotification(@PathVariable int gift_redeem_id)
			throws InvalidReceiveIdException {
		GiftRedeemDetails giftRedeemId = Notification.sendGiftRedeemdetailsNotification(gift_redeem_id);

		return new ResponseEntity<GiftRedeemDetails>(giftRedeemId, HttpStatus.OK);
	}

	// http://localhost:8080/EGiftCardApp/api/Notification/Gifts/
	@GetMapping("/Gifts/{giftReceivedId}")
	public ResponseEntity<GiftReceivedDetails> sendGiftRecdDetailsNotification(@PathVariable int giftReceivedId)
			throws InvalidReceiveIdException {
		GiftReceivedDetails giftId = Notification.sendGiftRecdDetailsNotification(giftReceivedId);

		return new ResponseEntity<GiftReceivedDetails>(giftId, HttpStatus.OK);
	}

}
