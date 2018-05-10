package Stock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;


/** 
 * 
 * @author Greyden Scott
 *
 */

public class Store {
	
	String storeName;
	double capital;
	
	public Store(String storeName, double capital) {
		this.storeName = storeName;
		this.capital = capital;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setCapital(double capital) {
		this.capital = capital;
	}
	
	public double getCapital() {
		return capital;
	}
	

	
	
	
	

}
