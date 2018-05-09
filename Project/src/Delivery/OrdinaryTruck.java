package Delivery;

import java.util.List;

public class OrdinaryTruck extends Truck {
	
	private List<String> cargo;
	
	public OrdinaryTruck(List<String> cargo) {
		this.cargo  = cargo;
	}
	
	@Override
	public int Capacity() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public double Cost() {
		// TODO Cost in dollars equal to 750 + 0.25q where q is the total quantity 
		// of items in the cargo.
		double cost = 750 + (0.25 * Quantity());
		return cost;
	}

	@Override
	public List<String> GetCargo() {
		// TODO Auto-generated method stub
		// SET QUANITY
		return cargo;
	}
	
	public int Quantity() {
		// Should return total count of items in inventory
		// Should not exceed 1000/
		
		return 0;
		
	}

}
