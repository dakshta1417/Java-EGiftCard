package com.egiftcard.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
/*
 * @ControllerAdvice is a specialization of the @Component annotation which
 * allows to handle exceptions across the whole application in one global
 * handling component. It can be viewed as an interceptor of exceptions thrown
 * by methods annotated with @RequestMapping and similar.
 */

public class GlobalExceptionHandler {
//GiftCard

	// The @ExceptionHandler is an annotation used to handle the specific exceptions
	// and sending the custom responses to the client.
	@ExceptionHandler(DuplicateGiftCardIdException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateIDException(DuplicateGiftCardIdException exception) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(exception.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<ExceptionResponse>(response,
				HttpStatus.CONFLICT);
		return responseEntyity;
	}

	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidIdException(InvalidIdException exception1) {
		ExceptionResponse response1 = new ExceptionResponse();
		response1.setErrorCode("NOT_ACCEPTABLE");
		response1.setErrorMessage(exception1.getMessage());
		response1.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<ExceptionResponse>(response1,
				HttpStatus.NOT_ACCEPTABLE);
		return responseEntyity;
	}

	@ExceptionHandler(GiftCardNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleGiftCardNotFoundException(GiftCardNotFoundException exception2) {
		ExceptionResponse response2 = new ExceptionResponse();
		response2.setErrorCode("NOT_FOUND");
		response2.setErrorMessage(exception2.getMessage());
		response2.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<ExceptionResponse>(response2,
				HttpStatus.NOT_FOUND);
		return responseEntyity;
	}

//UserManagement	   
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<ExceptionResponse> handleNoSuchUserException(NoSuchUserException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("CONFLICT");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);

	}

	@ExceptionHandler(InvalidUserIdException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidUserIdException(InvalidUserIdException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("IM_USED");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.IM_USED);
	}

	@ExceptionHandler(NoDataException.class)
	public ResponseEntity<ExceptionResponse> handleNoDataException(NoDataException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("GONE");
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.GONE);
	}

//PaymentDetails		
	@ExceptionHandler(NoSuchPaymentIdException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateIDException(NoSuchPaymentIdException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return responseEntyity;
	}

	@ExceptionHandler(DuplicatePaymentIdException.class)
	public ResponseEntity<ExceptionResponse> handleDuplicateIDException(DuplicatePaymentIdException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<>(response, HttpStatus.CONFLICT);
		return responseEntyity;
	}

	@ExceptionHandler(NoPaymentDetailsException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidDataException(NoPaymentDetailsException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return responseEntyity;
	}

//UserGiftDetailsAccountManagement		
	@ExceptionHandler(DuplicateUserGiftIdException.class)
	public ResponseEntity<ExceptionResponse> duplicateIdExceptionHandler(DuplicateUserGiftIdException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("CONFLICT");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserGiftDetailsNotFoundException.class)
	public ResponseEntity<ExceptionResponse> userGiftDetailNotFoundHandler(UserGiftDetailsNotFoundException e) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("NOT_FOUND");
		response.setErrorMessage(e.getMessage());
		response.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

//Notification
	@ExceptionHandler(NoReceivedDetailsFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoReceivedDetailsFoundException(NoReceivedDetailsFoundException e) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("CONFLICT");
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(response,
				HttpStatus.CONFLICT);
		return responseEntity;

	}

	@ExceptionHandler(NoRedeemDetailsFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoRedeemDetailsException(NoRedeemDetailsFoundException e) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("CONFLICT");
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(response,
				HttpStatus.CONFLICT);
		return responseEntity;

	}

	@ExceptionHandler(InvalidReceiveIdException.class)
	public ResponseEntity<ExceptionResponse> handleInvalidReceiveIdException(InvalidReceiveIdException e) {

		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMessage(e.getMessage());
		response.setErrorCode("CONFLICT");
		response.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(response,
				HttpStatus.CONFLICT);
		return responseEntity;

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException exception3) {
		ExceptionResponse response2 = new ExceptionResponse();

		Map<String, String> errors = new HashMap<>();
		exception3.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		String errormessage = null;
		for (String key : errors.keySet()) {
			errormessage = errors.get(key);
		}
		response2.setErrorCode("UNSUPPORTED_MEDIA_TYPE");
		response2.setErrorMessage(errormessage);
		response2.setTimestamp(LocalDateTime.now());
		ResponseEntity<ExceptionResponse> responseEntyity = new ResponseEntity<ExceptionResponse>(response2,
				HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		return responseEntyity;
	}

}
