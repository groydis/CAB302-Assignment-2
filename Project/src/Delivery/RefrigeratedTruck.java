package Delivery;

import java.util.ArrayList;
import java.util.List;

import Stock.Item;
import Stock.Stock;

public class RefrigeratedTruck extends Truck {
	
	private int temperature;
	public RefrigeratedTruck (Stock cargo) {
		super(cargo);
	}
	
	public int getTemperature() {	
		return temperature;
	}
	
	public void setTemperature() {
		int temp = 10;
		for (Item item : getInventory()) {
			if (item.getStorageTemp() < 10) {
				temp = item.getStorageTemp();
			}
		}
		temperature = temp;
	}

	@Override
	public int getCapacity() {
		return 800;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		setTemperature();
		return (900 + 200) * Math.pow(0.7, getTemperature()/5);
	}

	@Override
	public List<String> getCargo() {
		List<String> cargoOutput = new ArrayList<String>();
		cargoOutput.add(">Refrigerated Truck");
		for (Item item : getInventory()) {
			String output = item.name() + "," + cargo().totalItem(item);
			if (!cargoOutput.contains(output)) {
				cargoOutput.add(output);
			}
		}
		return cargoOutput;
	}

}
