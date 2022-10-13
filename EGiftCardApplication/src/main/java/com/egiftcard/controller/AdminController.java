package com.egiftcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.Admin;
import com.egiftcard.entity.GiftCard;
import com.egiftcard.entity.GiftReceivedDetails;
import com.egiftcard.entity.GiftRedeemDetails;
import com.egiftcard.entity.PaymentDetails;
import com.egiftcard.entity.User;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.exception.NoReceivedDetailsFoundException;
import com.egiftcard.exception.NoRedeemDetailsFoundException;
import com.egiftcard.service.IAdminService;
import com.egiftcard.service.IGiftCardManagementService;
import com.egiftcard.service.INotificationService;
import com.egiftcard.service.IPaymentService;
import com.egiftcard.service.IUserManagementService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	@GetMapping(value="/email")
	public ResponseEntity<Admin> getAdminByEmail(String email) {
		return new ResponseEntity<Admin> (adminService.getAdminByEmail(email),HttpStatus.FOUND);
	}

	@GetMapping
	public ResponseEntity<List<Admin>> getAllAdmin() {
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmin(),HttpStatus.FOUND);
	}

	@PostMapping
	public Admin registerAdmin(Admin admin) {
		return adminService.registerAdmin(admin);
	}

	@PutMapping
	public Admin updateAdmin(Admin admin, String email) {
		return adminService.updateAdmin(admin, email);
	}

	@DeleteMapping
	public Admin deleteAdmin(String email) {
		return adminService.deleteAdmin(email);
	}

	@PutMapping(value="/forgotPassword")
	public Admin adminChangePassword(Admin admin, String email) {
		return adminService.adminChangePassword(admin, email);
	}
	
	//http://localhost:8080/EGiftCardApp/admin/loginAdmin/
		@GetMapping(value = "/loginAdmin/{email}/{password}")
		public ResponseEntity<Admin> loginAdmin(@PathVariable String email, @PathVariable String password) {

			return new ResponseEntity<Admin>(adminService.loginAdmin(email, password),HttpStatus.OK);

		}


		@GetMapping(value = "/logoutAdmin/{email}/{password}")
		public ResponseEntity<Admin> logoutAdmin(@PathVariable String email, @PathVariable String password) {

			return new ResponseEntity<Admin>(adminService.logoutAdmin(email,password),HttpStatus.OK);

		}
	
	
	//User Management by Admin 
	@Autowired
	private IUserManagementService userServiceCtrl;

	// http://localhost:8080/EGiftCardApp/admin
	@GetMapping(value="/allUser")
	public ResponseEntity<List<User>> getAllUsers() throws NoDataException {
		List<User> user = userServiceCtrl.getAllUsers();

		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
	
	
	
	//Gift card management by admin
	@Autowired // enables to inject the object dependency implicitly
	private IGiftCardManagementService giftCardService;

	// http://localhost:8080/EGiftCardApp/admin/GiftCard
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value="/allGiftCard")
	public ResponseEntity<List<GiftCard>> getAllGiftCard() {
		List<GiftCard> giftCardList = giftCardService.getAllGiftCards();
		if (giftCardList.isEmpty()) {
			return new ResponseEntity("Sorry!GiftCards Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<GiftCard>>(giftCardList, HttpStatus.OK);
	}
	
	
	//payment management by admin
	@Autowired
	private IPaymentService paymentService;

	// http://localhost:8080/EGiftCardApp/admin/paymentDetails
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value="/allPayment")
	public ResponseEntity<List<PaymentDetails>> getAllPaymentDetails() {
		List<PaymentDetails> paymentDetails = paymentService.getAllPaymentDetails();
		if (paymentDetails.isEmpty()) {
			return new ResponseEntity("No Payments made!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(paymentDetails, HttpStatus.OK);
	}

	//notification management by admin
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

}
