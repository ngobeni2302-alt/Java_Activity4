package com.shop.model;

public class Shipment {
    private double totalCost;
    private String trackingDetails;

    public Shipment(double totalCost, String trackingDetails){
        this.totalCost = totalCost;
        this.trackingDetails = trackingDetails;
    }

    public double getTotalCost() {return this.totalCost;}
    public String getTrackingDetails() {return this.trackingDetails;}

}
