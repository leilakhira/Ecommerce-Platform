package com.davi.shop.services.impl;
import com.davi.shop.dto.controller.ProductDTO;
import com.davi.shop.dto.product.RegisterProductDTO;
import com.davi.shop.entities.Purchase;
import com.davi.shop.repositories.product.PurchaseRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class purchaseApi {
    private final PurchaseRepository purchaseRepository;
    @Autowired
    public purchaseApi(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    @GetMapping("/purchasesPage")
    Page<Purchase> findallPage(Pageable pageable){
        return purchaseRepository.findAll(pageable);
    }
    @GetMapping("/purchasesList")
    List<Purchase> findall(){
        return purchaseRepository.findAll();
    }
    @GetMapping("/purchase/{id}")
    Optional<Purchase> findById(@PathVariable Long id){
        return  purchaseRepository.findById(id);
    }
    @PostMapping("/save")
    public void savePurchase(@RequestBody @Valid Purchase purchase) {
        purchaseRepository.save(purchase);
    }
}

