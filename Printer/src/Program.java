import java.util.*;
import java.io.*;
/**
 * 
 */

/**
 * @author apollo11
 *
 */
public class Program {
	static PrinterList printerList;
	static String fileName;
	static Scanner scanner;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to PrintIn!");
		try {
			fileName = args[0];
			printerList = PrinterList.readFromFile(fileName);	
		}catch(IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Write the name of the file in the command line argument");
			System.exit(0);
		}
		
		scanner = new Scanner(System.in);
		int input = 0;
		while(true) {
			System.out.println("Please choose one: (Only type the number)");
			System.out.println("1 - Show the entire PrintIt catalogue\n2 – Add a new BW laser printer\n3 – Add a new color laser printer\n"
					+ "4 – Add a new inkjet printer\n5 - Show the entire PrintIt catalogue sorted by type of printer\n6 – Show the entire PrintIt catalogue sorted by brand\n" + 
					"(alphabetically)\n7 – Write to file\n8 – Stop the program");
			
		try {
			input = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Write a number in correct format");
		}
		switch(input) {
		case 1:
			System.out.println(printerList);
			break;
		case 2:	
			addBWLaser();
			break;
		case 3:
			addColorLaser();
			break;
		case 4:
			addInkjet();
			break;
		case 5: 
			sortByType();
			break;
		case 6:
			sortByBrand();
			break;
		case 7: 
			writeToFile();
			break;
		case 8:
			quitProgram();
			break;
		default:
			throw new IllegalArgumentException();
		}
		
		
		}
	}
public static void addBWLaser() {
	System.out.println("Please write the following properties");
	System.out.println("Brand:");
	String brand = scanner.nextLine();
	System.out.println("Model");
	String model = scanner.nextLine();
	System.out.println("Number of pages it can print per minute:");
	int pagesPerMin = Integer.parseInt(scanner.nextLine());
	System.out.println("Price:");
	int price = Integer.parseInt(scanner.nextLine());
	printerList.add(new BWLaser(brand, model, pagesPerMin, price));
}
public static void addColorLaser() {
	System.out.println("Please write the following properties");
	System.out.println("Brand:");
	String brand = scanner.nextLine();
	System.out.println("Model");
	String model = scanner.nextLine();
	System.out.println("Number of ink colors");
	int colorNumber = Integer.parseInt(scanner.nextLine());
	System.out.println("Number of pages it can print per minute:");
	int pagesPerMin = Integer.parseInt(scanner.nextLine());
	System.out.println("Price:");
	int price = Integer.parseInt(scanner.nextLine());
	printerList.add(new ColorLaser(brand, model, colorNumber, pagesPerMin, price));
}
public static void addInkjet() {
	System.out.println("Please write the following properties");
	System.out.println("Brand:");
	String brand = scanner.nextLine();
	System.out.println("Model");
	String model = scanner.nextLine();
	System.out.println("Number of ink colors");
	int colorNumber = Integer.parseInt(scanner.nextLine());
	System.out.println("Does all color ink cartridges need to be replaced at once(Type Yes/YES or No/NO");
	String cartridges = scanner.nextLine();
	System.out.println("Number of pages it can print per minute:");
	int pagesPerMin = Integer.parseInt(scanner.nextLine());
	System.out.println("Price:");
	int price = Integer.parseInt(scanner.nextLine());
	printerList.add(new ColorInkjet(brand, model, colorNumber, cartridges, pagesPerMin, price));
}

/**
 * Sorts the list by type 
 */
public static void sortByType() {
	new Sorter(printerList, new Comparator<Printer>() {
		public int compare(Printer arg0,Printer arg1) {
			return arg0.getClass().toString().compareTo(arg1.getClass().toString());
		}
	}).start();
}
/**
 * sorts the list by brand
 */
public static void sortByBrand() {
	new Sorter(printerList, new Comparator<Printer>() {
		public int compare(Printer arg0, Printer arg1) {
			return arg0.getBrand().compareTo(arg1.getBrand());
		}
	}).start();
}

/**
 * writes the list back to file
 */
public static void writeToFile() {
	try {
		printerList.writeToFile(fileName);
	}catch(IOException e) {
		e.printStackTrace();
	}
}
/**
 * quits the program
 */
public static void quitProgram() {
	System.out.println("Program closed. Thanks for choosing PrintIt!");
	scanner.close();
	System.exit(0);
}
}
