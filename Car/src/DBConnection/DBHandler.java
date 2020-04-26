package DBConnection;

import java.sql.*;
public class DBHandler extends Configs {

	Connection myConn;
	
	public Connection getConnection() {
		
		try {
			myConn = DriverManager.getConnection(SQLInfo.dbURL,SQLInfo.dbId,SQLInfo.dbPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myConn;
	}
}
