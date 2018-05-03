package GUI;
import java.io.File;
import java.util.Scanner;


/**
 * @author Greyden Scott
 *
 */
public class ItemFileReader {
	
	public static void openFile() throws Exception {
		String fileName = "./Files/item_properties.csv";
		Scanner scanner = new Scanner(new File(fileName));
		scanner.useDelimiter(",");
		while(scanner.hasNext()) {
			System.out.print(scanner.next() + " | ");
		}
		scanner.close();
	}
	
}
