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
	private Boolean reorder;
	
	/**
	 * Constructs and item based on the passed parameters
	 *
	 * @param  itemName Name of the item
	 * @param  manufacturingCost Cost to manufacture the item
	 * @param  sellPrice {rice the item is sold for
	 * @param  reorderPoint Point in which a reorder is triggered
	 * @param  reorderAmount Amount of items to reorder
	 * @param  storageTemp Temperature in which the item must be stored
	 */
	public Item(String itemName, double manufacturingCost, double sellPrice, int reorderPoint, int reorderAmount, double storageTemp) {
		this.itemName = itemName;
		this.manufacturingCost = manufacturingCost;
		this.sellPrice = sellPrice;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
		this.storageTemp = storageTemp;
	}
	
	/**
	 * Creates an item based on the array of parameters passed in from the 
	 * item properties document.
	 *
	 * @param  data Array of data parsed by the file reader
	 * @return Returns an Item using the class constructor
	 * @see FileReader
	 */
	public static Item CreateItem(String[] data) {

		String itemName = data[0];
		double manufacturingCost = Double.parseDouble(data[1]);
		double sellPrice = Double.parseDouble(data[2]);
		int reorderPoint = Integer.parseInt(data[3]);
		int reorderAmount = Integer.parseInt(data[4]);
		double storageTemp = 30;
		if (data.length == 6) {
			storageTemp = Double.parseDouble(data[5]);
		}
		
		return new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
	}

	/**
	 * This method is used for returning the items name.
	 *
	 * @return Returns Item name
	 */
	public String name() {
		return this.itemName;
	}
	
	/**
	 * This method is used for returning the items manufacturing cost.
	 *
	 * @return Returns Item manufacturing cost
	 */
	public double manufacturingcost() {
		return this.manufacturingCost;
	}
	
	/**
	 * This method is used for returning the items sell price.
	 *
	 * @return Returns Item sell price
	 */
	public double sellprice() {
		return this.sellPrice;
	}
	
	/**
	 * This method is used for returning the items reorder point.
	 *
	 * @return Returns Item reorder point
	 */
	public int reorderpoint() {
		return this.reorderPoint;
	}
	
	/**
	 * This method is used for returning the items reorder amount.
	 *
	 * @return Returns Item reorder amount
	 */
	public int reorderamount() {
		return this.reorderAmount;
	}
	
	/**
	 * This method is used for returning the items storage temperature.
	 *
	 * @return Returns Item storage temperature
	 */
	public double storageTemp() {
		return this.storageTemp;
	}

	/**
	 * This method is used for returning the items quantity.
	 *
	 * @return Returns the quantity of the item which is stored in the inventory.
	 */
	public int quantity() {
		return this.quantity;
	}
	
	/**
	 * This method is used for returning the whether an item needs to be reordered
	 *
	 * @return Returns boolean value based on whether item needs ot be reordered
	 */
	public Boolean reorder() {
		return this.reorder;
	}

	/**
	 * This method updates the quantity of the item in the inventory
	 * If the quantity falls below the reorder point for the item, sets reorder to true
	 * 
	 * @see reorder
	 */
	public void UpdateQuantity(int quantity) {
		this.quantity = quantity;
		if (quantity > this.reorderPoint) {
			reorder = true;
		} else {
			reorder = false;
		}
	}
	
	
	// CURRENTLY ONLY USED FOR TESTING
	public String toString() {
		String output = itemName + " " +
		manufacturingCost + " " +
		sellPrice +  " " +
		reorderPoint +  " " +
		reorderAmount + " " +
		storageTemp + " " +
		quantity;
		return output;
		
	}
	
}
