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
	private int storageTemp;
	private int quantity = 0;
	private Boolean reorder;
	
	/**
	 * Constructs and item based on the array of parameters passed in from the 
	 * item properties document.
	 * 
	 * @param  data Array of data parsed by the file reader
	 */
	public Item(String[] attirbutes) {
		
		this.itemName = attirbutes[0];
		this.manufacturingCost = Double.parseDouble(attirbutes[1]);
		this.sellPrice = Double.parseDouble(attirbutes[2]);
		this.reorderPoint = Integer.parseInt(attirbutes[3]);
		this.reorderAmount = Integer.parseInt(attirbutes[4]);
		if (attirbutes.length == 6) {
			storageTemp = Integer.parseInt(attirbutes[5]);
		} else {
			storageTemp = 24;
		}
		this.reorder = true;
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
	public double getManufacturingcost() {
		return this.manufacturingCost;
	}
	
	/**
	 * This method is used for returning the items sell price.
	 *
	 * @return Returns Item sell price
	 */
	public double getSellprice() {
		return this.sellPrice;
	}
	
	/**
	 * This method is used for returning the items reorder point.
	 *
	 * @return Returns Item reorder point
	 */
	public int getReorderpoint() {
		return this.reorderPoint;
	}
	
	/**
	 * This method is used for returning the items reorder amount.
	 *
	 * @return Returns Item reorder amount
	 */
	public int getReorderAmount() {
		return this.reorderAmount;
	}
	
	/**
	 * This method is used for returning the items storage temperature.
	 *
	 * @return Returns Item storage temperature
	 */
	public int getStorageTemp() {
		return this.storageTemp;
	}

	/**
	 * This method is used for returning the items quantity.
	 *
	 * @return Returns the quantity of the item which is stored in the inventory.
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		setQuantity(quantity);
		if (getQuantity() < this.reorderPoint) {
			reorder = true;
		} else {
			reorder = false;
		}
	}
	
	/**
	 * This is just testing
	 */
	
	public String toString() {
		return this.name() + " " + this.getQuantity();
	}
	
}
