package com.davi.shop.resources;

import com.davi.shop.entities.Purchase;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.davi.shop.dto.controller.PaymentInfoDTO;
import com.davi.shop.dto.controller.PurchaseDTO;
import com.davi.shop.dto.controller.PurchaseResponseDTO;
import com.stripe.exception.StripeException;

import jakarta.validation.Valid;

@Validated
@RequestMapping(value = "/api/v1/checkout")
public interface CheckoutAPI {

    @PostMapping("/purchases")
    ResponseEntity<PurchaseResponseDTO> place(@RequestBody PurchaseDTO purchase);
    @GetMapping("/purchase")
    String placeOrder();
    @PostMapping("/payment-intent")
    ResponseEntity<String> createPaymentIntent(@Valid @RequestBody PaymentInfoDTO paymentInfo) throws StripeException;
    @PostMapping("/savepurchase")
    //@Produces(MediaType.APPLICATION_JSON)
    ResponseEntity<String> savePurchase(Model model, Purchase purchase);
    @GetMapping("/allpurchase")
    String findall(Model model);

}
