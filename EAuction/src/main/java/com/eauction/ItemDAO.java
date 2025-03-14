package com.eauction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements ItemInterface{
	public List<Item> readAllItems() {
		String sql = "SELECT id, name, condition, currentPrice, description, highestBidderId, auctionType, remainingTime, shippingPrice, auctionStatus, sellerId, remainingTime FROM items";

		List<Item> items = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCondition(rs.getString("condition"));
				item.setCurrentPrice(rs.getFloat("currentPrice"));
				item.setDescription(rs.getString("description"));
				item.setHighestBidderId(rs.getInt("highestBidderId"));
				item.setAuctionType(rs.getString("auctionType"));
				item.setAuctionStatus(rs.getString("auctionStatus"));
				item.setRemainingTime(rs.getString("remainingTime"));
				item.setShippingPrice(rs.getFloat("shippingPrice"));
				item.setSellerId(rs.getInt("sellerId"));
				items.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return items;
	}

	public void listNewItem(Item item) {

		String sql = "INSERT INTO items(name, condition, currentPrice, description, highestBidderId, auctionType, remainingTime, shippingPrice, auctionStatus, sellerId) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getCondition());
			pstmt.setFloat(3, item.getCurrentPrice());
			pstmt.setString(4, item.getDescription());
			pstmt.setInt(5, item.getHighestBidderId());
			pstmt.setString(6, item.getAuctionType());
			pstmt.setString(7, item.getRemainingTime());
			pstmt.setFloat(8, item.getShippingPrice());
			pstmt.setString(9, item.getAuctionStatus());
			pstmt.setInt(10, item.getSellerId());
			pstmt.executeUpdate();
			System.out.println("Added item.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Item readItemId(int id) {

		String sql = "SELECT id, name, condition, currentPrice, description, highestBidderId, auctionType, remainingTime, shippingPrice, auctionStatus, sellerId, remainingTime FROM items WHERE id = ?";
		Item item = null;
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				// Check if a result was returned
				if (rs.next()) {
					item = new Item();
					item.setId(id);
					item.setName(rs.getString("name"));
					item.setCondition(rs.getString("condition"));
					item.setCurrentPrice(rs.getFloat("currentPrice"));
					item.setDescription(rs.getString("description"));
					item.setHighestBidderId(rs.getInt("highestBidderId"));
					item.setAuctionType(rs.getString("auctionType"));
					item.setAuctionStatus(rs.getString("auctionStatus"));
					item.setRemainingTime(rs.getString("remainingTime"));
					item.setShippingPrice(rs.getFloat("shippingPrice"));
					item.setSellerId(rs.getInt("sellerId"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return item;
	}

	public List<Item> readQuery(String query) {

		String sql = "SELECT id, id, name, condition, currentPrice, description, highestBidderId, auctionType, remainingTime, shippingPrice, auctionStatus, sellerId, remainingTime FROM items WHERE name LIKE ? OR description LIKE ?";
		List<Item> items = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%" + query + "%");
			pstmt.setString(2, "%" + query + "%");

			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					Item item = new Item();
					item.setId(rs.getInt("id"));
					item.setName(rs.getString("name"));
					item.setCondition(rs.getString("condition"));
					item.setCurrentPrice(rs.getFloat("currentPrice"));
					item.setDescription(rs.getString("description"));
					item.setHighestBidderId(rs.getInt("highestBidderId"));
					item.setAuctionType(rs.getString("auctionType"));
					item.setAuctionStatus(rs.getString("auctionStatus"));
					item.setRemainingTime(rs.getString("remainingTime"));
					item.setShippingPrice(rs.getFloat("shippingPrice"));
					item.setSellerId(rs.getInt("sellerId"));
					items.add(item);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return items;

	}

	public void updateItem(int id, Item item) {
									//
		String sql = "UPDATE items SET name = ?, condition = ?, currentPrice = ?, description = ?, highestBidderId = ?, auctionType = ?, remainingTime = ?, shippingPrice = ?, auctionStatus = ?, sellerId = ?, remainingTime = ? WHERE id = ?";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getCondition());
			pstmt.setFloat(3, item.getCurrentPrice());
			pstmt.setString(4, item.getDescription());
			pstmt.setInt(5, item.getHighestBidderId());
			pstmt.setString(6, item.getAuctionType());
			pstmt.setString(7, item.getRemainingTime());
			pstmt.setFloat(8, item.getShippingPrice());
			pstmt.setString(9, item.getAuctionStatus());
			pstmt.setInt(10, item.getSellerId());
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteItem(int id) {
		String sql = "DELETE FROM items WHERE id = ?";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
