package Stock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Greyden Scott
 *
 */
class StoreTest {
	
	Store testStore;
	String storeName = "Test Store";
	
	@Before 
	public void setupStore() {
		testStore = new Store(name);
		// TODO: Add invenstory to store
	}
	
	@Test
	public void testSetCapital() {
		// Not Sure if get Capital should return a string, 
		// Totally making an assumption.
		String testCapital = "$100,000.00";
		testStore.setCapital(100000);
		String actualCapital = testStore.getCapital();
		assertEquals(testCapital, actualCapital);
	}

	@Test
	public void testGetCapital() {
		// Get capital should return a string in the following format
		// $100,000.00
		String testCapital = "$100,000.00";
		String actualCapital = testStore.getCapital();
		assertEquals(testCapital, actualCapital);
	}
	
	public void testName() {
		String testName = storeName;
		String actualName = testStore.getName();
		assertEquals(testName, actualName);
	}
	
	public void testInventory() {
		// TODO: Test Inventory
		fail("Not yet implemented");
	}

}
