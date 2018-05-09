package Delivery;

import java.util.List;

public class RefrigeratedTruck extends Truck {
	private List<String> cargo;
	private double temperature;
	
	public RefrigeratedTruck(List<String> cargo) {
		this.cargo  = cargo;
		SetTemperature();
	}
	
	@Override
	public double GetCost() {
		// TODO Cost in dollars equal to 900 + 200 × 0.7T/5 where T is the 
		// truck’s temperature in °C.
		double cost = 900 + (200 * (0.7 * (GetTemperature() / 5)));
		return cost;
	}

	
	@Override
	public int GetCapacity() {
		return 800;
	}


	@Override
	public List<String> GetCargo() {
		// TODO Auto-generated method stub
		return cargo;
	}
	
	private void SetTemperature() {
		// TODO Temperature in °C that maintains a safe temperature for the truck’s cargo. 
		// This is equal to the temperature of the item in the cargo with the coldest safe 
		// temperature. The allowed temperature range is from -20°C inclusive to 10°C inclusive.
		
	}
	
	public double GetTemperature() {
		return temperature;
	}

}
