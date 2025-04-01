package com.eauction.Shipping;

public interface ShippingInterface {
    Shipping createShipping(Shipping shipping);
    Shipping getShipping(int id);
    Shipping updateShipping(int id, Shipping shipping);
}
