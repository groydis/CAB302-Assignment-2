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
	List<String> coldStorage;
	List<String> storage;
	List<Item> inventory;

	/**
	 * Constructs a Manifest and initializes manifest, coldStorage and storage lists.
	 *
	 * @param  inventory  List of items
	 */
	public Manifest(List<Item> inventory) {
		this.manifest = new ArrayList<>();
		this.coldStorage = new ArrayList<>();
		this.storage = new ArrayList<>();
		this.inventory = inventory;
	}
	
	
	public void ReadManifest(List<String> manifestRecieved) {
		
	}
	
	/**
	 * Returns a List populated with manifest items categorized by whether
	 * the items need to be transported in a Refrigerated Truck or Ordinary Truck.
	 *
	 * @param  inventory  List of items
	 * @return      List<String> of a manifest to be processed into a .csv file
	 */
	public List<String>  GenerateManifest() {
		for (Item item: inventory) {
			if (item.reorder()) {
				System.out.println(item.name() + " on list");
				add(item, item.reorderamount());
			} else {
				System.out.println(item.name() + " " + item.reorderpoint() + " " + item.quantity());
			}
		}
		manifest.add(">Refrigerated");
		for (String item: coldStorage) {
			manifest.add(item);
		}
		manifest.add(">Ordinary");
		for (String item: storage) {
			manifest.add(item);
		}
		return manifest;
	}
	
	/**
	 * This method adds an item to a one of two list's depending on it's 
	 * storage temperature.
	 *
	 * @param item  Item to be added to manifest
	 * @param qty	number of items to be associated with the item being added
	 */
	public void add(Item item, int qty) {
		String manifestItem;
		manifestItem = item.name() + "," + qty;
		if (item.storageTemp() <= 10) {
			coldStorage.add(manifestItem);
		} else {
			storage.add(manifestItem);
		}
	}
	
	public List<String> manifest() {
		return this.manifest;
	}
	
	/**
	 * This method removes all items from the manifest, coldStorage and 
	 * storage List's.
	 *
	 */
	public void clear() {
		coldStorage.clear();
		storage.clear();
		manifest.clear();
	}
}
