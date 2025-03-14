package com.eauction.Receipt;

public class Receipt {
    private int id;
    private int userId;
    private int paymentId;
    private String dateIssued;
    private float totalAmount;

    // Getters and Setters
    public int getId() { 
    	return id; }
    
    public void setId(int id) { 
    	this.id = id; }
    
    public int getUserId() { 
    	return userId; }
    
    public void setUserId(int userId) { 
    	this.userId = userId; }
    
    public int getPaymentId() {
    	return paymentId; }
    
    public void setPaymentId(int paymentId) {
    	this.paymentId = paymentId; }
    
    public String getDateIssued() {
    	return dateIssued; }
    
    public void setDateIssued(String dateIssued) {
    	this.dateIssued = dateIssued; }
    
    public float getTotalAmount() {
    	return totalAmount; }
    
    public void setTotalAmount(float totalAmount) {
    	this.totalAmount = totalAmount; }
}
