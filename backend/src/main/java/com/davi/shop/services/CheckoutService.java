package com.davi.shop.services;

import com.davi.shop.dto.controller.PaymentInfoDTO;
import com.davi.shop.dto.controller.PurchaseDTO;
import com.davi.shop.dto.controller.PurchaseResponseDTO;
import com.davi.shop.entities.Purchase;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

public interface CheckoutService {
    PurchaseResponseDTO place(PurchaseDTO purchase);
    public ResponseEntity<String> savePurchase(Model model , Purchase purchase);
    String placeOrder();
    PaymentIntent createPaymentIntent(PaymentInfoDTO paymentInfoDTO) throws StripeException;
    public String findall(Model model);
}
