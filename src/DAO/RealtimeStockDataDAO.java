package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import TO.RealTimeStockDataTO;
import Utility.DatabaseConnector;

public class RealtimeStockDataDAO {
	private static Connection conn;
	public RealtimeStockDataDAO()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName(DatabaseConnector.getDriver()).newInstance();
		this.conn = DatabaseConnector.getDatabaseConnector();
		
	}
	
	public RealTimeStockDataTO inserData(RealTimeStockDataTO realTimeStockDataTO) {
		try {
			
			Statement st = conn.createStatement(); 
			System.out.println("INSERT INTO se_datacollect.realtimestockdata values ("+"\""+realTimeStockDataTO.getStockAcronym() +"\""+", "+ "\""+realTimeStockDataTO.getStockName() +"\""+","+ realTimeStockDataTO.getBookPrice()+", "+ realTimeStockDataTO.getVolume()+","+realTimeStockDataTO.getAsk()+","+realTimeStockDataTO.getBid()+"," +"\""+realTimeStockDataTO.getLastTradeTime()+"\""+","+realTimeStockDataTO.getLastTradePrice()+")");
			
			//st.executeUpdate("INSERT INTO se_datacollect.realtimestockdata values ("+"\""+realTimeStockDataTO.getStockAcronym() +"\""+", "+ "\""+realTimeStockDataTO.getStockName() +"\""+","+ realTimeStockDataTO.getBookPrice()+", "+ realTimeStockDataTO.getVolume()+","+realTimeStockDataTO.getAsk()+","+realTimeStockDataTO.getBid()+"," +"\""+realTimeStockDataTO.getLastTradeTime()+"\""+","+realTimeStockDataTO.getLastTradePrice()+")");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return realTimeStockDataTO;
	}
}
