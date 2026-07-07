package com.shop.service;

import com.shop.model.Order;
import com.shop.model.Shipment;

public class ExpressFulfillment extends FulfillmentService {

    @Override
    public Shipment processOrder(Order order) {
        double totalCost = order.getItem().getPrice() + 25.00;

        return new Shipment(totalCost, "URGENT: Shipped via " + order.getShippingMethod());
    }
}
