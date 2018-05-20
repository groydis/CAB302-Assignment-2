package Stock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * This class tests the Item class and ensures that all functions associated with
 * the Item class work as intended.
 * 
 * @author Greyden Scott
 *
 */

class ItemTest {
	
	Item testItem;
	
	String itemRice[] = {"rice", "2", "3", "225", "300"};
	String itemBoogers[] = {"boogers", "2", "3", "225", "300", "-10"};
	
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
		assertEquals("rice", testItem.getName());
	}
	
	@Test
	public void testManufacturingCost() {
		testItem = new Item(itemRice);
		assertEquals(2, testItem.getManufacturingCost());
	}
	
	@Test
	public void testSellPrice() {
		testItem = new Item(itemRice);
		assertEquals(3, testItem.getSellPrice());
	}
	
	@Test
	public void testReOrderPoint() {
		testItem = new Item(itemRice);
		assertEquals(225, testItem.getReorderpoint());
	}
	
	@Test
	public void testReOrderAmount() {
		testItem = new Item(itemRice);

		assertEquals(300, testItem.getReorderAmount());
	}
	
	@Test
	public void testStorageTempNormalItem() {
		testItem = new Item(itemRice);

		int actualStorageTemp = testItem.getStorageTemp();
		assertEquals(24, actualStorageTemp);
	}
	
	@Test
	public void testStorageTempColdItem() {
		testItem = new Item(itemBoogers);
		assertEquals(-10, testItem.getStorageTemp());
	}
	
	@Test
	public void testQuantity() {
		testItem = new Item(itemRice);
		
		testItem.setQuantity(50);

		assertEquals(50, testItem.getQuantity());
		
	}
	
	public void testReorderFalse() {
		testItem = new Item(itemRice);
		testItem.setQuantity(500);
		assertEquals(false, testItem.reorder());
	}
	
	public void testReorderTrue() {
		testItem = new Item(itemRice);
		assertEquals(true, testItem.reorder());
	}

}
