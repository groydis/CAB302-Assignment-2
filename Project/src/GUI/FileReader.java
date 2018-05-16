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
import Stock.Item;
import Stock.Stock;

/**
 * @author Greyden Scott
 *
 */
public class FileReader {
	private static Stock storeInventory;
	
	public static void main(String... args) throws IOException {
		storeInventory = new Stock(ReadItemProperties("./Files/item_properties.csv"));
		for (Item i: storeInventory.inventory()) {
			System.out.println(i.toString());
		}
		
		LoadSalesLog("./Files/sales_log_3.csv", storeInventory);
		for (Item i: storeInventory.inventory()) {
			System.out.println(i.toString());
		}
		
		Manifest manifest = new Manifest(storeInventory.inventory());
		manifest.GenerateManifest();
		WriteFile(manifest.manifest(), "./Files/test.csv");
		/*
		LoadManifest(Stock storeInventory, "./Files/manifest.csv");
		for (Item i: storeInventory.inventory()) {
			System.out.println(i.toString());
		}
		*/
	}
	
	/**
	 * This method parses a file into a List of Items line by line
	 *
	 * @param  fileName  File location to read Item Properties from
	 * @return List of Items produces by the Item Properties Document
	 * @see Item
	 */
	public static List<Item> ReadItemProperties(String fileName) throws IOException {
		List<Item> items = new ArrayList<>();
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				Item item = Item.CreateItem(attributes);
				items.add(item);
				
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return items;
	}
	
	/**
	 * This method parses a Sales Log and modifies the inventory of Items based 
	 * on the sales numbers.
	 *
	 * @param  fileName  File location of the Sales Log to be imported
	 */
	public static void LoadSalesLog(String fileName, Stock storeInventory) {
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				storeInventory.updateSales(attributes);
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * This method parses a Manifest  and modifies the inventory of Items based 
	 * on the numbers associated with the item in the manifest.
	 *
	 * @param  fileName  File location of the Manifest to be imported
	 */
	public static void LoadManifest(Stock storeInventory, String fileName) {

		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				for (Item item : storeInventory.inventory()) {
					
					if (item.name().equals(attributes[0])) {
						
						storeInventory.updateSales(attributes);
					}
				}
				
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void WriteFile(List<String> file, String path) {
		try {
			FileWriter fileWriter = new FileWriter(path);
			for(String item: file) {
				fileWriter.append(item + "\n");
			}
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
