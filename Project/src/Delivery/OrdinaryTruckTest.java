package Delivery;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Stock.Item;

class OrdinaryTruckTest {

	OrdinaryTruck testTruck;
	double truckCost = 0;
	int truckCapacity = 0;
	List<String> truckCargo;
	double truckTemperature = 0;
	

	@Before
	public void setupTruck() {
		testTruck = null;
	}

	public void testConstruction() {
		testTruck = new OrdinaryTruck(truckCargo);
	}

	@Test
	public void testTruckCost() {
		testTruck = new OrdinaryTruck(truckCargo);
		double testcost = truckCost;
		double actualcost = testTruck.GetCost();
		assertEquals(testcost, actualcost, 0.0);
	}

	@Test
	public void testTruckCapacity() {
		testTruck = new OrdinaryTruck(truckCargo);
		int testCapacity = truckCapacity;
		int actualCapacity = testTruck.GetCapacity();
		assertEquals(testCapacity, actualCapacity);
	}

	@Test
	public void testCargo() {
		testTruck = new OrdinaryTruck(truckCargo);
		List<String> testcargo = truckCargo;
		List<String> actualcargo = testTruck.GetCargo();
		assertEquals(testcargo, actualcargo, 0.0);
	}
}

