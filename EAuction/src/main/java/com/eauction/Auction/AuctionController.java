package com.eauction.Auction;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.core.Response;

@Path("/auction")
public class AuctionController {

    private final AuctionInterface auctionDAO = new AuctionDAO();

    @GET    
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Auction getAuctionItem(@PathParam("id") int id) {
        return auctionDAO.getAuctionById(id);
    }
    
    @GET    
    @Path("/{id}/verify-pay")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Boolean> payNowPage(@PathParam("id") int auction_id, @QueryParam("userId") int user_id) {
        Auction auction = auctionDAO.getAuctionById(auction_id);
        Map<String, Boolean> result = new HashMap<>();

        if (!auction.getAuctionStatus().equals("active")) {
            if (auction.getHighestBidderId() == user_id) {
           	 	result.put("result", true);
                return result;
            } else {
           	 	result.put("result", false);
                return result;
            }
        } else {        	
        	result.put("result", false);
            return result;
        }
    }
    
     @PUT
     @Path("/{id}")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public Map<String, Boolean> update(@PathParam("id") int id, Auction auction) {
    	 Map<String, Boolean> result = new HashMap<>();
    	 result.put("result", auctionDAO.placeBid(id, auction));
         return result;
     }     
}