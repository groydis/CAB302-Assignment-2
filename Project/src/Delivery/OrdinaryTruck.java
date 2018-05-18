package Delivery;

import java.util.ArrayList;
import java.util.List;

import Stock.Item;
import Stock.Stock;

public class OrdinaryTruck extends Truck {
	
	public OrdinaryTruck(Stock cargo) {
		super(cargo);
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 750 + 0.25 * getInventory().size();
	}

	@Override
	public List<String> getCargo() {
		List<String> cargoOutput = new ArrayList<String>();
		cargoOutput.add(">Ordinary Truck");
		for (Item item : getInventory()) {
			String output = item.name() + "," + cargo().totalItem(item);
			if (!cargoOutput.contains(output)) {
				cargoOutput.add(output);
			}
		}
		return cargoOutput;
	}


}
