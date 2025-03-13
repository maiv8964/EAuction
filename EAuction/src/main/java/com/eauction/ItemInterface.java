package com.eauction;

import java.util.List;

public interface ItemInterface {
	List<Item> readAllItems();
	void listNewItem(Item item);
	Item readItemId(int id);
	List<Item> readQuery(String query);
	void updateItem(int id, Item item);
	void deleteItem(int id);
}
