package stockpredictor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONObject;

import DAO.RealtimeStockDataDAO;
import TO.RealTimeStockDataTO;

public class StockURLReader {
	public static void main(String[] args) throws IOException {
		int counter = 0;
		long oldTime = System.currentTimeMillis();
		long currTime;
		String[] symbols = {"AAPL","GOOG","YHOO","TSLA","MSFT"};
		int cycleCounter=0;
		
		System.out.println("Jai Mata Di");
		do{
				
		boolean exceptionOccurred = false;
		ArrayList<String> buffer = null;

		if (symbols[cycleCounter] != null) {
			try {
                System.out.println("SYMBOL  =  " + symbols[cycleCounter]);
				buffer = new ArrayList<String>();

				String address = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quotes%20where%20symbol%20in%20(%22"
						+ symbols[cycleCounter] + "%22)&env=store://datatables.org/alltableswithkeys&format=json";
				URL pageLocation = new URL(address);
				URLConnection urlConn = pageLocation.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
				String inputLine;
				RealTimeStockDataTO realTimeStockDataTO;
				RealtimeStockDataDAO realtimeStockDataDAO = new RealtimeStockDataDAO();
				while ((inputLine = in.readLine()) != null) {
					// System.out.println(inputLine);
					JSONObject json = new JSONObject(inputLine);
					JSONObject quote = (JSONObject) ((JSONObject) ((JSONObject) json.get("query")).get("results")).get("quote");
					//JSONObject quote = (JSONObject)((JSONObject)((JSONObject)json.get("query")).get("results")).get("quote");
					realTimeStockDataTO = new RealTimeStockDataTO();
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					
					realTimeStockDataTO.setBookPrice(Double.parseDouble(quote.get("PriceBook").toString()));
					realTimeStockDataTO.setAsk(Double.parseDouble(quote.getString("Ask").toString()));
					realTimeStockDataTO.setBid(Double.parseDouble(quote.getString("Bid").toString()));
					realTimeStockDataTO.setStockName(quote.getString("Name").toString());
					realTimeStockDataTO.setStockAcronym(quote.getString("Symbol").toString());
					realTimeStockDataTO.setVolume(Double.parseDouble(quote.getString("Volume").toString()));
					
					SimpleDateFormat displayTimeFormat = new SimpleDateFormat("HH:mm:ss");
		 	        SimpleDateFormat parseTimeFormat = new SimpleDateFormat("hh:mma");
		 	        java.util.Date time = parseTimeFormat.parse(quote.getString("LastTradeTime").toString());
		 	        
		 	        SimpleDateFormat displayDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 	        SimpleDateFormat parseDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		 	        java.util.Date date = parseDateFormat.parse(quote.getString("LastTradeDate").toString());

					realTimeStockDataTO.setLastTradeTime(displayDateFormat.format(date)+" "+displayTimeFormat.format(time));					
					realTimeStockDataTO.setLastTradePrice(Double.parseDouble(quote.getString("LastTradePriceOnly").toString()));
					
					
					
					realTimeStockDataTO = realtimeStockDataDAO.inserData(realTimeStockDataTO);
					//System.out.println(quote);
				}
				in.close();
			} catch (Exception e) {
				exceptionOccurred = true;
				e.printStackTrace();
			} finally {
				if (!exceptionOccurred) {
					//System.out.println("Operation SUCCESSFUL ");
				} else {
					System.out.println(
							"Operation UNSUCCESSFUL - An EXCEPTION occurred - Method Name - getHistoricalData(String symbol)");
				}
			}
		}
	  
		for(long i=0; i<90000000.0; i++){}
		currTime=System.currentTimeMillis();
		//System.out.println("Current Time" + currTime);
		
		if(currTime-oldTime>3000){
			oldTime=currTime;
			counter++;
			
			cycleCounter++;
			if(cycleCounter>4){
				cycleCounter=0;
			}
			System.out.println(symbols[cycleCounter]+" " + counter);
		}
		}while(counter<30000);
	
	}
}
