package stockpredictor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.*;

public class J {
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
	
		        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
	
		        return sDate;
	
		    }
	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
			/*	
		    SimpleDateFormat displayTimeFormat = new SimpleDateFormat("HH:mm:ss");
	        SimpleDateFormat parseTimeFormat = new SimpleDateFormat("hh:mm a");
	        java.util.Date time = parseTimeFormat.parse("4:00 AM");
	        
	        SimpleDateFormat displayDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat parseDateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        java.util.Date date = parseDateFormat.parse("2/26/2016");
	        
	       // System.out.println(parseTimeFormat.format(time) + " = " + displayTimeFormat.format(time));
	        System.out.println(parseDateFormat.format(date)+ " = " + displayDateFormat.format(date));
	        */
		System.out.println(System.currentTimeMillis());
		String[] symbols = {"AAPL","GOOG","YHOO","TSLA","MSFT"};
		int cycleCounter=0;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
		SimpleDateFormat minFormat = new SimpleDateFormat("mm");
		//int hours=-1;
		//int minutes=-1;
		boolean flag = true;
		long oldTime = System.currentTimeMillis();
		long currTime;
		long counter=0;
		int oldCounter=0;
		
		do{
			
			
			
			for(long i=0; i<10000000.0; i++){}
			currTime=System.currentTimeMillis();
			//System.out.println("Current Time" + currTime);
			
			if(currTime-oldTime>5000){
				oldTime=currTime;
				counter++;
				
				cycleCounter++;
				if(cycleCounter>4){
					cycleCounter=0;
				}
				System.out.println(symbols[cycleCounter]+" " + counter);
			}
			
		}
		while(counter<10);
		/*
		while(flag){
			int hours = Integer.parseInt(hourFormat.format(calendar.getTime()));
			int minutes = Integer.parseInt(minFormat.format(calendar.getTime()));
		
			if(hours==3)
				if(minutes>43){
					System.exit(0);
					flag=false;
                }
		
			System.out.println(hours + "  " + minutes);
			System.out.println(System.currentTimeMillis());
			System.out.println(symbols[cycleCounter]);
			cycleCounter++;
			if(cycleCounter>4){
				cycleCounter=0;
			}
			Thread.sleep((long) 1000.0);
         }
	     */
	  
	     // System.out.println("INSERT INTO se_datacollect.realtimestockdata values (\"GOOG\", \"Microsoft\", 1.0, 2.0, 3.0,4.0,"+"\""+ displayDateFormat.format(date)+" " + displayTimeFormat.format(time) + "\""+")");
		
		//"2/26/2016"+" "+"4:00 PM"
		//System.out.println((new SimpleDateFormat("MM/dd/yyyy h:mm a")).parse("2/26/2016"+" "+"4:00 PM"));
		//java.sql.Date sqlDate= convertUtilToSql((new SimpleDateFormat("MM/dd/yyyy h:mm a")).parse("2/26/2016"+" "+"4:00 PM"));
		//SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
		
		//System.out.println(sqlDate);
		
		//String stockSymbol="MSFT";
		//getHistoricalData(stockSymbol);
		
		//FileOperations.writeToFile(stockSymbol+".cs/*v", "", getData(stockSymbol));
		/*URL url = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22MSFT%22)&env=store://datatables.org/alltableswithkeys&format=json");
		try (InputStream is = url.openStream();
				       JsonParser parser = Json.createParser(is)) {
				      while (parser.hasNext()) {
				          Event e = parser.next();
				          if (e == Event.KEY_NAME) {
				              switch (parser.getString()) {
				                  case "name":
				                      parser.next();
				                    System.out.print(parser.getString());
				                    System.out.print(": ");
				                    break;
				                case "message":
				                    parser.next();
				                    System.out.println(parser.getString());
				                    System.out.println("---------");
				                    break;
				             }
				         }
				     }
				 }
		*/
	

	}

	public static ArrayList<String> getHistoricalData(String symbol) {
		

		boolean exceptionOccurred = false;
		ArrayList<String> buffer = null;

		if (symbol != null) {
			try {

				buffer = new ArrayList<String>();
				
				String address = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"+symbol+"%22)&env=store://datatables.org/alltableswithkeys&format=csv";
				//String address = "http://ichart.finance.yahoo.com/table.csv?s="+symbol+"&a=06&b=9&c=1996&d=06&e=20&f=2010&g=d";
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

    public static ArrayList<String> getData(String symbol) {
		System.out.println("Jai Mata Di");

		boolean exceptionOccurred = false;
		ArrayList<String> buffer = null;

		if (symbol != null) {
			try {

				buffer = new ArrayList<String>();
				
				String address = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"+symbol+"%22)&env=store://datatables.org/alltableswithkeys&format=csv";
				//String address = "http://ichart.finance.yahoo.com/table.csv?s="+symbol+"&a=06&b=9&c=1996&d=06&e=20&f=2010&g=d";
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
