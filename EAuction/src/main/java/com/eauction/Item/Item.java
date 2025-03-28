package com.eauction.Item;
import java.time.Duration;
import java.time.LocalDateTime;

public class Item {

	private int id;
	private String name;
	private String condition;
	private float currentPrice;
	private String description;
	private int highestBidderId;
	private String auctionType;
	private String startTime;
	private float shippingPrice;
	private String auctionStatus;
	private Integer sellerId;
	private String finishTime;

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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
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
	
	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	
	public String calculateRemainingTime() {
		String output = "";
		
		LocalDateTime end = LocalDateTime.parse(this.finishTime);
		
		LocalDateTime now = LocalDateTime.now();
		
		Duration diff = Duration.between(now, end);
		
		output = diff.toString();
		
		return output;
	}
	
}
