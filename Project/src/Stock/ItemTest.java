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

class ItemTest {
	
	Item testItem;
	String name = "Test Item";
	double manufacturingCost = 100.00;
	double sellPrice = 150.00;
	int reorderPoint = 5;
	int reorderAmount = 10;
	float storageTemp = 0;
	
	@Before
	public void setupItem() {
		testItem = new Item(name, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);

	}
	
	@Test
	public void testName() {
		String testName = name;
		String actualName = testItem.Name();
		assertEquals(testName, actualName);
	}
	
	@Test
	public void testManufacturingCost() {
		double testCost = manufacturingCost;
		double actualCost = testItem.ManufacturingCost();
		assertEquals(testCost, actualCost);
	}
	
	@Test
	public void testSellPrice() {
		double testSellPrice = sellPrice;
		double actualSellPrice = testItem.SellPrice();
		assertEquals(testSellPrice, actualSellPrice);
	}
	
	@Test
	public void testReOrderPoint() {
		int testReOrderPoint = reorderPoint;
		int actualReOrderPoint = testItem.ReOrderPoint();
		assertEquals(testReOrderPoint, actualReOrderPoint);
	}
	
	@Test
	public void testReOrderAmount() {
		int testReOrderAmount = reorderAmount;
		int actualReOrderAmount = testItem.ReOrderAmount();
		assertEquals(testReOrderAmount, actualReOrderAmount);
	}
	
	@Test
	public void testStorageTemp() {
		double testStorageTemp = storageTemp;
		double actualStorageTemp = testItem.StorageTemp();
		assertEquals(testStorageTemp, actualStorageTemp);
	}

}
