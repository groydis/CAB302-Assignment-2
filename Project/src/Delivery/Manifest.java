package Delivery;

import java.util.ArrayList;
import java.util.List;

import Stock.Item;
import Stock.Stock;

public class Manifest {
	
	List<Truck> fleet;
	
	Stock storeInventory;
	
	Stock coldItems = new Stock();
	Stock ordinaryItems = new Stock();
	
	Stock cargo = new Stock();
	
	public Manifest(Stock storeInventory) {
		this.storeInventory = storeInventory;
		this.fleet = new ArrayList<>();
		
		for (Item item : storeInventory.inventory()) {
			if(item.getStorageTemp() <= 10) {
				coldItems.addItem(item);	
			} else {
				ordinaryItems.addItem(item);	
			}
		}
		
		for (Item item : coldItems.inventory()) {
			cargo.addItem(item);
			if (cargo.total() == 800) {
				Truck coldTruck = new RefrigeratedTruck(cargo);
				fleet.add(coldTruck);
				cargo = new Stock();
			}
		}
		if (cargo.total() != 800) {
			for (Item item : ordinaryItems.inventory()) {
				cargo.addItem(item);
				if (cargo.total() == 800) {
					Truck coldTruck = new RefrigeratedTruck(cargo);
					fleet.add(coldTruck);
					cargo = new Stock();
				}
			}
		} else {
			Truck coldTruck = new RefrigeratedTruck(cargo);
			fleet.add(coldTruck);
			cargo = new Stock();
		}
		for (Item item : ordinaryItems.inventory()) {
			cargo.addItem(item);
			if (cargo.total() == 1000) {
				Truck ordinaryTruck = new OrdinaryTruck(cargo);
				fleet.add(ordinaryTruck);
				cargo = new Stock();
			}
		}
		
		for (Truck truck : fleet) {
			List<String> cargos = truck.getCargo();
			for (String output : cargos) {
				System.out.println(output);
			}
		}
		
	}
	
	public List<Truck> CreateFleet() {
		return fleet;
		
	}
	
	public List<Truck> getFleet() {
		return this.fleet;
	}
	
	public void addToFleet(Truck truck) {
		this.fleet.add(truck);
	}

	public List<String> generateManifest() {
		// TODO Auto-generated method stub
		return null;
	}

}
