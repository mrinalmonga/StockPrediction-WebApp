package stockpredictor;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class HistoricalDataReader {

	public static void main(String[] args) {

		boolean exceptionOccurred = false;
		ArrayList<String> buffer = null;
		String[] symbols = {"AAPL","GOOG","YHOO","TSLA","MSFT"};
		
		for(int cycleCounter=0; cycleCounter<symbols.length; cycleCounter++){
			
		if (symbols[cycleCounter] != null) {
			try {

				buffer = new ArrayList<String>();
				
				String address = "http://ichart.finance.yahoo.com/table.csv?s="+symbols[cycleCounter]+"&a=01&b=1&c=1996&d=06&e=29&f=2016&g=d";
				URL pageLocation = new URL(address);
				Scanner in = new Scanner(pageLocation.openStream());

				System.out.println("Data for " + symbols[cycleCounter]);
				while (in.hasNext()) {

					String line = in.next();
					if(!line.equalsIgnoreCase("close")){
					   buffer.add(line);
					}
					System.out.println(line);
				}
			} catch (Exception e) {
				exceptionOccurred = true;
				e.printStackTrace();
			} finally {
				if (!exceptionOccurred) {
					System.out.println("Operation SUCCESSFUL - Method Name - getHistoricalData(String symbol) ");
				} else {
					System.out.println("Operation UNSUCCESSFUL - An EXCEPTION occurred - Method Name - getHistoricalData(String symbol)");
				}
			}
			
			FileOperations.writeToFile(symbols[cycleCounter]+".csv", "", buffer);
		} else {
			System.out.println("Operation UNSUCCESSFUL - symbol is NULL");
		}
	}
		
	}
}
