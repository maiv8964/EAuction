package com.eauction.Payment;

public interface PaymentInterface {
    boolean processPayment(Payment payment);
    Payment getPayment(int id);
}
