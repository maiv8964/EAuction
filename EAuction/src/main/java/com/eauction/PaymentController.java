package com.eauction;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/payments")
public class PaymentController {
    private PaymentDAO paymentDAO = new PaymentDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void processPayment(Payment payment) {
        paymentDAO.createPayment(payment);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payment getPayment(@PathParam("id") int id) {
        return paymentDAO.getPayment(id);
    }
}
