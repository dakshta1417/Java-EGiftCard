package com.egiftcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.egiftcard.dao.IPaymentDetailsDAO;
import com.egiftcard.entity.PaymentDetails;
import com.egiftcard.exception.DuplicatePaymentIdException;
import com.egiftcard.exception.NoSuchPaymentIdException;
import com.egiftcard.service.PaymentServiceImplementation;

@SpringBootTest // To start up an application context to be used in a test
class PaymentDetailsTests {

	// enables to inject the object dependency implicitly
	@Autowired
	private PaymentServiceImplementation paymentService;

	// To add mock objects to the Spring application context.
	@MockBean
	private IPaymentDetailsDAO payRepo;

	// @Test annotation used to inform method to run as a test case

	@Test
	void savePaymentDetailsTest() throws DuplicatePaymentIdException {
		PaymentDetails payment = new PaymentDetails(2, new Date(2022 - 9 - 19), "Gracilda", 5000f, "098273645463",
				new Date(2022 - 9 - 19), "123", null);
		when(payRepo.save(payment)).thenReturn(payment);
		assertEquals(payment, paymentService.registerPaymentDetails(payment));
	}

	@Test
	void deletePaymentDetailsByIdTest() throws NoSuchPaymentIdException {
		payRepo.deleteById(3);
		verify(payRepo, times(1)).deleteById(3);
	}

	@Test
	void getPaymentDetailsByIdTest() throws NoSuchPaymentIdException {
		Optional<PaymentDetails> payment = Optional.of(new PaymentDetails());
		PaymentDetails payment1 = payment.get();
		when(payRepo.findById(2)).thenReturn(payment);
		assertEquals(payment1, paymentService.getPaymentDetailsById(2));
	}

	@Test
	void testGetPaymentDetailsByIdShouldThrowNoSuchPaymentIdException() {
		assertThrows(NoSuchPaymentIdException.class, () -> {
			paymentService.getPaymentDetailsById(5);
		});

	}

}
