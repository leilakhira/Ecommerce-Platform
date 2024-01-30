package com.davi.shop.repositories.product;

import com.davi.shop.dto.controller.PurchaseDTO;
import com.davi.shop.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
