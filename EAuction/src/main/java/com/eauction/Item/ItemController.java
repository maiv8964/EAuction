package com.eauction.Item;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/items")
public class ItemController {

	private final ItemInterface itemDAO = new ItemDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllItems() {
		return itemDAO.readAllItems();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void listItem(Item item) {
		itemDAO.listNewItem(item);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item getItem(@PathParam("id") int id) {
		return itemDAO.readItemId(id);
	}
	
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItemsQuery(@QueryParam("q") String query) {
		return itemDAO.readQuery(query);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateItem(@PathParam("id") int id, Item item) {
		itemDAO.updateItem(id, item);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteItem(@PathParam("id") int id) {
		itemDAO.deleteItem(id);
	}
}
