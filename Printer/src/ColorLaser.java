/**
 * 
 */

/**
 * @author apollo11
 *
 */
public class ColorLaser extends Printer {
	private int colorNumber;
	/**
	 * @param brand
	 * @param model
	 * @param pagesPerMin
	 * @param price
	 */
	public ColorLaser(String brand, String model, int colorNumber, int pagesPerMin, int price) {
		super(brand, model, pagesPerMin, price);
		this.colorNumber = colorNumber;
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @return the colorNumber
	 */
	public int getColorNumber() {
		return colorNumber;
	}


	/**
	 * @param colorNumber the colorNumber to set
	 */
	public void setColorNumber(int colorNumber) {
		this.colorNumber = colorNumber;
	}
	

	public static Printer readFromLine(String line) {
		String[] splitLine = line.split(", ");
		String brand = splitLine[0].replace("COLOR_LASER ", "");
		int colorNumber = Integer.parseInt(splitLine[2]);
		int pagesPerMin = Integer.parseInt(splitLine[3]);
		int price = Integer.parseInt(splitLine[4].replace(" euros", ""));
		return new ColorLaser(brand, splitLine[1], colorNumber, pagesPerMin, price);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof ColorLaser)) {
			return false;
		}
		ColorLaser other = (ColorLaser) obj;
		if (colorNumber != other.colorNumber) {
			return false;
		}
		return true;
	}


	/* (non-Javadoc)
	 * @see Printer#toString()
	 */
	@Override
	public String toString() {
		return "COLOR_LASER " + brand + ", " + model + ", " + colorNumber +
				", " + pagesPerMin + ", " + price + " euros\n";
	}

}
