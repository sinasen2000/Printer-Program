/**
 * 
 */

/**
 * @author apollo11
 *
 */
public abstract class Printer {
	protected String brand;
	protected String model;
	protected int pagesPerMin;
	protected int price;

	/**
	 * Constructor
	 */
	public Printer(String brand, String model, int pagesPerMin, int price) {
		this.brand = brand;
		this.model = model;
		this.pagesPerMin = pagesPerMin;
		this.price = price;// TODO Auto-generated constructor stub
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the pagesPerMin
	 */
	public int getPagesPerMin() {
		return pagesPerMin;
	}

	/**
	 * @param pagesPerMin the pagesPerMin to set
	 */
	public void setPagesPerMin(int pagesPerMin) {
		this.pagesPerMin = pagesPerMin;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	public static Printer readFromLine(String line) {
		if(line.contains("COLOR_INKJET")) {
			return ColorInkjet.readFromLine(line);
		}else if(line.contains("BW_LASER")) {
			return BWLaser.readFromLine(line);
		}else if(line.contains("COLOR_LASER")) {
			return ColorLaser.readFromLine(line);
		}else {
			throw new IllegalArgumentException();
		}
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Printer)) {
			return false;
		}
		Printer other = (Printer) obj;
		if (brand == null) {
			if (other.brand != null) {
				return false;
			}
		} else if (!brand.equals(other.brand)) {
			return false;
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (pagesPerMin != other.pagesPerMin) {
			return false;
		}
		if (price != other.price) {
			return false;
		}
		return true;
	}

	/**
	 * will be overridden
	 */
	public abstract String toString();
}
