package stockpredictor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class J {
	public static void main(String[] args) throws IOException {
				

		

		
		String stockSymbol="TSLA";
		FileOperations.writeToFile(stockSymbol+".csv", "", getHistoricalData(stockSymbol));

		
	

	}

	public static ArrayList<String> getHistoricalData(String symbol) {
		

		boolean exceptionOccurred = false;
		ArrayList<String> buffer = null;

		if (symbol != null) {
			try {

				buffer = new ArrayList<String>();
				
				//String address = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"+symbol+"%22)&env=store://datatables.org/alltableswithkeys&format=json";
				String address = "http://ichart.finance.yahoo.com/table.csv?s=MSFT&a=06&b=9&c=1996&d=06&e=20&f=2010&g=d";
				URL pageLocation = new URL(address);
				Scanner in = new Scanner(pageLocation.openStream());

				System.out.println("Data for " + symbol);
				while (in.hasNext()) {

					String line = in.next();
					buffer.add(line);
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
		} else {
			System.out.println("Operation UNSUCCESSFUL - symbol is NULL");
		}
		return buffer;
	}

}
