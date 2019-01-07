import java.util.*;
import java.io.*;
/**
 * @author apollo11
 *the class that holds the lists of printers
 */
public class PrinterList {
	private List<Printer> printerList;
	/**
	 * 
	 */
	public PrinterList() {
		this.printerList = new ArrayList<Printer>();
	}
	/**
	 * @return the printerList
	 */
	public List<Printer> getPrinterList() {
		return printerList;
	}
	/**
	 * @param printerList the printerList to set
	 */
	public void setPrinterList(List<Printer> printerList) {
		this.printerList = printerList;
	}
	public synchronized void add(Printer printerToAdd) {
		printerList.add(printerToAdd);
	}
	public synchronized void sort(Comparator<Printer> comparator) {
		Collections.sort(this.printerList, comparator);
	}
	public static PrinterList readFromScanner(Scanner scanner) {
		PrinterList result = new PrinterList();
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			result.add(Printer.readFromLine(line));
		}
		return result;
	}
	public static PrinterList readFromFile(String fileName) throws FileNotFoundException{
		return PrinterList.readFromScanner(new Scanner(new File(fileName)));
	}
	public void writeToFile(String fileName) throws IOException{
		Writer writer = new FileWriter(fileName);
		writer.write(this.toString());
		writer.close();
	}
	
	/**
	 * @override
	 */
	public String toString() {
		String res = "";
		for(int i = 0; i < printerList.size(); i++) {
			res += printerList.get(i).toString();
		}
		return res;
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
		if (!(obj instanceof PrinterList)) {
			return false;
		}
		PrinterList other = (PrinterList) obj;
		if (printerList == null) {
			if (other.printerList != null) {
				return false;
			}
		} else if (!printerList.equals(other.printerList)) {
			return false;
		}
		return true;
	}
	

}
