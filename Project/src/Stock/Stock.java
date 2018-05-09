package Stock;

import java.util.List;

public class Stock {
	private List<Item> inventory;
	
	public Stock(List<Item> inventory) {
		this.setInventory(inventory);
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

}
