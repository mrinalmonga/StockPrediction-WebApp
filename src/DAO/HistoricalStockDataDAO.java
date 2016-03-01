package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import TO.HistoricalStockDataTO;
import TO.RealTimeStockDataTO;
import Utility.DatabaseConnector;

public class HistoricalStockDataDAO {
	private static Connection conn;
	public HistoricalStockDataDAO()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName(DatabaseConnector.getDriver()).newInstance();
		this.conn = DatabaseConnector.getDatabaseConnector();
		
	}
	
	public HistoricalStockDataTO inserData(HistoricalStockDataTO historicalStockDataTO) {
		try {
			
			Statement st = conn.createStatement(); 
			//System.out.println("INSERT INTO se_datacollect.historicalstockdata values ("+"\""+ historicalStockDataTO.getStockAcronym()+"\""+ ","+ "\""+historicalStockDataTO.getDate()+"\""+","+ historicalStockDataTO.getOpen()+","+historicalStockDataTO.getHigh()+","+historicalStockDataTO.getLow()+","+historicalStockDataTO.getClose()+","+historicalStockDataTO.getVolume()+","+historicalStockDataTO.getAdj()+")");
			
			st.executeUpdate("INSERT INTO se_datacollect.historicalstockdata values ("+"\""+ historicalStockDataTO.getStockAcronym()+"\""+ ","+ "\""+historicalStockDataTO.getDate()+"\""+","+ historicalStockDataTO.getOpen()+","+historicalStockDataTO.getHigh()+","+historicalStockDataTO.getLow()+","+historicalStockDataTO.getClose()+","+historicalStockDataTO.getVolume()+","+historicalStockDataTO.getAdj()+")");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return historicalStockDataTO;
	}
}
