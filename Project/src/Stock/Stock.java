package Stock;

import java.util.List;

public class Stock {
	
	private List<Item> inventory;
	
	public Stock (List<Item> inventory) {
		this.inventory = inventory;
	}
	public void addItem(Item item) {
		if (!inventory.contains(item)) {
			inventory.add(item);
		}
	}
	
	public void removeItem(Item item) {
		
	}
	
	public List<Item> inventory() {
		return this.inventory;
		
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
