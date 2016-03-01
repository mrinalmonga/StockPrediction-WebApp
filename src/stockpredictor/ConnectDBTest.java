package stockpredictor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Utility.DatabaseConnector;


public class ConnectDBTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName(DatabaseConnector.getDriver()).newInstance();
			Connection conn = DatabaseConnector.getDatabaseConnector();
			Statement st = conn.createStatement(); 
			ResultSet res = st.executeQuery("SELECT @@version from dual");
			while(res.next()){
				String out = res.getString(1);
				System.out.println(out);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
