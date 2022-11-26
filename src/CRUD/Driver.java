package CRUD;

import java.sql.SQLException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) throws SQLException {
		Scanner scn = new Scanner(System.in);
		int val = 0;
		do
		{
			System.out.println("  ---  INSTRUCTIONS  ---  ");
			System.out.println("What operation you wish to perform ??");
			System.out.println("to READ the table, type : 1");
			System.out.println("to INSERT a column into table, type : 2");
			System.out.println("to UPDATE column of the table, type : 3");
			System.out.println("to DELETE column of the table, type : 4");
			System.out.println("Press enter...\n");
			val = scn.nextInt();
			switch(val)
			{
				case 1:
					new Read().getRead();
					break;
				case 2:
					new Insert().doInsert();
					System.out.println();
					new Read().getRead();
					break;
				case 3:
					new Read().getRead();
					System.out.println();
					new Update().doUpdate();
					System.out.println();
					new Read().getRead();
					break;
				case 4:
					new Read().getRead();
					System.out.println();
					new Delete().doDelete();
					System.out.println();
					new Read().getRead();
					break;
				default:
					System.out.println("Invalid entry, read instructions properly !!");
			}
			System.out.println("\nTo perform more such operations type : 5");
			System.out.println("To exit the application type : 9");
			System.out.println("Press enter...\n");
			val = scn.nextInt();
		}
		while(val != 9);
		System.out.println("Thanks for using the application. Have a nice day !!");
	}
}
