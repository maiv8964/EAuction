package com.eauction;

import java.sql.*;

public class PaymentDAO {
    public void createPayment(Payment payment) {
        String sql = "INSERT INTO payments (userId, itemId, amountPaid, paymentMethod, paymentStatus) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getUserId());
            pstmt.setInt(2, payment.getItemId());
            pstmt.setFloat(3, payment.getAmountPaid());
            pstmt.setString(4, payment.getPaymentMethod());
            pstmt.setString(5, payment.getPaymentStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Payment getPayment(int id) {
        String sql = "SELECT * FROM payments WHERE id = ?";
        Payment payment = null;
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setUserId(rs.getInt("userId"));
                payment.setItemId(rs.getInt("itemId"));
                payment.setAmountPaid(rs.getFloat("amountPaid"));
                payment.setPaymentMethod(rs.getString("paymentMethod"));
                payment.setPaymentStatus(rs.getString("paymentStatus"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return payment;
    }
}
