package DatabaseService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection connection;

	private static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aploHospital", "root", "Harshdeep@000");

		System.out.println("Database connection created successfully.");

		return connection;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			return createConnection();
		}

		return connection;
	}
}