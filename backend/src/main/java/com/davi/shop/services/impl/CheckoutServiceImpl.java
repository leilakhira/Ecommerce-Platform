package com.davi.shop.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.davi.shop.entities.Purchase;
import com.davi.shop.repositories.product.PurchaseRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davi.shop.dto.controller.PaymentInfoDTO;
import com.davi.shop.dto.controller.PurchaseDTO;
import com.davi.shop.dto.controller.PurchaseResponseDTO;
import com.davi.shop.entities.order.Order;
import com.davi.shop.entities.order.OrderStatus;
import com.davi.shop.entities.user.User;
import com.davi.shop.repositories.UserRepository;
import com.davi.shop.services.CheckoutService;
import com.davi.shop.utils.IDUtils;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Controller
public class CheckoutServiceImpl implements CheckoutService{

    private final UserRepository userRepository;
	private PurchaseRepository purchaseRepository;

    public CheckoutServiceImpl(UserRepository userRepository,
	    @Value("${stripe.key.secret}") String secretKey) {
	this.userRepository = userRepository;
	Stripe.apiKey = secretKey;
    }

    @Override
    @Transactional
    public PurchaseResponseDTO place(PurchaseDTO purchase){
	 //retrieve the order
	Order order = purchase.getOrder();
	//generate tracking nuber
	String orderTrackingNumber = generateOrderTrackingNumber();
	order.setOrderTrackingNumber(orderTrackingNumber);

	// populate order with billingAddress and shippingAddress
	order.setBillingAddress(purchase.getBillingAddress());
	order.setShippingAddress(purchase.getShippingAddress());
	
	// order status for product
	order.setStatus(OrderStatus.PENDING);

	// populate customer with order
	User user = purchase.getUser();

	String theEmail = user.getEmail();

	Optional<User> customerFromDB = userRepository
		.findByEmail(theEmail);

	if (customerFromDB.isPresent()) {
	    user = customerFromDB.get();
	}

	user.add(order);

	// save to the database
	userRepository.save(user);

	// return a response
	return new PurchaseResponseDTO(orderTrackingNumber);
    }
	@Override
	public  String placeOrder(){
		return "index";
	}
	public ResponseEntity<String> savePurchase(Model model , Purchase purchase){
		purchaseRepository.save(purchase);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:4200/");
		return new ResponseEntity<String>(headers, HttpStatus.FOUND);
	}
	@RequestMapping("/redirected")
	public String redirectToAngularApp() {
		return "redirect:http://localhost:4200/";
	}
	public String findall(Model model){
		List<Purchase> purchases =purchaseRepository.findAll();
		model.addAttribute("purchases",purchases);
		return "admin";
	}
    @Override
    public PaymentIntent createPaymentIntent(
	    PaymentInfoDTO paymentInfoDTO) throws StripeException {
	List<String> paymentMethodTypes = new ArrayList<>();
	paymentMethodTypes.add("card");

	Map<String, Object> params = new HashMap<>();
	params.put("amount", paymentInfoDTO.getAmount());
	params.put("currency", paymentInfoDTO.getCurrency());
	params.put("payment_method_types", paymentMethodTypes);
	params.put("description", "Shop Purchase");
	params.put("receipt_email", paymentInfoDTO.getReceiptEmail());
	return PaymentIntent.create(params);
    }

    private String generateOrderTrackingNumber() {
	// generate a random UUID number
	return IDUtils.GetIDValue();
    }
}
