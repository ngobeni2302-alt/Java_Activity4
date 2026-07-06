package com.shop.model;

public class Order {
    private String orderId;
    private Item item;
    private String shippingMethod;

    public Order(String orderId, Item item, String shippingMethod){
        this.orderId = orderId;
        this.item = item;
        this.shippingMethod = shippingMethod;
    }

    public String getOrderId() {return this.orderId;}
    public Item getItem() {return this.item;}
    public String getShippingMethod() {return this.shippingMethod;}

}
