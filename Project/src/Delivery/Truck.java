package Delivery;

import java.util.List;

import Stock.Item;
import Stock.Stock;

public abstract class Truck {
	
	private Stock cargo;
	private List<Item> inventory;
	
	public Truck(Stock inventory) {
		this.cargo = inventory;
		this.inventory = inventory.inventory();
	}
	
	public List<Item> getInventory() {
		return this.inventory;
	}
	
	public Stock cargo() {
		return this.cargo;
	}
	
	public abstract int getCapacity();
		
	public abstract double getCost();
	
	public abstract List<String> getCargo();
	

}
