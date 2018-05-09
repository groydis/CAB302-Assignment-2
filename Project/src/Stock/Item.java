package Stock;

public class Item {
	/**
	 *
	 * @author Alex Holm
	 * 
	 */
	private String itemName;
	private double manufacturingCost; 
	private double sellPrice;
	private int reorderPoint, reorderAmount;
	private double storageTemp;
	private int quantity;
	
	public Item(String itemName, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount, double storageTemp) {
		this.itemName = itemName;
		this.manufacturingCost = manufacturingCost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.storageTemp = storageTemp;
		setQuantity(0);
	}
	
	public static Item createItem(String[] data) {

		String itemName = data[0];
		double manufacturingCost = Double.parseDouble(data[1]);
		double sellPrice = Double.parseDouble(data[2]);
		int reorderPoint = Integer.parseInt(data[3]);
		int reorderAmount = Integer.parseInt(data[4]);
		double storageTemp = 0;
		if (data.length == 6) {
			storageTemp = Double.parseDouble(data[5]);
		}
		
		return new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
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
		String output = itemName + " " +
		manufacturingCost + " " +
		sellPrice +  " " +
		reorderPoint +  " " +
		reorderAmount + " " +
		storageTemp;
		return output;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
