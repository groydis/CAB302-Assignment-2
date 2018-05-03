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
	String capital;
	
	public Store(String storeName, String capital) {
		this.storeName = storeName;
		this.capital = capital;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	public String getCapital() {
		return capital;
	}
	

	
	
	
	

}
