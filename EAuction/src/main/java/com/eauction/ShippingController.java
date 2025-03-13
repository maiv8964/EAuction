package com.eauction;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/shipping")
public class ShippingController {
    private ShippingDAO shippingDAO = new ShippingDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createShipping(Shipping shipping) {
        shippingDAO.createShipping(shipping);
    }
}
