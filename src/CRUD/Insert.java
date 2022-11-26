package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {
	private Connection connection = null;
	private Statement statement = null;

	public void doInsert() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/javaconnectiondb";
		String username = "root";
		String password = "root";
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the AGE :");
		int sage = scn.nextInt();

		System.out.println("Enter the NAME :");
		String sname = scn.next();

		System.out.println("Enter the ADDRESS :");
		String saddress = scn.next();
		
		try
		{
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null)
			{
				statement = connection.createStatement();
				if (statement != null)
				{
					String insertSqlQuery = String.format("insert into student(`sname`,`sage`,`saddress`) values ('%s',%d,'%s')", sname, sage, saddress);
					int noOfRows = statement.executeUpdate(insertSqlQuery);
					System.out.println("No of rows affected is :: " + noOfRows);
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
