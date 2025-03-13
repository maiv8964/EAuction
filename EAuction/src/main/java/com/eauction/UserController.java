package com.eauction;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.net.URI;



@Path("/users")
public class UserController {

	private UserDAO userDAO = new UserDAO();

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<User> getAllUsers() {
//		return userDAO.readAll();
//	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User logInUser(@Context HttpServletRequest request, User user) {
		
		User loggedInAccount = userDAO.login(user.getUsername(), user.getPassword());
		
		// Authenticate user login
		if(loggedInAccount != null) {
			System.out.println("Successful Login");
			return loggedInAccount;
		};
		System.out.println("Invalid Login");
		return null;
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User registerUser(User user) {
		return userDAO.create(user);
	}

	@GET
	@Path("/profile/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User userProfile(@PathParam("id") int id) {
		return userDAO.read(id);
	}

	@PUT
	@Path("/profile/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateUserProfile(@PathParam("id") int id, User user) {
		return userDAO.update(id, user);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUser(@PathParam("id") int id) {
		userDAO.delete(id);
	}
}
