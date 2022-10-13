package com.egiftcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.egiftcard.dao.IUserGiftDetailsAccountManagementServiceRepository;
import com.egiftcard.entity.GiftCard;
import com.egiftcard.entity.Personalize;
import com.egiftcard.entity.User;
import com.egiftcard.entity.UserGiftDetails;
import com.egiftcard.exception.DuplicateUserGiftIdException;
import com.egiftcard.exception.UserGiftDetailsNotFoundException;
import com.egiftcard.service.UserGiftDetailsAccountManagementServiceImpl;

//To start up an application context to be used in a test
@SpringBootTest
class UserGiftCardApplicationManagementTests {

	// enables to inject the object dependency implicitly
	@Autowired
	private UserGiftDetailsAccountManagementServiceImpl userGiftDetailsService;

	// To add mock objects to the Spring application context.
	@MockBean
	private IUserGiftDetailsAccountManagementServiceRepository repo;

	// @Test annotation used to inform method to run as a test case
	@Test
	void getAllUserGiftDetails() {
		when(repo.findAll()).thenReturn(Stream
				.of(new UserGiftDetails(10, 600, new Date(2022 - 9 - 19), false, "Adamya", 384756, "adam@gmail.com",
						"COD", LocalDate.of(2022, 9, 20), new User(4, null, null, null, null, null, null),
						new GiftCard(10, null, null, null, 0, 0, null), new Personalize(12, null, null)))
				.collect(Collectors.toList()));
		assertEquals(1, userGiftDetailsService.getAllUserGiftDetails().size());
	}

	@Test
	void getUserGiftDetails() throws UserGiftDetailsNotFoundException {
		int userGiftId = 10;
		when(repo.findById(userGiftId)).thenReturn(Stream
				.of(new UserGiftDetails(10, 600, new Date(2022 - 9 - 19), false, "Adamya", 384756, "adam@gmail.com",
						"COD", LocalDate.of(2022, 9, 20), new User(4, null, null, null, null, null, null),
						new GiftCard(10, null, null, null, 0, 0, null), new Personalize(12, null, null)))
				.findAny());
		assertEquals(10, userGiftDetailsService.getUserGiftDetails(userGiftId).getUserGiftId());
	}

	@Test
	void addUserGiftDetails() throws DuplicateUserGiftIdException, UserGiftDetailsNotFoundException {
		UserGiftDetails userGiftDetails = new UserGiftDetails(10, 600, new Date(2022 - 9 - 19), false, "Aditi", 384756,
				"aditi@gmail.com", "COD", LocalDate.of(2022, 9, 20), new User(4, null, null, null, null, null, null),
				new GiftCard(10, null, null, null, 0, 0, null), new Personalize(12, null, null));
		when(repo.save(userGiftDetails)).thenReturn(userGiftDetails);
		assertEquals(userGiftDetails, userGiftDetailsService.addUserGiftDetails(userGiftDetails));
	}

	@Test
	void deleteUserGiftDetailsById() throws UserGiftDetailsNotFoundException {
		@SuppressWarnings("unused")
		UserGiftDetails userGiftDetails = new UserGiftDetails(10, 600, new Date(2022 - 9 - 19), false, "Aditi", 384756,
				"aditi@gmail.com", "COD", LocalDate.of(2022, 9, 20), new User(4, null, null, null, null, null,null),
				new GiftCard(10, null, null, null, 0, 0, null), new Personalize(12, null, null));
		// userGiftDetailsService.deleteUserGiftDetailsById(10);
		// System.out.println(userGiftDetailsService.deleteUserGiftDetailsById(10));
		repo.deleteById(10);
		verify(repo, times(1)).deleteById(10);
	}

	@Test
	void testGetUserGiftDetailsByIdShouldThrowUserGiftDetailsNotFoundException()
			throws UserGiftDetailsNotFoundException {
		assertThrows(UserGiftDetailsNotFoundException.class, () -> {
			userGiftDetailsService.getUserGiftDetails(10);
		});
	}

}
