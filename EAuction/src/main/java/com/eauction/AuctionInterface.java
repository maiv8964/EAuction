package com.eauction;

public interface AuctionInterface {
	Auction getAuctionById(int auctionId);
	void update(int id, Auction auction);
}
