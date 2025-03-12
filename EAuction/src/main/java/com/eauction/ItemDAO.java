package com.eauction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
	public List<Item> readAll() {
		String sql = "SELECT id, name, condition, price, description FROM items";
		List<Item> items = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCondition(rs.getString("condition"));
				item.setPrice(rs.getFloat("price"));
				item.setDescription(rs.getString("description"));
				items.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return items;
	}

	public void create(Item item) {

		String sql = "INSERT INTO items(name, condition, price, description) VALUES(?,?,?,?)";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getCondition());
			pstmt.setFloat(3, item.getPrice());
			pstmt.setString(4, item.getDescription());
			pstmt.executeUpdate();
			System.out.println("Added item.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Item readItem(int id) {

		String sql = "SELECT id, name, condition, price, description FROM items WHERE id = ?";
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
					item.setPrice(rs.getFloat("price"));
					item.setDescription(rs.getString("description"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return item;
	}

	public List<Item> readQuery(String query) {

		String sql = "SELECT id, name, condition, price, description FROM items WHERE name LIKE ? OR description LIKE ?";
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
					item.setPrice(rs.getFloat("price"));
					item.setDescription(rs.getString("description"));
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

	public void update(int id, Item item) {

		String sql = "UPDATE items SET name = ?, condition = ?, price = ?, description = ? WHERE id = ?";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getCondition());
			pstmt.setFloat(3, item.getPrice());
			pstmt.setString(4, item.getDescription());
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int id) {
		String sql = "DELETE FROM items WHERE id = ?";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
