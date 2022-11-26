package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	private Connection connection = null;
	private Statement statement = null;
	
	public void doUpdate() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/javaconnectiondb";
		String username = "root";
		String password = "root";
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the ID of the column, whose values you want to UPDATE :");
		int id = scn.nextInt();
		
		System.out.println("Enter the AGE :");
		int age = scn.nextInt();

		System.out.println("Enter the NAME :");
		String name = scn.next();

		System.out.println("Enter the ADDRESS :");
		String address = scn.next();

		try
		{
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null)
			{
				statement = connection.createStatement();
				if (statement != null)
				{
					String updateSqlQuery = String.format("update student set `sname`='%s',`sage`=%d,`saddress`='%s' where `sid`=%d", name, age, address, id);
//					String updateSqlQuery = "UPDATE student SET sname=\"Virat Kohli\",sage = 36,saddress=\"Noida\" WHERE sid= 18";
//					String.format("insert into student(`sname`,`sage`,`saddress`) values ('%s',%d,'%s')", sname, sage, saddress);
					int noOfRows = statement.executeUpdate(updateSqlQuery);
					System.out.println("No of rows updated is :: " + noOfRows);
				}
			}
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (statement != null)
			{
				statement.close();
			}
			if (connection != null)
			{
				connection.close();
			}
		}
	}
}
