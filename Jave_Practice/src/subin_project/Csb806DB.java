package subin_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Csb806DB {

	String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String userid = "scott";
	static String passwd = "tiger";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, userid, passwd);
	}
}
