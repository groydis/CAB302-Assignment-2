package Delivery;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Stock.Item;
import Stock.Stock;


/**
 * Tests the construction of an Ordinary Truck and the functions associated with that truck type
 * 
 * @author Alex Holm
 *
 */

class OrdinaryTruckTest {
	
	Stock cargo = new Stock();
	Truck truck;
	String itemRice[] = {"rice", "2", "1", "225", "300", "0"};
	String itemCake[] = {"cake", "4", "1", "300", "400", "0", "5"};
	String itemBoogers[] = {"boogers", "5", "4", "400", "500", "0", "-10"};
	
	Item rice = new Item(itemRice);
	Item cake = new Item(itemCake);
	Item boogers = new Item(itemBoogers);
	
	List<String> testCargoOutput = new ArrayList<>();
	

	@Test
	void testGetCapacity() {
		truck = new OrdinaryTruck(cargo);
		assertEquals(1000, truck.getCapacity());
	}
	
	@Test
	void testGetCost() {
		cargo.addItem(rice);
		cargo.addItem(cake);
		cargo.addItem(boogers);
		
		truck = new OrdinaryTruck(cargo);
		
		double cost = 750 + (0.25 * cargo.inventory().size());
		
		assertEquals(cost, truck.getCost());
	}

	
	@Test 
	void testGetCargo() {
		cargo.addItem(rice);
		cargo.addItem(cake);
		cargo.addItem(boogers);

		testCargoOutput.add(">Ordinary");
		testCargoOutput.add("rice,1");
		testCargoOutput.add("cake,1");
		testCargoOutput.add("boogers,1");
		
		truck = new OrdinaryTruck(cargo);
		
		assertEquals(testCargoOutput, truck.getCargo());
	}
}
