package Stock;

import java.text.DecimalFormat;

/** 
 * 
 * @author Greyden Scott
 *
 */

public class Store {
	
	private String storeName;
	private double capital;
	
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
		return this.capital;
	}
	
	public String capitalToString() {
		DecimalFormat decimalFormat = new DecimalFormat("#00,000.00");
		String capital = decimalFormat.format(this.capital);
		return capital;
	}
	

	
	
	
	

}
