package com.eauction;

public class Auction {
    private int itemId;
    private String name;
    private String auctionType;
    private String auctionStatus;
    private Float currentPrice;
    private Float shippingPrice;
    private String description;
    private int highestBidderId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int id) {
        this.itemId = id;
    }
        
    public int getHighestBidderId() {
        return highestBidderId;
    }
    
    public void setHighestBidder(int highest_bidder) {
        this.highestBidderId = highest_bidder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Float getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(float price) {
        this.shippingPrice = price;
    }
    
    public String getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(String auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public Float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float price) {
        this.currentPrice = price;
    }

    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auction_type) {
        this.auctionType = auction_type;
    }

}
