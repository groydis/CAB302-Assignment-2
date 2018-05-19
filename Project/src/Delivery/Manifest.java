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
		boolean fillingUpTruck = false;

		//this.storeInventory.sort();
		//this.storeInventory.sortAlpha();
		
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
			fillingUpTruck = true;
			for (Item item : ordinaryItems.inventory()) {
			
				if (fillingUpTruck) {
					cargo.addItem(item);
					if (cargo.total() == 800) {
						Truck coldTruck = new RefrigeratedTruck(cargo);
						fleet.add(coldTruck);
						cargo = new Stock();
						fillingUpTruck = false;
					}
				} else {
					cargo.addItem(item);
					if (cargo.total() == 1000) {
						Truck ordinaryTruck = new OrdinaryTruck(cargo);
						fleet.add(ordinaryTruck);
						cargo = new Stock();
					}
				}
			}
		}
		
		if (cargo.total() != 1000) {
			Truck ordinaryTruck = new OrdinaryTruck(cargo);
			fleet.add(ordinaryTruck);
		}
		/*
		for (Truck truck : fleet) {
			
			List<String> cargos = truck.getCargo();
			
			// Testing
			System.out.println("-------------");
			for (String output : cargos) {
				System.out.println(output);
				
			}
			System.out.println(truck.getCost());
			System.out.println("-------------");
		}
		*/
	}
	
	public List<Truck> getFleet() {
		return this.fleet;
	}

}
