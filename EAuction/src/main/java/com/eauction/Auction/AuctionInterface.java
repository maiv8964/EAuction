package com.eauction.Auction;

public interface AuctionInterface {
	Auction getAuctionById(int auctionId);
	boolean placeBid(int id, Auction auction);
}
