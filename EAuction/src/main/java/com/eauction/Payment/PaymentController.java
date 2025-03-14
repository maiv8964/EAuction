package com.eauction.Payment;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/payments")
public class PaymentController {
    private PaymentInterface paymentDAO = new PaymentDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processPayment(Payment payment) {
        boolean success = paymentDAO.processPayment(payment);
        if (success) {
            return Response.ok("{\"message\": \"Payment successful.\"}").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Invalid payment details.\"}").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payment getPayment(@PathParam("id") int id) {
        return paymentDAO.getPayment(id);
    }
}
