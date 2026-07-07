package com.shop.service;

import com.shop.model.Order;
import com.shop.model.Shipment;

public class StandardFulfillment extends FulfillmentService {

    @Override
    public Shipment processOrder(Order order){
        double newCost = order.getItem().getPrice() + 5.00;
        return new Shipment(newCost, "Shipped via "+ order.getShippingMethod());
    }

}
