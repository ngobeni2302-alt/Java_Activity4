package com.shop;

import com.shop.model.*;
import com.shop.service.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

    @Test
    public void testItemEncapsulation() {
        Item item = new Item("Laptop", -500.0);
        assertEquals(0.0, item.getPrice(), "Price cannot be negative; should fall back to 0.0");
    }

    @Test
    public void testStandardFulfillment() {
        Item item = new Item("Book", 20.0);
        Order order = new Order("ORD-01", item, "Ground");
        FulfillmentService service = new StandardFulfillment();
        
        Shipment shipment = service.processOrder(order);
        
        assertNotNull(shipment, "Shipment object should be generated");
        assertEquals(25.0, shipment.getTotalCost(), "Total cost should be item price + $5.00 standard shipping");
        assertEquals("Shipped via Ground", shipment.getTrackingDetails());
    }

    @Test
    public void testExpressFulfillment() {
        Item item = new Item("Phone", 800.0);
        Order order = new Order("ORD-02", item, "Air");
        FulfillmentService service = new ExpressFulfillment();
        
        Shipment shipment = service.processOrder(order);
        
        assertNotNull(shipment, "Shipment object should be generated");
        assertEquals(825.0, shipment.getTotalCost(), "Total cost should be item price + $25.00 express shipping");
        assertEquals("URGENT: Shipped via Air", shipment.getTrackingDetails());
    }
}
