package com.eauction.Receipt;

public interface ReceiptInterface {
    void createReceipt(Receipt receipt);
    Receipt getReceipt(int id);
    void updateReceipt(int id, Receipt receipt);
}
