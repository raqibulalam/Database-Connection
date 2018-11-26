
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
public class SQLConnection {
 static Connection conn;
 public static Connection ConnecrDB() {
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1","root","");
		 
		// JOptionPane.showMessageDialog(null, "Connected");
		 return conn;
		 
	 } catch(Exception e) {
		 JOptionPane.showMessageDialog(null, "Not Connected");
		 return null;
	 }
	 
 }

}
