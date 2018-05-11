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
	double manufacturingCost = 2.0;
	double sellPrice = 3.0;
	int reorderPoint = 225;
	int reorderAmount = 300;
	double storageTemp = 0.0;
	
	int quantity = 250;
	
	String itemRice[] = {"rice", "2.0", "3.0", "225", "300", "0.0"};
	
	@Before
	public void setupItem() {
		testItem = null;
	}
	
	@Test
	public void testConstruction() {
		testItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
	}
	
	@Test
	public void testCreateItem() {
		testItem = Item.CreateItem(itemRice);
		Item actualItem = new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
		assertEquals(testItem, actualItem);
	}
	
	@Test
	public void testItemName() {
		testItem = Item.CreateItem(itemRice);
		String testName = itemName;
		String actualName = testItem.name();
		assertEquals(testName, actualName);
	}
	
	@Test
	public void testManufacturingCost() {
		testItem = Item.CreateItem(itemRice);
		double testCost = manufacturingCost;
		double actualCost = testItem.manufacturingcost();
		assertEquals(testCost, actualCost, 0.0);
	}
	
	@Test
	public void testSellPrice() {
		testItem = Item.CreateItem(itemRice);
		double testSellPrice = sellPrice;
		double actualSellPrice = testItem.sellprice();
		assertEquals(testSellPrice, actualSellPrice, 0.0);
	}
	
	@Test
	public void testReOrderPoint() {
		testItem = Item.CreateItem(itemRice);
		int testReOrderPoint = reorderPoint;
		int actualReOrderPoint = testItem.reorderpoint();
		assertEquals(testReOrderPoint, actualReOrderPoint);
	}
	
	@Test
	public void testReOrderAmount() {
		testItem = Item.CreateItem(itemRice);
		int testReOrderAmount = reorderAmount;
		int actualReOrderAmount = testItem.reorderamount();
		assertEquals(testReOrderAmount, actualReOrderAmount);
	}
	
	@Test
	public void testStorageTemp() {
		testItem = Item.CreateItem(itemRice);
		double testStorageTemp = storageTemp;
		double actualStorageTemp = testItem.storageTemp();
		assertEquals(testStorageTemp, actualStorageTemp, 0.0);
	}
	
	@Test
	public void testToString() {
		testItem = Item.CreateItem(itemRice);
		String testString = testItem.toString();
		String actualString = "rice 2.0 3.0 225 300 0.0";
		assertEquals(testString, actualString);
		
	}
	
	@Test
	public void testQuantity() {
		testItem = Item.CreateItem(itemRice);
		testItem.UpdateQuantity(quantity);
		int testQuanity = quantity;
		int actualQuantity = testItem.quantity();
		assertEquals(testQuanity, actualQuantity);
		
	}

}
