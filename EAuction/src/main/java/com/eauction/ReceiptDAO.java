package com.eauction;

import java.sql.*;

public class ReceiptDAO {
    public void createReceipt(Receipt receipt) {
        String sql = "INSERT INTO receipts (userId, paymentId, dateIssued, totalAmount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, receipt.getUserId());
            pstmt.setInt(2, receipt.getPaymentId());
            pstmt.setString(3, receipt.getDateIssued());
            pstmt.setFloat(4, receipt.getTotalAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
