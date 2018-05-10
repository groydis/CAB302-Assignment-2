package Stock;

import java.util.List;

public class Stock {
	private static List<Item> inventory;
	
	private List<Item> stockOrder;
	
	public Stock(List<Item> inventory) {
		this.inventory = inventory;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	
	public static void updateInventory(String[] data) {
		for (Item i: inventory) {
			if (data[0] == i.GetName()) {
				i.setQuantity(Integer.parseInt(data[1]));
				
			}
		}
	}

}
