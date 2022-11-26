package CRUD_Through_Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class BasicDBConnectivity {
	public static void main(String[] args) throws SQLException {

		// 1. Load and register the Driver
		Driver driver = new Driver(); // Creating driver object for MySQLDB
		DriverManager.registerDriver(driver);
		System.out.println("Driver registered succesfully");

		// 2. Establish the Connection
		String url = "jdbc:mysql://localhost:3306/javaconnectiondb";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection object is created:: " + connection);

		// 3. Create a Statement Object
		Statement statement = connection.createStatement();
		System.out.println("Statement object is created:: " + statement);

		// 4. Sending and execute the Query
		String sqlSelectQuery = "select sid,sname,sage,saddress from student";
		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		System.out.println("ResultSet object is created:: " + resultSet);

		// 5. Process the result from ResultSet
		System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
		while (resultSet.next()) {
			Integer id = resultSet.getInt("sid"); // (1)
			String name = resultSet.getString("sname"); // (2)
			Integer age = resultSet.getInt("sage"); // (3)
			String address = resultSet.getString("saddress"); // (4)
			System.out.println(id + "\t" + name + "\t" + age + "\t" + address);
		}

		// 6. Close all. Opened at first, should be closed at the end. This order must
		// be maintained
		resultSet.close(); // number 3 opening
		statement.close(); // number 2 opening
		connection.close(); // number 1 opening
		System.out.println("Closing all...");

	}

}
