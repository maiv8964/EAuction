package com.eauction.Payment;

import java.sql.*;
import java.util.regex.Pattern;

import com.eauction.DatabaseConnection;

public class PaymentDAO implements PaymentInterface {

    @Override
    public boolean processPayment(Payment payment) {
        if (!validatePaymentDetails(payment)) {
            System.out.println("Invalid payment details.");
            return false;
        }

        String sql = "INSERT INTO payments (userId, itemId, amountPaid, paymentMethod, paymentStatus, cardNumber, cardHolderName, expirationDate, cvv) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, payment.getUserId());
            pstmt.setInt(2, payment.getItemId());
            pstmt.setFloat(3, payment.getAmountPaid());
            pstmt.setString(4, payment.getPaymentMethod());
            pstmt.setString(5, "Completed");
            pstmt.setString(6, payment.getCardNumber());
            pstmt.setString(7, payment.getCardHolderName());
            pstmt.setString(8, payment.getExpirationDate());
            pstmt.setString(9, payment.getCvv());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error processing payment: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Payment getPayment(int id) {
        String sql = "SELECT * FROM payments WHERE userId = ?";
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
                payment.setCardNumber(rs.getString("cardNumber"));
                payment.setCardHolderName(rs.getString("cardHolderName"));
                payment.setExpirationDate(rs.getString("expirationDate"));
                payment.setCvv(rs.getString("cvv"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching payment: " + e.getMessage());
        }
        return payment;
    }

    private boolean validatePaymentDetails(Payment payment) {
        if (payment.getAmountPaid() <= 0) return false;
        if (!isValidCardNumber(payment.getCardNumber())) return false;
        if (!isValidExpiryDate(payment.getExpirationDate())) return false;
        if (!isValidCvv(payment.getCvv())) return false;
        return true;
    }

    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }

    private boolean isValidExpiryDate(String expiryDate) {
        return expiryDate != null && expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}");
    }

    private boolean isValidCvv(String cvv) {
        return cvv != null && cvv.matches("\\d{3}");
    }
}
