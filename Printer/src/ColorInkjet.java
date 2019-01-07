/**
 * 
 */

/**
 * @author apollo11
 *
 */
public class ColorInkjet extends Printer {
	private int colorNumber;
	private String cartridgesAtOnce;
	
	/**
	 * @param brand brand of the printer
	 * @param model model of the printer
	 * @param pagesPerMin printable pages in a minute
	 * @param price price of the printer
	 */
	public ColorInkjet(String brand, String model, int colorNumber, String cartridgesAtOnce, int pagesPerMin, int price) {
		super(brand, model, pagesPerMin, price);
		this.colorNumber = colorNumber;
		this.cartridgesAtOnce = cartridgesAtOnce;
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



	/**
	 * @return the cartridgesAtOnce
	 */
	public String getCartridgesAtOnce() {
		return cartridgesAtOnce;
	}



	/**
	 * @param cartridgesAtOnce the cartridgesAtOnce to set
	 */
	public void setCartridgesAtOnce(String cartridgesAtOnce) {
		this.cartridgesAtOnce = cartridgesAtOnce;
	}
	
	/**
	 * 
	 * @param line line to be read
	 * @return
	 */
	public static Printer readFromLine(String line) {
		String[] splitLine = line.split(", ");
		String brand = splitLine[0].replace("COLOR_INKJET ", "");
		int colorNumber = Integer.parseInt(splitLine[2]);
		String cartridgesAtOnce = "";
		if(cartridgesAtOnce.contains("YES")|| cartridgesAtOnce.contains("Yes")){
			cartridgesAtOnce += "TRUE";
		}else if(cartridgesAtOnce.contains("NO")|| cartridgesAtOnce.contains("No")){
			cartridgesAtOnce += "FALSE";
		}
		int pagesPerMin = Integer.parseInt(splitLine[4]);
		int price = Integer.parseInt(splitLine[5].replace(" euros", ""));
		return new ColorInkjet(brand, splitLine[1], colorNumber, cartridgesAtOnce, pagesPerMin, price);
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
		if (!(obj instanceof ColorInkjet)) {
			return false;
		}
		ColorInkjet other = (ColorInkjet) obj;
		if (cartridgesAtOnce == null) {
			if (other.cartridgesAtOnce != null) {
				return false;
			}
		} else if (!cartridgesAtOnce.equals(other.cartridgesAtOnce)) {
			return false;
		}
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
		return "COLOR_INKJET " + brand + ", " + model  + ", " + colorNumber + ", "
		  + cartridgesAtOnce + ", " + pagesPerMin + ", " + price + " euros\n";
		
	}

}
