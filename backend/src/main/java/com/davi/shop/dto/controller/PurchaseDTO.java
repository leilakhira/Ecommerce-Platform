package com.davi.shop.dto.controller;

import java.util.Set;

import com.davi.shop.Enum.Sex;
import com.davi.shop.entities.location.Address;
import com.davi.shop.entities.order.Order;
import com.davi.shop.entities.order.OrderItem;
import com.davi.shop.entities.user.User;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public class PurchaseDTO {
    @NotNull(message = "'user' should not be empty.")
    private User user;
    @NotNull(message = "'shippingAddress' should not be empty.")
    private Address shippingAddress;

    @NotNull(message = "'billingAddress' should not be empty.")
    private Address billingAddress;

    @NotNull(message = "'order' should not be empty.")
    private Order order;
    @NotNull(message = "'orderItems' should not be empty.")
    private Set<OrderItem> orderItems;

    public PurchaseDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }


}
