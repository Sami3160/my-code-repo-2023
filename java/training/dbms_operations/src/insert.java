
import java.sql.*;
public class insert {
	public static void main(String args[]) {
		String url="jdbs::mysql//localhost:3555/training";
		String username="samiii";
		String pass="root";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection con=new DriverManager.getConnection();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}


