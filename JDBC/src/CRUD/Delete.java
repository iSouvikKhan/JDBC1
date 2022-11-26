package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	private Connection connection = null;
	private Statement statement = null;
	
	public void doDelete() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/javaconnectiondb";
		String username = "root";
		String password = "root";
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the ID of the column, which you want to DELETE :");
		int id = scn.nextInt();
		
		try
		{
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null)
			{
				statement = connection.createStatement();
				if (statement != null)
				{
					String deleteSqlQuery = String.format("delete from student where `sid` = %d",id);
					int noOfRows = statement.executeUpdate(deleteSqlQuery);
					System.out.println("No of rows deleted is :: " + noOfRows);
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
