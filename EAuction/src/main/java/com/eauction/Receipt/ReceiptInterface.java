package com.eauction.Receipt;

public interface ReceiptInterface {
	Receipt createReceipt(Receipt receipt);
    Receipt getReceipt(int id);
    Receipt updateReceipt(int id, Receipt receipt);
}
