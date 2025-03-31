package com.eauction.Item;

import java.util.List;

public interface ItemInterface {
	List<Item> readAllItems();
	Item listNewItem(Item item);
	Item readItemId(int id);
	List<Item> readQuery(String query);
	Item updateItem(int id, Item item);
	void deleteItem(int id);
}
