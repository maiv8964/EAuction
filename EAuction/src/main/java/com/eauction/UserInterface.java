package com.eauction;

import java.util.List;

public interface UserInterface {
	List<User> readAllUsers();
	User createUser(User user);
	User readUserId(int id);
	void updateUser(int id, User user);
	void deleteUser(int id);
	User loginUser(String username, String password);	
}
