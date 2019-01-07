/**
 * 
 */

/**
 * @author apollo11
 *
 */
public class BWLaser extends Printer {

	/**
	 * @param brand
	 * @param model
	 * @param pagesPerMin
	 * @param price
	 */
	public BWLaser(String brand, String model, int pagesPerMin, int price) {
		super(brand, model, pagesPerMin, price);
		// TODO Auto-generated constructor stub
	}

	public static Printer readFromLine(String line) {
		String[] splitLine = line.split(", ");
		String brand = splitLine[0].replace("BW_LASER ", "");
		int pagesPerMin = Integer.parseInt(splitLine[2]);
		int price = Integer.parseInt(splitLine[3].replace(" euros", ""));
		return new BWLaser(brand, splitLine[1], pagesPerMin, price);
	}
	
	
	
	/* (non-Javadoc)
	 * @see Printer#toString()
	 */
	@Override
	public String toString() {
		return "BW_LASER " + brand + ", " + model + ", " +
				  + pagesPerMin + ", " + price + " euros\n";

	}

}
