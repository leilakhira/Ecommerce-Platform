package com.davi.shop.resources.impl;

import com.davi.shop.entities.Purchase;
import com.davi.shop.repositories.product.PurchaseRepository;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.flywaydb.core.internal.resource.classpath.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.davi.shop.dto.controller.PaymentInfoDTO;
import com.davi.shop.dto.controller.PurchaseDTO;
import com.davi.shop.dto.controller.PurchaseResponseDTO;
import com.davi.shop.resources.CheckoutAPI;
import com.davi.shop.services.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import java.util.List;

@Controller
public class CheckoutResource implements CheckoutAPI{

    @Autowired
    private CheckoutService service;
	@Autowired
	private PurchaseRepository purchaseRepository;
    public ResponseEntity<PurchaseResponseDTO> place(
	    PurchaseDTO purchase) {
	PurchaseResponseDTO purchaseResponse = service
		.place(purchase);
	return ResponseEntity.ok().body(purchaseResponse);
    }
	public String placeOrder() {
		return "index";
	}
	public String findall(Model model){
		List<Purchase> purchases =purchaseRepository.findAll();
		model.addAttribute("purchases",purchases);
		return "admin";
	}
	public ResponseEntity<String> savePurchase(Model model , Purchase purchase){
		purchaseRepository.save(purchase);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:4200/");
		return new ResponseEntity<String>(headers, HttpStatus.FOUND);
	}
    public ResponseEntity<String> createPaymentIntent(
	    PaymentInfoDTO paymentInfo) throws StripeException {
	PaymentIntent paymentIntent = service
		.createPaymentIntent(paymentInfo);
	String paymentStr = paymentIntent.toJson();
	return new ResponseEntity<>(paymentStr, HttpStatus.OK);
    }
}
