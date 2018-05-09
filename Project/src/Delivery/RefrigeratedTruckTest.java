package Delivery;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Stock.Item;

class RefrigeratedTruckTest {

	RefrigeratedTruck testTruck;
	double truckCost;
	int truckCapacity;
	List<String> truckCargo;
	double truckTemperature;

	@Before
	public void setupTruck() {
		testTruck = null;
	}

	public void testConstruction() {
		testTruck = new RefrigeratedTruck(truckCargo);
	}

	@Test
	public void testTruckCost() {
		testTruck = new RefrigeratedTruck(truckCargo);
		double testcost = 900 + (200 * (0.7 * (testTruck.GetTemperature() /5)));
		double actualcost = testTruck.GetCost();
		assertEquals(testcost, actualcost, "0.2");
	}

	@Test
	public void testTruckCapacity() {
		testTruck = new RefrigeratedTruck(truckCargo);
		int testCapacity = truckCapacity;
		int actualCapacity = testTruck.GetCapacity();
		assertEquals(testCapacity, actualCapacity);
	}

	@Test
	public void testCargo() {
		testTruck = new RefrigeratedTruck(truckCargo);
		List<String> testcargo = truckCargo;
		List<String> actualcargo = testTruck.GetCargo();
		assertEquals(testcargo, actualcargo);
	}
}