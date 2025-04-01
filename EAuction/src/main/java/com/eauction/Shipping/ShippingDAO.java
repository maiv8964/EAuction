package com.eauction.Shipping;

import java.sql.*;

import com.eauction.DatabaseConnection;

public class ShippingDAO implements ShippingInterface {

    @Override
    public Shipping createShipping(Shipping shipping) {
        String sql = "INSERT INTO shipping (userId, itemId, shippingAddress, trackingNumber, estimatedDelivery) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, shipping.getUserId());
            pstmt.setInt(2, shipping.getItemId());
            pstmt.setString(3, shipping.getShippingAddress());
            pstmt.setString(4, shipping.getTrackingNumber());
            pstmt.setString(5, shipping.getEstimatedDelivery());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting shipping details: " + e.getMessage());
        }
        
        String sqlGet = "SELECT * FROM shipping WHERE userId = ? AND itemId = ?";
        Shipping shippinginfo = null;
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sqlGet)) {
            pstmt.setInt(1, shipping.getUserId());
            pstmt.setInt(2, shipping.getItemId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                shippinginfo = new Shipping();
                shippinginfo.setId(rs.getInt("id"));
                shippinginfo.setUserId(rs.getInt("userId"));
                shippinginfo.setItemId(rs.getInt("itemId"));
                shippinginfo.setShippingAddress(rs.getString("shippingAddress"));
                shippinginfo.setTrackingNumber(rs.getString("trackingNumber"));
                shippinginfo.setEstimatedDelivery(rs.getString("estimatedDelivery"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching shipping details: " + e.getMessage());
        }
        
        return shippinginfo;
    }

    @Override
    public Shipping getShipping(int id) {
        String sql = "SELECT * FROM shipping WHERE id = ?";
        Shipping shipping = null;
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                shipping = new Shipping();
                shipping.setId(rs.getInt("id"));
                shipping.setUserId(rs.getInt("userId"));
                shipping.setItemId(rs.getInt("itemId"));
                shipping.setShippingAddress(rs.getString("shippingAddress"));
                shipping.setTrackingNumber(rs.getString("trackingNumber"));
                shipping.setEstimatedDelivery(rs.getString("estimatedDelivery"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching shipping details: " + e.getMessage());
        }
        return shipping;
    }

    @Override
    public Shipping updateShipping(int id, Shipping shipping) {
        String sql = "UPDATE shipping SET userId = ?, itemId = ?, shippingAddress = ?, trackingNumber = ?, estimatedDelivery = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, shipping.getUserId());
            pstmt.setInt(2, shipping.getItemId());
            pstmt.setString(3, shipping.getShippingAddress());
            pstmt.setString(4, shipping.getTrackingNumber());
            pstmt.setString(5, shipping.getEstimatedDelivery());
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating shipping details: " + e.getMessage());
        }
        
        return shipping;
    }
}
