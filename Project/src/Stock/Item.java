package Stock;

public class Item {
	/**
	 *
	 * @author Alex Holm
	 * 
	 */
	String itemName;
	double manufacturingCost; 
	double sellPrice;
	int reorderPoint, reorderAmount;
	double storageTemp;
	
	public Item(String itemName, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount, double storageTemp) {
		this.itemName = itemName;
		this.manufacturingCost = manufacturingCost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.storageTemp = storageTemp;
	}

	public String GetName() {
		return itemName;
	}
	
	public double GetManufacturingCost() {
		return manufacturingCost;
	}
	
	public double GetSellPrice() {
		return sellPrice;
	}
	
	public int GetReorderPoint() {
		return reorderPoint;
	}
	
	public int GetReorderAmount() {
		return reorderAmount;
	}
	
	public double GetstorageTemp() {
		return storageTemp;
	}
	
	public String toString() {
		String output = itemName + 
		manufacturingCost +
		sellPrice + 
		reorderPoint + 
		reorderAmount +
		storageTemp;
		return output;
		
	}
	
}
