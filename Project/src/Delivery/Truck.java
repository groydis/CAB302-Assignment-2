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
	
	public abstract int Capacity();
		
	public abstract double Cost();
	
	public abstract List<String> GetCargo();
		

}
