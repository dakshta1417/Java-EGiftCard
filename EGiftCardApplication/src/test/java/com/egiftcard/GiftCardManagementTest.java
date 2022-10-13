package com.egiftcard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.MethodArgumentNotValidException;
import com.egiftcard.dao.IGiftCardManagementRepository;
import com.egiftcard.entity.GiftCard;
import com.egiftcard.exception.DuplicateGiftCardIdException;
import com.egiftcard.exception.GiftCardNotFoundException;
import com.egiftcard.exception.InvalidIdException;
import com.egiftcard.service.IGiftCardManagementService;

//To start up an application context to be used in a test
@SpringBootTest
public class GiftCardManagementTest {

	// enables to inject the object dependency implicitly
	@Autowired
	private IGiftCardManagementService giftCardService1;

	// To add mock objects to the Spring application context.
	@MockBean
	private IGiftCardManagementRepository giftCardRepository;

	// @Test annotation used to inform method to run as a test case
	@Test
	void getAllGiftCardsTest() {
		GiftCard giftCardObj = new GiftCard(1, "Experience the joy of gifting with Myntra!", "Myntra",
				"Myntra Gift Card", 1000, 100,
				"This eGift Card will be activated within 48 hours from the time of purchase..Terms & Conditions of retail partners are applicable.");
		List<GiftCard> listGift = new ArrayList<>();
		listGift.add(giftCardObj);
		when(giftCardRepository.findAll()).thenReturn(listGift);
		assertEquals(1, giftCardService1.getAllGiftCards().size());
	}

	@Test
	void registerGiftCardTest() throws DuplicateGiftCardIdException, MethodArgumentNotValidException {
		GiftCard giftCardObj = new GiftCard(1, "Experience the joy of gifting with Myntra!", "Myntra",
				"Myntra Gift Card", 1000, 100,
				"This eGift Card will be activated within 48 hours from the time of purchase..Terms & Conditions of retail partners are applicable.");
		// GiftCard gift1=new GiftCard(1,"Experience the joy of gifting with
		// Myntra!","Myntra","Myntra Gift Card",1000,100,"This eGift Card will be
		// activated within 48 hours from the time of purchase..Terms & Conditions of
		// retail partners are applicable.");
		when(giftCardRepository.saveAndFlush(giftCardObj)).thenReturn(giftCardObj);
		assertEquals(giftCardObj, giftCardService1.registerGiftCard(giftCardObj));
	}

	@Test
	void findByIdGiftCardTest() throws GiftCardNotFoundException, InvalidIdException {
		Optional<GiftCard> giftCardObj = Optional.of(new GiftCard(1, "Experience the joy of gifting with Myntra!",
				"Myntra", "Myntra Gift Card", 1000, 100,
				"This eGift Card will be activated within 48 hours from the time of purchase..Terms & Conditions of retail partners are applicable."));
		GiftCard giftCardObj1 = giftCardObj.get();
		when(giftCardRepository.findById(23)).thenReturn(giftCardObj);
		assertEquals(giftCardObj1, giftCardService1.getGiftCardById(23));
	}

	@Test
	void deleteGiftCard() throws InvalidIdException {
		giftCardRepository.deleteById(23);
		verify(giftCardRepository, times(1)).deleteById(23);
	}

	@Test
	void testFindByIdShouldThrowGiftCardNotFoundException() {
		assertThrows(GiftCardNotFoundException.class, () -> {
			giftCardService1.getGiftCardById(23);
		});
	}

}
