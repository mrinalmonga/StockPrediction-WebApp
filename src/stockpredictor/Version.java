package stockpredictor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Version {

	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());

        return sDate;

    }
    public static void main(String[] args) throws ParseException {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://stockpricedb.cmwfdsplbwyb.us-west-2.rds.amazonaws.com";
        String user = "stockpriceDB";
        String password = "stockpriceDB";

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
           
            SimpleDateFormat displayTimeFormat = new SimpleDateFormat("HH:mm:ss");
 	        SimpleDateFormat parseTimeFormat = new SimpleDateFormat("hh:mm a");
 	        java.util.Date time = parseTimeFormat.parse("4:00 AM");
 	        
 	        SimpleDateFormat displayDateFormat = new SimpleDateFormat("yyyy-MM-dd");
 	        SimpleDateFormat parseDateFormat = new SimpleDateFormat("MM/dd/yyyy");
 	        java.util.Date date = parseDateFormat.parse("2/26/2016");
 	        
 	        System.out.println(parseTimeFormat.format(time) + " = " + displayTimeFormat.format(time));
 	        System.out.println(parseDateFormat.format(date)+ " = " + displayDateFormat.format(date));
 	        
 	  
            System.out.println(st.executeUpdate("INSERT INTO se_datacollect.realtimestockdata values (\"JaiMataDi\", \"Microsoft\", 1.0, 2.0, 3.0,4.0,"+"\""+  displayDateFormat.format(date)+" " + displayTimeFormat.format(time) + "\""+")"));

           /* if (rs.next()) {
                System.out.println(rs.getString(3));
            }*/

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}

