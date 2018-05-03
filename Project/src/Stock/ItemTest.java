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
	String itemName = "Test Item";
	double manufacturingCost = 100.00;
	double sellPrice = 150.00;
	int reorderPoint = 5;
	int reorderAmount = 10;
	float storageTemp = 0;
	
	@Before
	public void setupItem() {
		testItem = null;
		}
	
	@Test
	public void testConstruction() {
		testItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
	}
	
	@Test
	public void testitemName() {
		testItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
		String testName = itemName;
		String actualName = testItem.GetName();
		assertEquals(testName, actualName);
	}
	
	@Test
	public void testManufacturingCost() {
		testItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
		double testCost = manufacturingCost;
		double actualCost = testItem.GetManufacturingCost();
		assertEquals(testCost, actualCost, 0.0);
	}
	
	@Test
	public void testSellPrice() {
		testItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
		double testSellPrice = sellPrice;
		double actualSellPrice = testItem.GetSellPrice();
		assertEquals(testSellPrice, actualSellPrice, 0.0);
	}
	
	@Test
	public void testReOrderPoint() {
		testItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
		int testReOrderPoint = reorderPoint;
		int actualReOrderPoint = testItem.GetReorderPoint();
		assertEquals(testReOrderPoint, actualReOrderPoint);
	}
	
	@Test
	public void testReOrderAmount() {
		testItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
		int testReOrderAmount = reorderAmount;
		int actualReOrderAmount = testItem.GetReorderAmount();
		assertEquals(testReOrderAmount, actualReOrderAmount);
	}
	
	@Test
	public void testStorageTemp() {
		testItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
		float testStorageTemp = storageTemp;
		float actualStorageTemp = testItem.GetstorageTemp();
		assertEquals(testStorageTemp, actualStorageTemp, 0.0);
	}

}
