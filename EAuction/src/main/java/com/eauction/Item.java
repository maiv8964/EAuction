package com.eauction;

public class Item {

	private int id;
	private String name;
	private String condition;
	private float currentPrice;
	private String description;
	private int highestBidderId;
	private String auctionType;
	private String remainingTime;
	private float shippingPrice;
	private String auctionStatus;
	private Integer sellerId;

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

	public void setCurrentPrice(float price) {
		this.currentPrice = price;
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

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(String remainingTime) {
		this.remainingTime = remainingTime;
	}

	public int getHighestBidderId() {
		return highestBidderId;
	}

	public void setHighestBidderId(int highestBidderId) {
		this.highestBidderId = highestBidderId;
	}

	public float getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(float shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public String getAuctionStatus() {
		return auctionStatus;
	}

	public void setAuctionStatus(String auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
}
