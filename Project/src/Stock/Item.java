package Stock;

public class Item {
	/**
	 *
	 * @author Alex Holm
	 * 
	 */
	String itemName;
	double manufacturingCost, sellPrice;
	int reorderPoint, reorderAmount;
	float storageTemp;
	
	public Item(String itemName, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount, float storageTemp) {
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
	
	public float GetstorageTemp() {
		return storageTemp;
	}
	
}
