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

/**
 * @author Greyden Scott
 *
 */
public class ItemFileReader {
	
	public static void main(String... args) throws IOException {
		List<Item> items = test();
		for (Item i: items) {
			System.out.println(i.toString());
		}
	}
	
	public static List<Item> test() throws IOException {
		String fileName = "./Files/item_properties.csv";
		List<Item> items = new ArrayList<>();
		
		Path pathToFile = Paths.get(fileName);
		
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			
			String line = br.readLine();
			
			while (line != null) {
				String[] attributes = line.split(",");
				Item item = createItem(attributes);
				items.add(item);
				
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return items;
		
		
	}
	private static Item createItem(String[] data) {

		String itemName = data[0];
		double manufacturingCost = Double.parseDouble(data[1]);
		double sellPrice = Double.parseDouble(data[2]);
		int reorderPoint = Integer.parseInt(data[3]);
		int reorderAmount = Integer.parseInt(data[4]);
		double storageTemp = 0;
		if (data.length == 6) {
			storageTemp = Double.parseDouble(data[5]);
		}
		
		return new Item(itemName, manufacturingCost, sellPrice, reorderPoint, reorderAmount, storageTemp);
	}
	
}
