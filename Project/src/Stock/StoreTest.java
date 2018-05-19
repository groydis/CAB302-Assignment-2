package Stock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Store class and ensures that all functions associated with
 * the Store class work as intended.
 * 
 * @author Greyden Scott
 *
 */

class StoreTest {
	
	Store testStore;
	String storeName = "Test Store";
	double capital = 100000.00;
	
	
	@Before 
	public void Initialize() {
		testStore = null;
	}
	
	@Test
	public void testConstruction() {
		testStore = new Store(storeName, capital);
	}
	
	@Test
	public void testName() {
		testStore = new Store(storeName, capital);
		String testName = storeName;
		String actualName = testStore.getStoreName();
		assertEquals(testName, actualName);
	}
	
	@Test
	public void testSetCapital() {
		testStore = new Store(storeName, capital);
		double testCapital = 80000.00;
		testStore.setCapital(80000.00);
		double actualCapital = testStore.getCapital();
		assertEquals(testCapital, actualCapital, "0.0");
	}

	@Test
	public void testGetCapital() {

		testStore = new Store(storeName, capital);
		double testCapital = 100000.00;
		double actualCapital = testStore.getCapital();
		assertEquals(testCapital, actualCapital, "0,0");
	}
	
	@Test 
	public void testCapitalToString() {
		testStore = new Store(storeName, capital);
		String testString = "100,000.00";
		String actualString = testStore.capitalToString();
		assertEquals(testString, actualString);
	}

}
