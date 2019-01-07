import java.util.*;
import java.io.*;
/**
 * 
 */

/**
 * @author apollo11
 *
 */
public class Sorter extends Thread {
	private PrinterList printerList;
	private	Comparator<Printer> comparator;
	/**
	 * 
	 */
	public Sorter(PrinterList printerList, Comparator<Printer> comparator) {
		this.comparator = comparator;
		this.printerList = printerList;// TODO Auto-generated constructor stub
	}

	/**
	 * @return the printerList
	 */
	public PrinterList getPrinterList() {
		return printerList;
	}

	/**
	 * @param printerList the printerList to set
	 */
	public void setPrinterList(PrinterList printerList) {
		this.printerList = printerList;
	}

	/**
	 * @return the comparator
	 */
	public Comparator<Printer> getComparator() {
		return comparator;
	}

	/**
	 * @param comparator the comparator to set
	 */
	public void setComparator(Comparator<Printer> comparator) {
		this.comparator = comparator;
	}
	public void run() {
		System.out.println("Sorting started, this may take a while.");
		printerList.sort(comparator);
		System.out.println("Sorting done.\n" + printerList);
	}
	
}
