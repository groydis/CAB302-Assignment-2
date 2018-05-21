package GUI;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Delivery.Manifest;
import Delivery.OrdinaryTruck;
import Delivery.RefrigeratedTruck;
import Delivery.Truck;
import Stock.Item;
import Stock.Stock;
import Stock.Store;

/**
 * @author Greyden Scott
 *
 */
public class FileReader {
	private static Stock storeInventory;
	private static Stock itemsToOrder;
	private static Store store;
	private static Manifest manifest;
	
	
	public static void main(String... args)  {
		
		storeInventory = new Stock();
		itemsToOrder = new Stock();
		store = new Store();
		
		//1. Load in item_properties.csv

		try {
			ImportItemProperties("./Files/Errors/item_properties.csv", storeInventory);
		} catch (IOException | CSVFormatException | StockException e) {
			System.out.println(e);
		}

		
		for (Item item: storeInventory.getItems()) {
			if (item.reorder()) {
				for (int i = 0; i < item.getReorderAmount(); i++) {
					itemsToOrder.addItem(item);
				}
			}
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//2. Generate a manifest and load it back in.
		manifest = new Manifest(itemsToOrder);
		ExportManifest("./Files/test1.csv", manifest);
		try {
			ExportManifest("./Files/Errors/test1.csv", manifest);
		} catch (StockException | DeliveryException e) {
			System.out.println(e);
		}
		
		try {
			LoadManifest("./Files/Errors/test1.csv", storeInventory, store);
		} catch (DeliveryException e) {
			System.out.println(e);
		}
		
		for (Item item : storeInventory.getItems()) {
			System.out.println(item.toString());
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//3. Load in sales_log_0.csv
		try {
			LoadSalesLog("./Files/Errors/sales_log_0.csv", storeInventory, store);
		} catch (CSVFormatException e) {
			System.out.println(e);
		}
		/*
		itemsToOrder = new Stock();
		for (Item item: storeInventory.getItems()) {
			if (item.reorder()) {
				for (int i = 0; i < item.getReorderAmount(); i++) {
					itemsToOrder.addItem(item);
				}
			}
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//2. Generate a manifest and load it back in.
		manifest = new Manifest(itemsToOrder);
		ExportManifest("./Files/test1.csv", manifest);
		LoadManifest("./Files/test1.csv", storeInventory, store);
		
		for (Item item : storeInventory.getItems()) {
			System.out.println(item.toString());
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//3. Load in sales_log_0.csv
		LoadSalesLog("./Files/sales_log_1.csv", storeInventory, store);
		
		itemsToOrder = new Stock();
		for (Item item: storeInventory.getItems()) {
			if (item.reorder()) {
				for (int i = 0; i < item.getReorderAmount(); i++) {
					itemsToOrder.addItem(item);
				}
			}
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//2. Generate a manifest and load it back in.
		manifest = new Manifest(itemsToOrder);
		ExportManifest("./Files/test1.csv", manifest);
		LoadManifest("./Files/test1.csv", storeInventory, store);
		
		for (Item item : storeInventory.getItems()) {
			System.out.println(item.toString());
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//3. Load in sales_log_0.csv
		LoadSalesLog("./Files/sales_log_2.csv", storeInventory, store);
		
		itemsToOrder = new Stock();
		for (Item item: storeInventory.getItems()) {
			if (item.reorder()) {
				for (int i = 0; i < item.getReorderAmount(); i++) {
					itemsToOrder.addItem(item);
				}
			}
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//2. Generate a manifest and load it back in.
		manifest = new Manifest(itemsToOrder);
		ExportManifest("./Files/test1.csv", manifest);
		LoadManifest("./Files/test1.csv", storeInventory, store);
		
		for (Item item : storeInventory.getItems()) {
			System.out.println(item.toString());
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//3. Load in sales_log_0.csv
		LoadSalesLog("./Files/sales_log_3.csv", storeInventory, store);
		
		itemsToOrder = new Stock();
		for (Item item: storeInventory.getItems()) {
			if (item.reorder()) {
				for (int i = 0; i < item.getReorderAmount(); i++) {
					itemsToOrder.addItem(item);
				}
			}
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//2. Generate a manifest and load it back in.
		manifest = new Manifest(itemsToOrder);
		ExportManifest("./Files/test1.csv", manifest);
		LoadManifest("./Files/test1.csv", storeInventory, store);
		
		for (Item item : storeInventory.getItems()) {
			System.out.println(item.toString());
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//3. Load in sales_log_0.csv
		LoadSalesLog("./Files/sales_log_4.csv", storeInventory, store);
		
		itemsToOrder = new Stock();
		for (Item item: storeInventory.getItems()) {
			if (item.reorder()) {
				for (int i = 0; i < item.getReorderAmount(); i++) {
					itemsToOrder.addItem(item);
				}
			}
		}
		System.out.println(store.capitalToString());
		System.out.println("---------------------");
		
		//2. Generate a manifest and load it back in.
		manifest = new Manifest(itemsToOrder);
		ExportManifest("./Files/test1.csv", manifest);
		LoadManifest("./Files/test1.csv", storeInventory, store);

			
		//storeInventory.sortAlpha();
		for (Item item : storeInventory.getItems()) {
			System.out.println(item.toString());
		}
		*/
		System.out.println(store.capitalToString());
		
	}
	
	/**
	 * This method parses a file into a List of Items line by line
	 *
	 * @param  fileName  File location to read Item Properties from
	 * @return List of Items produces by the Item Properties Document
	 * @throws CSVFormatException 
	 * @throws StockException 
	 * @see Item
	 */
	public static List<Item> ImportItemProperties(String fileName, Stock storeInventory) throws IOException, CSVFormatException, StockException {
		List<Item> items = new ArrayList<>();
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				Item item = new Item(attributes);
				storeInventory.addItem(item);
				line = br.readLine();
			}
		} catch (IOException e) {
			throw new CSVFormatException("Import Item Properties Error");
		}
			
		
		return items;
	}
	
	/**
	 * This method parses a Sales Log and modifies the inventory of Items based 
	 * on the sales numbers.
	 *
	 * @param  fileName  File location of the Sales Log to be imported
	 * @throws CSVFormatException 
	 */
	public static void LoadSalesLog(String fileName, Stock storeInventory, Store store) throws CSVFormatException {
		double profit = 0;
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				for (Item item : storeInventory.getItems()) {
					if (item.getName().equals(attributes[0])) {
						for (int i = 0; i < Integer.parseInt(attributes[1]); i++) {
							profit += item.getSellPrice();
						}
						int qty = item.getQuantity() - Integer.parseInt(attributes[1]);
						item.setQuantity(qty);
					}
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			throw new CSVFormatException("Sales Log File Format Error");
		} catch (NumberFormatException e) {
			throw new CSVFormatException("Sales Log Value Error");
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new CSVFormatException("Sales Log Missing Values");
		}
		store.setCapital(store.getCapital() + profit);
	}
	
	
	/**
	 * This method parses a Manifest  and modifies the inventory of Items based 
	 * on the numbers associated with the item in the manifest.
	 *
	 * @param  fileName  File location of the Manifest to be imported
	 * @throws CSVFormatException 
	 * @throws DeliveryException 
	 */
	public static void LoadManifest(String fileName, Stock storeInventory, Store store) throws DeliveryException {
		
		double deduction = 0;
		boolean isColdTruck = false;
		
		Stock cargo = new Stock();
		
		Truck coldTruck = new RefrigeratedTruck(cargo);
		Truck ordinaryTruck = new OrdinaryTruck(cargo);
		
		List<Truck> incomingFleet = new ArrayList<>();
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			
			while (line != null) {
				if (line.equals(">Refrigerated")) {
					
					isColdTruck = true;
					
					cargo = new Stock();
					
					coldTruck = new RefrigeratedTruck(cargo);
					
					incomingFleet.add(coldTruck);
					
				} else if (line.equals(">Ordinary")) {
					
					isColdTruck = false;
					
					cargo = new Stock();
					
					ordinaryTruck = new OrdinaryTruck(cargo);
					
					incomingFleet.add(ordinaryTruck);
					
				} else {
					try {
						if (isColdTruck) {
							String[] attributes = line.split(",");
							for (Item item : storeInventory.getItems()) {
								if (item.getName().equals(attributes[0])) {
									for (int i = 0; i < Integer.parseInt(attributes[1]); i++) {
										coldTruck.cargo().addItem(item);
										deduction += item.getManufacturingCost();
									}
									int qty = item.getQuantity() + Integer.parseInt(attributes[1]);
									item.setQuantity(qty);
								}
							}
						} else  {
							String[] attributes = line.split(",");
							for (Item item : storeInventory.getItems()) {
								if (item.getName().equals(attributes[0])) {
									for (int i = 0; i < Integer.parseInt(attributes[1]); i++) {
										ordinaryTruck.cargo().addItem(item);
										deduction += item.getManufacturingCost();
									}
									int qty = item.getQuantity() + Integer.parseInt(attributes[1]);
									item.setQuantity(qty);
								}
							}
						}
					} catch (NumberFormatException e) {
						throw new DeliveryException("Import Manifest Error");
						
					}
					
				}
				
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		for (Truck truck : incomingFleet) {			
			deduction += truck.getCost();
		}
		
		store.setCapital(store.getCapital() - deduction );
	}
	
	public static void ExportManifest(String fileName, Manifest manifest) throws StockException, DeliveryException {
		List<Truck> fleet = manifest.getFleet();
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			
			for (Truck truck : fleet) {
				List<String> cargos = truck.getCargo();
			
				for (String output : cargos) {
					fileWriter.append(output + "\n");
				}
			}
			fileWriter.close();
		} catch (IOException e) {
			throw new DeliveryException("Export Manifest Error");
		}
	}
	
}
