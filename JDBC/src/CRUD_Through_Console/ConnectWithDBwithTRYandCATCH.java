package CRUD_Through_Console;

// these 3 packages are part of rt.jar means of JDK s/w
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ConnectWithDBwithTRYandCATCH {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		// 1. Load and register the Driver
		Driver driver = new Driver(); // Creating driver object for MySQLDB
		DriverManager.registerDriver(driver);

		// 2. Establish the Connection
		String url = "jdbc:mysql://localhost:3306/javaconnectiondb";
		String username = "root";
		String password = "root";
		try
		{
			connection = DriverManager.getConnection(url, username, password);
			if(connection != null)
			{
				// 3. Create a Statement Object
				statement = connection.createStatement();
			}
			if(statement != null)
			{
				// 4. Sending and execute the Query
				String sqlSelectQuery = "select sid,sname,sage,saddress from student";
				resultSet = statement.executeQuery(sqlSelectQuery);
				if(resultSet != null)
				{
					// 5. Process the result from ResultSet
					System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
					while (resultSet.next())
					{
						Integer id = resultSet.getInt("sid"); // (1)
						String name = resultSet.getString("sname"); // (2)
						Integer age = resultSet.getInt("sage"); // (3)
						String address = resultSet.getString("saddress"); // (4)
						System.out.println(id + "\t" + name + "\t" + age + "\t" + address);
					}
				}
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 6. Close all.
			if(resultSet != null)
			{
				resultSet.close();
			}
			if(statement != null)
			{
				statement.close();
			}
			if(connection != null)
			{
				connection.close();
			}
		}
	}
}