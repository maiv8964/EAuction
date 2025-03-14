package com.eauction.Shipping;

public class Shipping {
    private int id;
    private int userId;
    private int itemId;
    private String shippingAddress;
    private String trackingNumber;
    private String estimatedDelivery;

    // Getters and Setters
    public int getId() { 
    	return id; }
    
    public void setId(int id) { 
    	this.id = id; }
    
    public int getUserId() { 
    	return userId; }
    
    public void setUserId(int userId) {
    	this.userId = userId; }
    
    public int getItemId() {
    	return itemId; }
    
    public void setItemId(int itemId) {
    	this.itemId = itemId; }
    
    public String getShippingAddress() {
    	return shippingAddress; }
    
    public void setShippingAddress(String shippingAddress) {
    	this.shippingAddress = shippingAddress; }
    
    public String getTrackingNumber() {
    	return trackingNumber; }
    
    public void setTrackingNumber(String trackingNumber) {
    	this.trackingNumber = trackingNumber; }
    
    public String getEstimatedDelivery() {
    	return estimatedDelivery; }
    
    public void setEstimatedDelivery(String estimatedDelivery) {
    	this.estimatedDelivery = estimatedDelivery; }
}
