package com.eauction;

public interface ShippingInterface {
    void createShipping(Shipping shipping);
    Shipping getShipping(int id);
    void updateShipping(int id, Shipping shipping);
}
