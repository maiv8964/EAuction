package com.eauction;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/receipts")
public class ReceiptController {
    private ReceiptDAO receiptDAO = new ReceiptDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void generateReceipt(Receipt receipt) {
        receiptDAO.createReceipt(receipt);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Receipt getReceipt(@PathParam("id") int id) {
        return receiptDAO.getReceipt(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateReceipt(@PathParam("id") int id, Receipt receipt) {
        receiptDAO.updateReceipt(id, receipt);
    }
}
