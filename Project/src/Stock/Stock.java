package Stock;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private List<Item> inventory;
	
	public Stock () {
		this.inventory = new ArrayList<Item>();
	}
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	public void removeItem(Item item) {
		inventory.remove(item);
	}
	
	public List<Item> inventory() {
		return this.inventory;
		
	}
	
	public int total() {
		return inventory.size();
	}
	
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
	
	public void clear() {
		inventory.clear();
	}
	

	public void updateSales(String[] data) {
		int quantity = Integer.parseInt(data[1]);
		for (Item item : inventory()) {
			if (item.name().equals(data[0])) {
				item.UpdateQuantity(quantity);
			}
		}
	}


}
