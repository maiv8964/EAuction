package com.eauction;

import java.sql.*;

public class ShippingDAO {
    public void createShipping(Shipping shipping) {
        String sql = "INSERT INTO shipping (userId, itemId, shippingAddress, trackingNumber, estimatedDelivery) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, shipping.getUserId());
            pstmt.setInt(2, shipping.getItemId());
            pstmt.setString(3, shipping.getShippingAddress());
            pstmt.setString(4, shipping.getTrackingNumber());
            pstmt.setString(5, shipping.getEstimatedDelivery());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
