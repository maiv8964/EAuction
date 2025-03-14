package com.eauction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserInterface{
	public List<User> readAllUsers() {
		String sql = "SELECT id, username, password, first_name, last_name, address, postal_code, city, country, province FROM users";
		List<User> users = new ArrayList<>();

		try (Connection conn = DatabaseConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setAddress(rs.getString("address"));
				user.setPostalCode(rs.getString("postal_code"));
				user.setCity(rs.getString("city"));
				user.setCountry(rs.getString("country"));
				user.setProvince(rs.getString("province"));
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

	public User createUser(User user) {

		String sql = "INSERT INTO users(username, password, first_name, last_name, address, postal_code, city, country, province) VALUES(?,?,?,?,?,?,?,?,?)";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPostalCode());
			pstmt.setString(7, user.getCity());
			pstmt.setString(8, user.getCountry());
			pstmt.setString(9, user.getProvince());
			pstmt.executeUpdate();
			System.out.println("Added user.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	public User readUserId(int id) {

		String sql = "SELECT username, password, first_name, last_name, address, postal_code, city, country, province FROM users WHERE id = ?";
		User user = null;
		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				// Check if a result was returned
				if (rs.next()) {
					user = new User();
					user.setId(id);
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setAddress(rs.getString("address"));
					user.setPostalCode(rs.getString("postal_code"));
					user.setCity(rs.getString("city"));
					user.setCountry(rs.getString("country"));
					user.setProvince(rs.getString("province"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public void updateUser(int id, User user) {

		String sql = "UPDATE users SET username = ?, password = ?, first_name = ?, last_name = ?, address = ?, postal_code = ?, city = ?, country = ?, province = ? WHERE id = ?";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getPostalCode());
			pstmt.setString(7, user.getCity());
			pstmt.setString(8, user.getCountry());
			pstmt.setString(9, user.getProvince());
			pstmt.setInt(10, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id = ?";

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public User loginUser(String username, String password) {

		String sql = "SELECT username, password, first_name, last_name, address, postal_code, city, country FROM users WHERE username = ? AND password = ?";

		User user = null;

		try (Connection conn = DatabaseConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			try (ResultSet rs = pstmt.executeQuery()) {
				// Check if a result was returned
				if (rs.next()) {
					user = new User();
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setAddress(rs.getString("address"));
					user.setPostalCode(rs.getString("postal_code"));
					user.setCity(rs.getString("city"));
					user.setCountry(rs.getString("country"));

				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return user;

	}
}
