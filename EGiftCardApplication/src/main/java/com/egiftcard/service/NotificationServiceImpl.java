package com.egiftcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egiftcard.dao.INotificationServiceReceivedRepository;
import com.egiftcard.dao.INotificationServiceRedeemRepository;

import com.egiftcard.entity.GiftReceivedDetails;
import com.egiftcard.entity.GiftRedeemDetails;
import com.egiftcard.exception.InvalidReceiveIdException;
import com.egiftcard.exception.NoReceivedDetailsFoundException;
import com.egiftcard.exception.NoRedeemDetailsFoundException;

@Service
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	private INotificationServiceReceivedRepository GiftReceivedRepo;

	@Override
	public List<GiftReceivedDetails> getAllGiftRecddetails() throws NoReceivedDetailsFoundException {

		if (GiftReceivedRepo.findAll().isEmpty()) {
			throw new NoReceivedDetailsFoundException("No Details Found");
		}
		return GiftReceivedRepo.findAll();
	}

	@Autowired
	private INotificationServiceRedeemRepository GiftRedeemRepo;

	@Override
	public List<GiftRedeemDetails> getAllGiftRedeemdetails() throws NoRedeemDetailsFoundException {

		if (GiftRedeemRepo.findAll().isEmpty()) {
			throw new NoRedeemDetailsFoundException("No Details found");
		}
		return GiftRedeemRepo.findAll();
	}

	@Override
	public GiftRedeemDetails sendGiftRedeemdetailsNotification(int gift_redeem_id) throws InvalidReceiveIdException {

		if (!GiftRedeemRepo.findById(gift_redeem_id).isPresent()) {
			throw new InvalidReceiveIdException("Id is wrong");
		}
		Optional<GiftRedeemDetails> Op = GiftRedeemRepo.findById(gift_redeem_id);
		return Op.get();
	}

	public GiftReceivedDetails sendGiftRecdDetailsNotification(int giftReceivedId) throws InvalidReceiveIdException {

		if (!GiftReceivedRepo.findById(giftReceivedId).isPresent()) {
			throw new InvalidReceiveIdException("Id is Wrong");
		}
		Optional<GiftReceivedDetails> Op = GiftReceivedRepo.findById(giftReceivedId);
		{
			return Op.get();

		}

	}

}
