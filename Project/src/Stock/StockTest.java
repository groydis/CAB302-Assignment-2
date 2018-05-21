package Stock;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import GUI.CSVFormatException;
import GUI.StockException;

/**
 * This class tests the Stock class and ensures that all functions associated with
 * the Stock class work as intended.
 * 
 * @author Greyden Scott
 *
 */

class StockTest {

	Stock testStock;
	List<Item> testInventory;
	String itemRice[] = {"rice", "2", "1", "225", "300", "0"};
	String itemCake[] = {"cake", "4", "1", "300", "400", "0", "5"};
	String itemBoogers[] = {"boogers", "5", "4", "400", "500", "0", "-10"};
	Item rice;
	Item cake;
	Item boogers;

	
	@Test
	void testAddItem() throws StockException {
		testStock = new Stock();
		rice = new Item(itemRice);
		testStock.addItem(rice);
		
		assertEquals(1, testStock.getTotal());
	}
	
	@Test
	void testInventory() throws StockException {
		testStock = new Stock();
		testInventory = new ArrayList<>();
		
		rice = new Item(itemRice);
		cake = new Item(itemCake);
		boogers = new Item(itemBoogers);
		
		testStock.addItem(rice);
		testStock.addItem(cake);
		testStock.addItem(boogers);
		
		testInventory.add(rice);
		testInventory.add(cake);
		testInventory.add(boogers);	
		
		assertEquals(testInventory, testStock.getItems());
	}
	
	@Test
	void testTotal() throws StockException {
		testStock = new Stock();
		
		rice = new Item(itemRice);
		cake = new Item(itemCake);
		boogers = new Item(itemBoogers);
		
		testStock.addItem(rice);
		testStock.addItem(cake);
		testStock.addItem(boogers);
		assertEquals(3, testStock.getTotal());
	}
	
	@Test
	void testTotalItem() throws StockException {
		testStock = new Stock();
		
		rice = new Item(itemRice);
		cake = new Item(itemCake);
		boogers = new Item(itemBoogers);
		
		testStock.addItem(rice);
		testStock.addItem(rice);
		testStock.addItem(rice);
		assertEquals(3, testStock.getTotalItem(rice));

	}
	
	@Test
	void testUpdateSales() throws StockException, CSVFormatException {
		testStock = new Stock();
		
		rice = new Item(itemRice);
		cake = new Item(itemCake);
		boogers = new Item(itemBoogers);
		
		testStock.addItem(rice);
		rice.setQuantity(10);
		
		String sales[] = {"rice", "5"};
		
		testStock.updateSales(sales);
		assertEquals(5, rice.getQuantity());
	}


}
