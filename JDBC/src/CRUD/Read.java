package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Read {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public void getRead() throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		String url = "jdbc:mysql://localhost:3306/javaconnectiondb";
		String username = "root";
		String password = "root";
		
		try
		{
			connection = DriverManager.getConnection(url, username, password);
			if(connection != null)
			{
				statement = connection.createStatement();
			}
			if(statement != null)
			{
				String sqlSelectQuery = "select sid,sname,sage,saddress from student";
				resultSet = statement.executeQuery(sqlSelectQuery);
				if(resultSet != null)
				{
					System.out.println("ID\tNAME\tAGE\tADDRESS");
					while (resultSet.next())
					{
						Integer id = resultSet.getInt("sid");
						String name = resultSet.getString("sname");
						Integer age = resultSet.getInt("sage");
						String address = resultSet.getString("saddress");
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
