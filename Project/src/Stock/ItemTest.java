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
	String itemName = "rice";
	int manufacturingCost = 2;
	int sellPrice = 3;
	int reorderPoint = 225;
	int reorderAmount = 300;
	int storageTemp = 0;
	
	int quantity = 250;
	
	String itemRice[] = {"rice", "2.0", "3.0", "225", "300", "0"};
	
	@Before
	public void setupItem() {
		testItem = null;
	}
	
	@Test
	public void testConstruction() {
		testItem = new Item(itemRice);
	}

	
	@Test
	public void testItemName() {
		testItem = new Item(itemRice);
		String testName = itemName;
		String actualName = testItem.name();
		assertEquals(testName, actualName);
	}
	
	@Test
	public void testManufacturingCost() {
		testItem = new Item(itemRice);
		double testCost = manufacturingCost;
		double actualCost = testItem.getManufacturingcost();
		assertEquals(testCost, actualCost, 0.0);
	}
	
	@Test
	public void testSellPrice() {
		testItem = new Item(itemRice);
		double testSellPrice = sellPrice;
		double actualSellPrice = testItem.getSellprice();
		assertEquals(testSellPrice, actualSellPrice, 0.0);
	}
	
	@Test
	public void testReOrderPoint() {
		testItem = new Item(itemRice);
		int testReOrderPoint = reorderPoint;
		int actualReOrderPoint = testItem.getReorderpoint();
		assertEquals(testReOrderPoint, actualReOrderPoint);
	}
	
	@Test
	public void testReOrderAmount() {
		testItem = new Item(itemRice);
		int testReOrderAmount = reorderAmount;
		int actualReOrderAmount = testItem.getReorderAmount();
		assertEquals(testReOrderAmount, actualReOrderAmount);
	}
	
	@Test
	public void testStorageTemp() {
		testItem = new Item(itemRice);
		int testStorageTemp = storageTemp;
		int actualStorageTemp = testItem.getStorageTemp();
		assertEquals(testStorageTemp, actualStorageTemp);
	}
	
	@Test
	public void testQuantity() {
		testItem = new Item(itemRice);
		testItem.UpdateQuantity(quantity);
		int testQuanity = quantity;
		int actualQuantity = testItem.getQuantity();
		assertEquals(testQuanity, actualQuantity);
		
	}

}
