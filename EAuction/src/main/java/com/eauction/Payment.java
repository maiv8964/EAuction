package com.eauction;

public class Payment {
    private int id;
    private int userId;
    private int itemId;
    private float amountPaid;
    private String paymentMethod;
    private String paymentStatus; // e.g., "Pending", "Completed", "Failed"

    // Credit Card Fields (For Card Payments)
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;

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

    public float getAmountPaid() {
    	return amountPaid; }
    public void setAmountPaid(float amountPaid) { this.amountPaid = amountPaid; }

    public String getPaymentMethod() {
    	return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentStatus() {
    	return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) {
    	this.paymentStatus = paymentStatus; }

    public String getCardNumber() { 
    	return cardNumber; }
    public void setCardNumber(String cardNumber) { 
    	this.cardNumber = cardNumber; }

    public String getCardHolderName() {
    	return cardHolderName; }
    public void setCardHolderName(String cardHolderName) {
    	this.cardHolderName = cardHolderName; }

    public String getExpirationDate() {
    	return expirationDate; }
    public void setExpirationDate(String expirationDate) {
    	this.expirationDate = expirationDate; }

    public String getCvv() {
    	return cvv; }
    public void setCvv(String cvv) {
    	this.cvv = cvv; }
}
