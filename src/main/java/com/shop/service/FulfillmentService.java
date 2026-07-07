package com.shop.service;

import com.shop.model.Order;
import com.shop.model.Shipment;

public class FulfillmentService {
    public Shipment processOrder(Order order){

        double Cost = order.getItem().getPrice();
        return new Shipment(Cost , "Generic Processing");
    }

}
