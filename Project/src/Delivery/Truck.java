package Delivery;
/** 
 * 
 * @author Greyden Scott
 *
 */

import java.util.List;

abstract public class Truck {
	
	public Truck() {
		
	}
	
	public abstract int GetCapacity();
		
	public abstract double GetCost();
	
	public abstract List<String> GetCargo();
		

}
