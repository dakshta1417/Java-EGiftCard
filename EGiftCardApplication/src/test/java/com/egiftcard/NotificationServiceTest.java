package com.egiftcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.egiftcard.dao.INotificationServiceReceivedRepository;
import com.egiftcard.dao.INotificationServiceRedeemRepository;
import com.egiftcard.entity.GiftRedeemDetails;
import com.egiftcard.entity.UserGiftDetails;
import com.egiftcard.exception.InvalidReceiveIdException;
import com.egiftcard.exception.NoRedeemDetailsFoundException;
import com.egiftcard.service.NotificationServiceImpl;

//To start up an application context to be used in a test
@SpringBootTest
public class NotificationServiceTest {

	// enables to inject the object dependency implicitly
	@Autowired
	private NotificationServiceImpl NotificationService;

	// To add mock objects to the Spring application context.
	@MockBean
	private INotificationServiceReceivedRepository NotificationServiceDao;

	// To add mock objects to the Spring application context.
	@MockBean
	private INotificationServiceRedeemRepository NotificationServiceRedeemDao;

	// @Test annotation used to inform method to run as a test case
	@Test
	public void testsendGift_redeem_detailsNotification() throws InvalidReceiveIdException {
		Optional<GiftRedeemDetails> giftRedeem = Optional.of(new GiftRedeemDetails());
		GiftRedeemDetails giftRedeem1 = giftRedeem.get();
		when(NotificationServiceRedeemDao.findById(5)).thenReturn(giftRedeem);
		assertEquals(giftRedeem1, NotificationService.sendGiftRedeemdetailsNotification(5));
	}

	@Test
	void testGetAllGiftRedeemDeatils() throws NoRedeemDetailsFoundException {
		GiftRedeemDetails giftRedeemObj = new GiftRedeemDetails(12, true, null, 500, 3000, new UserGiftDetails());
		List<GiftRedeemDetails> list = new ArrayList<>();
		list.add(giftRedeemObj);
		when(NotificationServiceRedeemDao.findAll()).thenReturn(list);
		assertEquals(list, NotificationService.getAllGiftRedeemdetails());
	}

	@Test
	public void testSendGiftReceiveDetailsShouldThrowInvalidReceiveIdException() {

		assertThrows(InvalidReceiveIdException.class, () -> {
			NotificationService.sendGiftRecdDetailsNotification(99);
		});

	}

	@Test
	public void testSendGiftRedeemDetailsShouldThrowInvalidReceiveIdException() {

		assertThrows(InvalidReceiveIdException.class, () -> {
			NotificationService.sendGiftRecdDetailsNotification(78);
		});

	}

}
