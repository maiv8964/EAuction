package com.eauction;

public interface AuctionInterface {
	Auction getAuctionById(int auctionId);
	void placeBid(int id, Auction auction);
}
