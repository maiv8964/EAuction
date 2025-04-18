package com.eauction.Shipping;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/shipping")
public class ShippingController {
    private ShippingDAO shippingDAO = new ShippingDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Shipping createShipping(Shipping shipping) {
        return shippingDAO.createShipping(shipping);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Shipping getShipping(@PathParam("id") int id) {
        return shippingDAO.getShipping(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Shipping updateShipping(@PathParam("id") int id, Shipping shipping) {
        return shippingDAO.updateShipping(id, shipping);
    }
}
