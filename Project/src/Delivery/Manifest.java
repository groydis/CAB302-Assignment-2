package Delivery;

import java.util.ArrayList;
import java.util.List;

import Stock.Item;
import Stock.Stock;
import Stock.Store;

/** 
 * 
 * @author Greyden Scott
 *
 */
public class Manifest {
	List<String> manifest;

	// Creates a manifest from the provided inventory
	public Manifest(List<Item> inventory) {
		this.manifest = new ArrayList<>();
	}
	
	
	public void ReadManifest(List<String> manifestRecieved) {
		
	}
	
	// Creates a manifest from the provided inventory
	public List<String>  GenerateManifest(List<Item> inventory) {
		for (Item item: inventory) {
			if (item.reorder()) {
				add(item, item.reorderammount());
			}
		}
		return manifest;
	}
	
	// Adds an item to the manifest as a String
	public void add(Item item, int qty) {
		String manifestItem;
		manifestItem = item.name() + "," + qty;
		manifest.add(manifestItem);
	}
	
	// Removes all items form Manifest
	public void clear() {
		manifest.clear();
	}
}
