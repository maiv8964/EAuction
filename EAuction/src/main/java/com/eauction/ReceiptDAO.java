package com.eauction;

import java.sql.*;

public class ReceiptDAO {
    
    // Create Receipt
    public void createReceipt(Receipt receipt) {
        String sql = "INSERT INTO receipts (userId, paymentId, dateIssued, totalAmount) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, receipt.getUserId());
            pstmt.setInt(2, receipt.getPaymentId());
            pstmt.setString(3, receipt.getDateIssued());
            pstmt.setFloat(4, receipt.getTotalAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting receipt: " + e.getMessage());
        }
    }

    // Get Receipt by ID
    public Receipt getReceipt(int id) {
        String sql = "SELECT * FROM receipts WHERE id = ?";
        Receipt receipt = null;
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                receipt = new Receipt();
                receipt.setId(rs.getInt("id"));
                receipt.setUserId(rs.getInt("userId"));
                receipt.setPaymentId(rs.getInt("paymentId"));
                receipt.setDateIssued(rs.getString("dateIssued"));
                receipt.setTotalAmount(rs.getFloat("totalAmount"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching receipt: " + e.getMessage());
        }
        return receipt;
    }

    // Update Receipt
    public void updateReceipt(int id, Receipt receipt) {
        String sql = "UPDATE receipts SET userId = ?, paymentId = ?, dateIssued = ?, totalAmount = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, receipt.getUserId());
            pstmt.setInt(2, receipt.getPaymentId());
            pstmt.setString(3, receipt.getDateIssued());
            pstmt.setFloat(4, receipt.getTotalAmount());
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating receipt: " + e.getMessage());
        }
    }
}
