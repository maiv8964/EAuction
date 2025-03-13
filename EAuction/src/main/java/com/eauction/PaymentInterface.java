package com.eauction;

public interface PaymentInterface {
    void createPayment(Payment payment);
    Payment getPayment(int id);
}
