package com.shop;

import com.shop.model.Item;
import com.shop.model.Order;
import com.shop.model.Shipment;
import com.shop.service.FulfillmentService;
import com.shop.service.StandardFulfillment;
import com.shop.service.ExpressFulfillment;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize a gaming controller item
        Item controllers = new Item("Controllers", 15.00);

        // 2. Setup an order using The Courier Guy as the shipping carrier method
        Order order1 = new Order("ORD-123", controllers, "Courier Guy");
        Order order2 = new Order("ORD-456", controllers, "Courier Guy");

        System.out.println("====== Order Processing Simulation ======");
        System.out.println("Item: " + controllers.getName() + " (Base Price: $" + controllers.getPrice() + ")");
        System.out.println("Carrier: " + order1.getShippingMethod());
        System.out.println("=========================================\n");

        // 3. Process via Standard Fulfillment (Adds $5.00)
        FulfillmentService standardEngine = new StandardFulfillment();
        Shipment standardShipment = standardEngine.processOrder(order1);

        System.out.println("--- Processing Standard Delivery ---");
        System.out.println("Tracking Status: " + standardShipment.getTrackingDetails());
        System.out.println("Total Amount Charged: $" + standardShipment.getTotalCost());
        System.out.println();

        // 4. Process via Express Fulfillment (Adds $25.00)
        FulfillmentService expressEngine = new ExpressFulfillment();
        Shipment expressShipment = expressEngine.processOrder(order2);

        System.out.println("--- Processing Express Delivery ---");
        System.out.println("Tracking Status: " + expressShipment.getTrackingDetails());
        System.out.println("Total Amount Charged: $" + expressShipment.getTotalCost());
        System.out.println("=========================================");
    }
}