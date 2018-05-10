package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Stock.Item;
import Stock.Stock;

/**
 * @author Greyden Scott
 *
 */
public class FileReader {
	
	public static void main(String... args) throws IOException {
		List<Item> items = ReadItemProperties();
		for (Item i: items) {
			System.out.println(i.toString());
		}
	}
	
	public static List<Item> ReadItemProperties() throws IOException {
		String fileName = "./Files/item_properties.csv";
		List<Item> items = new ArrayList<>();
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				Item item = Item.createItem(attributes);
				items.add(item);
				
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return items;
	}
	
	public static void LoadSalesLog(String fileName) {
		List<String> sales = new ArrayList<>();
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				
				Stock.updateInventory(attributes);
				
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
