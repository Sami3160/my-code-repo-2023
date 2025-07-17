import java.sql.*;
public class DBInit {
	public static Connection getConnection() throws SQLException {
		String url="jdbc::mysql//localhost:3306/training";
		String username="samiii";
		String pass="root";
//		Class.forName("com.mysql.cj.jdbc.driver");
		return DriverManager.getConnection(url, username, pass);
	}
}
