package com.eauction.Auction;

import java.sql.*;

import com.eauction.DatabaseConnection;


public class AuctionDAO implements AuctionInterface{
	
    @Override
    public Auction getAuctionById(int auctionId) {
        String sql = "SELECT id, name, currentPrice, description, highestBidderId, shippingPrice, auctionType, auctionStatus FROM items WHERE id = ?";
        Auction auction = null;
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, auctionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if a result was returned
                if (rs.next()) {
                    auction = new Auction();
                    auction.setItemId(rs.getInt("id"));
                    auction.setName(rs.getString("name"));
                    auction.setCurrentPrice(rs.getFloat("currentPrice"));
                    auction.setDescription(rs.getString("description"));
                    auction.setAuctionType(rs.getString("auctionType"));
                    auction.setAuctionStatus(rs.getString("auctionStatus"));
                    auction.setHighestBidder(rs.getInt("highestBidderId"));
                    auction.setShippingPrice(rs.getFloat("shippingPrice"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return auction;
    }
    
    @Override
	public void placeBid(int id, Auction auction) {
	        String selectSql = "SELECT currentPrice, auctionStatus, auctionType FROM items WHERE id = ?";
	        String updateSql = "UPDATE items SET currentPrice = ?, highestBidderId = ?, auctionStatus = ? WHERE id = ?";
	
	        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(selectSql)) {
	            
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	
	            if (rs.next()) {
	                float currentPrice = rs.getFloat("currentPrice");
	                String auctionStatus = rs.getString("auctionStatus");
	                String auctionType = rs.getString("auctionType");
	                
	                if ((auction.getCurrentPrice() instanceof Float) && auction.getCurrentPrice() >= 0) {
	 	               if (auctionType.equals("forward")) { //forward auction bidding       	   
		            	   if (auction.getCurrentPrice() > currentPrice && auctionStatus.equals("active")) {
		            		   try (PreparedStatement pstmt2 = conn.prepareStatement(updateSql)) {
		            			   pstmt2.setFloat(1, auction.getCurrentPrice());
		            			   pstmt2.setInt(2, auction.getHighestBidderId());
		            			   pstmt2.setString(3, auctionStatus);
		            			   pstmt2.setInt(4, id);
		            			   pstmt2.executeUpdate();
		            			   System.out.println("Auction price has been set");
		            		   }
		            	   }
		            	   else {
		            		   System.out.println("Bid must be higher than current price!");
		            	   }
		               }
		               else if (auctionType.equals("dutch")){ //dutch auction bidding
		             	   if (auction.getCurrentPrice() > currentPrice && auctionStatus.equals("active")) {
		            		   try (PreparedStatement pstmt2 = conn.prepareStatement(updateSql)) {
		            			   pstmt2.setFloat(1, auction.getCurrentPrice());
		            			   pstmt2.setInt(2, auction.getHighestBidderId());
		            			   pstmt2.setString(3, "inactive");
		            			   pstmt2.setInt(4, id);
		            			   pstmt2.executeUpdate();
		            			   System.out.println("Bidder wins and auction will be closed");
		            		   }
		            	   }
		            	   else {
		            		   System.out.println("Bid must be higher than current price!");
		            	   }
		            	   
		               }
	                }
	                else {
	                	System.out.println("ERROR: Issue with input amount");
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
}