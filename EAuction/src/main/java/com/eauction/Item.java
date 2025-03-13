package com.eauction;

public class Item {

    private int id;
    private String name;
    private String condition;
    private String auctionType;
    private float currentPrice;
    private String description;
    private String remainingTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType;
    }
    
    public void setRemainingTime(String remainingTime) {
		this.remainingTime = remainingTime;
	}

	public String getRemainingTime() {
		return this.remainingTime;
	}
	

}