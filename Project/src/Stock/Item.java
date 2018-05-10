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
	private int quantity = 0;
	
	public Item(String itemName, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount, double storageTemp) {
		this.itemName = itemName;
		this.manufacturingCost = manufacturingCost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.storageTemp = storageTemp;
	}
	
	public static Item CreateItem(String[] data) {

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

	public String name() {
		return this.itemName;
	}
	
	public double manufacturingcost() {
		return this.manufacturingCost;
	}
	
	public double sellprice() {
		return this.sellPrice;
	}
	
	public int reorderpoint() {
		return this.reorderPoint;
	}
	
	public int reorderammount() {
		return this.reorderAmount;
	}
	
	public double storegetemp() {
		return this.storageTemp;
	}

	public int quantity() {
		return this.quantity;
	}

	public void UpdateQuantity(int quantity) {
		this.quantity = quantity;
		if (quantity > this.reorderPoint) {
			// TODO Flag for re-ordering
		}
	}
	
	// CURRENTLY ONLY USED FOR TESTING
	public String toString() {
		String output = itemName + " " +
		manufacturingCost + " " +
		sellPrice +  " " +
		reorderPoint +  " " +
		reorderAmount + " " +
		storageTemp;
		return output;
		
	}
	
}
