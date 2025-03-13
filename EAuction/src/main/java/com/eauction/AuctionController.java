package com.eauction;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import jakarta.ws.rs.core.Response;

@Path("/auction")
public class AuctionController {

    private AuctionDAO auctionDAO = new AuctionDAO();

    @GET    
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Auction getAuctionItem(@PathParam("id") int id) {
        return auctionDAO.getAuctionById(id);
    }
    
    @GET    
    @Path("/{id}/pay")
    @Produces(MediaType.APPLICATION_JSON)
    public Response payNowPage(@PathParam("id") int auction_id, @QueryParam("userId") int user_id) {
        Auction auction = auctionDAO.getAuctionById(auction_id);

        if (!auction.getAuctionStatus().equals("inactive")) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"error\": \"Auction not yet ended.\"}").build();
        }
        if (auction.getHighestBidderId() == user_id) {
            return Response.ok("{\"message\": \"Payment page loaded.\", " +
            				   "\"winnerId\": " + auction.getHighestBidderId() + ", " +
                               "\"auctionId\": " + auction_id + ", " +
                               "\"finalPrice\": " + auction.getCurrentPrice() + "}").build();
        } else {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("{\"error\": \"You are not the auction winner.\"}")
                    .build();
        }
    }
    
     @PUT
     @Path("/{id}")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public void update(@PathParam("id") int id, Auction auction) {
         auctionDAO.update(id, auction);
     }     
}