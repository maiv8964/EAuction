package com.eauction;

public interface PaymentInterface {
    boolean processPayment(Payment payment);
    Payment getPayment(int id);
}
