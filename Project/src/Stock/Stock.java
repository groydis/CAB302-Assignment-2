package Stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** 
 * This class is used to represent A collection of items. 
 * Which Can be used for representing store inventory, stock orders, sales logs, and truck cargo.
 * 
 * @author Alex Holm
 *
 */

public class Stock {
	
	private List<Item> inventory;
	
	/**
	 * Constructs an empty Stock and sets up instantiates the inventory which is a List of items.
	 */
	public Stock () {
		this.inventory = new ArrayList<Item>();
		
		
	}
	
	/**
	 * Sorts the items based on the Temperature from lowest (eg -20) to highest (10).
	 */
	public void sort() {
		if (this.inventory.size() > 0) {
			Collections.sort(this.inventory, new Comparator<Item>() {
				@Override
				public int compare(final Item object1, final Item object2) {
					return  Integer.valueOf(object1.getStorageTemp()).compareTo(object2.getStorageTemp());
				}
			});
		}
		
	}
	/**
	 * Sorts the items alphabetically based on name.
	 */
	public void sortAlpha() {
		if (this.inventory.size() > 0) {
			Collections.sort(this.inventory, new Comparator<Item>() {
				@Override
				public int compare(final Item object1, final Item object2) {
					return  object1.name().compareTo(object2.name());
				}
			});
		}
		
	}
	
	/**
	 * Adds an item.
	 * 
	 * @param item The item to be added.
	 */
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	/**
	 * Removes an item.
	 * 
	 * @param item The Item to be removed.
	 */
	public void removeItem(Item item) {
		inventory.remove(item);
	}
	
	
	/**
	 * This function provides access to the List<Item> that the items are stored in in the event
	 * direct access to the List is required.
	 * 
	 * @return The list that the inventory is stored in.
	 */
	public List<Item> inventory() {
		return this.inventory;
		
	}
	
	/**
	 *  Returns the total number of items in the Stock
	 *  
	 * @return Int Total number of items in the Stock
	 */
	public int total() {
		return inventory.size();
	}
	
	
	/**
	 * Calculates the number of a particular items in the inventory.
	 * 
	 * @param item The item in which to find the number of.
	 * 
	 * @return the number of items of found.
	 */
	public int totalItem(Item item) {
		int total = 0;
		if (inventory.contains(item)) {
			for (Item i : inventory) {
				if (i.name() == item.name()) {
					total++;
				}
			}
		}
		return total;
	}
	
	/**
	 * Removes all items from the Stock
	 */
	public void clear() {
		inventory.clear();
	}
	

	/**
	 * Update the quantity of all items based on the passed in data
	 * 
	 * @param data An array of data Name, QTY
	 */
	public void updateSales(String[] data) {
		int quantity = Integer.parseInt(data[1]);
		
		for (Item item : inventory()) {
			if (item.name().equals(data[0])) {
				int qty = item.getQuantity() - quantity;
				item.setQuantity(qty);
			}
		}
		
	}


}
