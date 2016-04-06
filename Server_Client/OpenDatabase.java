// Source of idea: Core Java 2, Vol. II, p. 267

// implementation of the remote interface

import java.sql.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class OpenDatabase extends UnicastRemoteObject implements RmiSource  
{

	static final String drivername = "com.mysql.jdbc.Driver";
    static final String sysName = "zenit.senecac.on.ca";
    static final String dbName  = "btp400_151a37";
    static final String userid =  "btp400_151a37";
    static final String password = "sgWX9282";
    private Connection conn;
	
	public OpenDatabase() throws RemoteException
	{

	   try 
	   {
	           Class.forName( drivername );  // load the Java class(i.e. JDBC driver) at run time
	   }
	   catch( ClassNotFoundException ec) { ec.printStackTrace();
	                                       System.out.println( "MySQL JDBC driver not found!" );
					                       System.exit(1);
					                     }

		System.out.println("connecting");
        try
        {
          conn = DriverManager.getConnection( "jdbc:mysql:" +
					      					  "//" + sysName +
                                              "/"  + dbName,
                                              userid, password
                                            );
        }
        catch ( SQLException exc )  /* SQLException */
        {
          System.out.println( "connection failed with: " + exc.getMessage() );
        }
    }
	public int[][] getDepartment(String o, String o2) throws RemoteException
	{
		int row = 0;
		int col = 0;
		String baseQuery = "";
		int departments[][] = new int[4][3];
        try {
			if(o.equals("all") && o2.equals(""))
			{
				baseQuery = "select PlannedSpending, ActualSpending from Department";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("all"))
							departments[row][col++]=7;				
						departments[row][col++]=rse.getInt("PlannedSpending");
						departments[row][col++]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			if(o.equals("difference") && o2.equals(""))
			{
				departments = new int[4][3];
				baseQuery = "select PlannedSpending, ActualSpending from Department";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("difference"))
							departments[row][col++]=3;
						departments[row][col++]=rse.getInt("PlannedSpending");
						departments[row][col++]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
			}
			else if(o.equals("greater"))
			{
				baseQuery = "select Name, PlannedSpending, ActualSpending from Department where PlannedSpending > " + o2 + " AND ActualSpending > " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("Name").equals("Economic Affairs"))
							departments[row][col++]=1;
						else if(rse.getString("Name").equals("International Affairs"))
							departments[row][col++]=2;
						else if(rse.getString("Name").equals("Social Affairs"))
							departments[row][col++]=3;
						else if(rse.getString("Name").equals("Government Affairs"))
							departments[row][col++]=4;							
						departments[row][col++]=rse.getInt("PlannedSpending");
						departments[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			else if(o.equals("less"))
			{
				baseQuery = "select Name, PlannedSpending, ActualSpending from Department where PlannedSpending < " + o2 + " and ActualSpending < " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("Name").equals("Economic Affairs"))
							departments[row][col++]=1;
						else if(rse.getString("Name").equals("International Affairs"))
							departments[row][col++]=2;
						else if(rse.getString("Name").equals("Social Affairs"))
							departments[row][col++]=3;
						else if(rse.getString("Name").equals("Government Affairs"))
							departments[row][col++]=4;							
						departments[row][col++]=rse.getInt("PlannedSpending");
						departments[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}			
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}

		}
		catch ( SQLException exc )
        {
           System.out.println( " query failed with: " + exc.getMessage() );
        }
		
		
			return departments;
		
	}
	public int[][] getEconomic(String o, String o2) throws RemoteException
	{
		int row = 0;
		int col = 0;
		String baseQuery = "";
		int economic[][] = new int[6][3];
        try {
			if(o.equals("all") && o2.equals(""))
			{
				baseQuery = "select PlannedSpending, ActualSpending from EconomicAffairs";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("all"))
							economic[row][col++]=7;				
						economic[row][col++]=rse.getInt("PlannedSpending");
						economic[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			if(o.equals("difference") && o2.equals(""))
			{
				economic = new int[6][3];
				baseQuery = "select PlannedSpending, ActualSpending from EconomicAffairs";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("difference"))
							economic[row][col++]=3;
						economic[row][col++]=rse.getInt("PlannedSpending");
						economic[row][col++]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
			}
			else if(o.equals("greater"))
			{
				baseQuery = "select GoCoName, PlannedSpending, ActualSpending from EconomicAffairs where PlannedSpending > " + o2 + " AND ActualSpending > " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("GoCoName").equals("Income security and employment for Canadians"))
							economic[row][col++]=1;
						else if(rse.getString("GoCoName").equals("Strong economic growth"))
							economic[row][col++]=2;
						else if(rse.getString("GoCoName").equals("An innovative and knowledge based economy"))
							economic[row][col++]=3;
						else if(rse.getString("GoCoName").equals("A clean and healthy environment"))
							economic[row][col++]=4;							
						else if(rse.getString("GoCoName").equals("A fair and secure marketplace"))
							economic[row][col++]=5;
						else if(rse.getString("GoCoName").equals("Other Expenditures"))
							economic[row][col++]=6;
							
						economic[row][col++]=rse.getInt("PlannedSpending");
						economic[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			else if(o.equals("less"))
			{
				baseQuery = "select GoCoName, PlannedSpending, ActualSpending from EconomicAffairs where PlannedSpending < " + o2 + " and ActualSpending < " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("GoCoName").equals("Income security and employment for Canadians"))
							economic[row][col++]=1;
						else if(rse.getString("GoCoName").equals("Strong economic growth"))
							economic[row][col++]=2;
						else if(rse.getString("GoCoName").equals("An innovative and knowledge based economy"))
							economic[row][col++]=3;
						else if(rse.getString("GoCoName").equals("A clean and healthy environment"))
							economic[row][col++]=4;							
						else if(rse.getString("GoCoName").equals("A fair and secure marketplace"))
							economic[row][col++]=5;
						else if(rse.getString("GoCoName").equals("Other Expenditures"))
							economic[row][col++]=6;
							
						economic[row][col++]=rse.getInt("PlannedSpending");
						economic[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}			
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}

		}
		catch ( SQLException exc )
        {
           System.out.println( " query failed with: " + exc.getMessage() );
        }
		
		
			return economic;
	}
	
	public int[][] getSocial(String o, String o2) throws RemoteException
	{
		int row = 0;
		int col = 0;
		String baseQuery = "";
		int social[][] = new int[4][3];
        try {
			if(o.equals("all") && o2.equals(""))
			{
				baseQuery = "select PlannedSpending, ActualSpending from SocialAffairs";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("all"))
							social[row][col++]=7;
						social[row][col++]=rse.getInt("PlannedSpending");
						social[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			if(o.equals("difference") && o2.equals(""))
			{
				social = new int[4][3];
				baseQuery = "select PlannedSpending, ActualSpending from SocialAffairs";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("difference"))
							social[row][col++]=3;
						social[row][col++]=rse.getInt("PlannedSpending");
						social[row][col++]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
			}
			else if(o.equals("greater"))
			{
				baseQuery = "select GoCoName, PlannedSpending, ActualSpending from SocialAffairs where PlannedSpending > " + o2 + " AND ActualSpending > " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("GoCoName").equals("healthy Canadians"))
							social[row][col++]=1;
						else if(rse.getString("GoCoName").equals("safe and secure Canada"))
							social[row][col++]=2;
						else if(rse.getString("GoCoName").equals("diverse society that promotes linguistic duality and social inclusion"))
							social[row][col++]=3;
						else if(rse.getString("GoCoName").equals("vibrant Canadian culture and heritage"))
							social[row][col++]=4;							
						social[row][col++]=rse.getInt("PlannedSpending");
						social[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			else if(o.equals("less"))
			{
				baseQuery = "select GoCoName, PlannedSpending, ActualSpending from SocialAffairs where PlannedSpending < " + o2 + " and ActualSpending < " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("GoCoName").equals("healthy Canadians"))
							social[row][col++]=1;
						else if(rse.getString("GoCoName").equals("safe and secure Canada"))
							social[row][col++]=2;
						else if(rse.getString("GoCoName").equals("diverse society that promotes linguistic duality and social inclusion"))
							social[row][col++]=3;
						else if(rse.getString("GoCoName").equals("vibrant Canadian culture and heritage"))
							social[row][col++]=4;								
						social[row][col++]=rse.getInt("PlannedSpending");
						social[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}			
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}

		}
		catch ( SQLException exc )
        {
           System.out.println( " query failed with: " + exc.getMessage() );
        }
		
		
			return social;
	}
	
	public int[][] getInternational(String o, String o2) throws RemoteException
	{
		int row = 0;
		int col = 0;
		String baseQuery = "";
		int international[][] = new int[4][3];
        try {
			if(o.equals("all") && o2.equals(""))
			{
				baseQuery = "select PlannedSpending, ActualSpending from InternationalAffairs";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("all"))
							international[row][col++]=7;
						international[row][col++]=rse.getInt("PlannedSpending");
						international[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			if(o.equals("difference") && o2.equals(""))
			{
				international = new int[4][3];
				baseQuery = "select PlannedSpending, ActualSpending from InternationalAffairs";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("difference"))
							international[row][col++]=3;
						international[row][col++]=rse.getInt("PlannedSpending");
						international[row][col++]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
			}
			else if(o.equals("greater"))
			{
				baseQuery = "select GoCoName, PlannedSpending, ActualSpending from InternationalAffairs where PlannedSpending > " + o2 + " AND ActualSpending > " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("GoCoName").equals("A safe and secure world through international engagement"))
							international[row][col++]=1;
						else if(rse.getString("GoCoName").equals("Global poverty reduction through international sustainable development"))
							international[row][col++]=2;
						else if(rse.getString("GoCoName").equals("diverse society that promotes linguistic duality and social inclusion"))
							international[row][col++]=3;
						else if(rse.getString("GoCoName").equals("a strong and mutually beneficial North American partnership"))
							international[row][col++]=4;							
						international[row][col++]=rse.getInt("PlannedSpending");
						international[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			else if(o.equals("less"))
			{
				baseQuery = "select GoCoName, PlannedSpending, ActualSpending from InternationalAffairs where PlannedSpending < " + o2 + " and ActualSpending < " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("GoCoName").equals("A safe and secure world through international engagement"))
							international[row][col++]=1;
						else if(rse.getString("GoCoName").equals("Global poverty reduction through international sustainable development"))
							international[row][col++]=2;
						else if(rse.getString("GoCoName").equals("diverse society that promotes linguistic duality and social inclusion"))
							international[row][col++]=3;
						else if(rse.getString("GoCoName").equals("a strong and mutually beneficial North American partnership"))
							international[row][col++]=4;							
						international[row][col++]=rse.getInt("PlannedSpending");
						international[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}			
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}

		}
		catch ( SQLException exc )
        {
           System.out.println( " query failed with: " + exc.getMessage() );
        }
		
		
			return international;
	}
	
	public int[][] getGovernment(String o, String o2) throws RemoteException
	{
		int row = 0;
		int col = 0;
		String baseQuery = "";
		int government[][] = new int[3][3];
        try {
			if(o.equals("all") && o2.equals(""))
			{
				baseQuery = "select PlannedSpending, ActualSpending from GovernmentAffairs";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("all"))
							government[row][col++]=7;
						government[row][col++]=rse.getInt("PlannedSpending");
						government[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			if(o.equals("difference") && o2.equals(""))
			{
				government = new int[3][3];
				baseQuery = "select PlannedSpending, ActualSpending from GovernmentAffairs";
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(o.equals("difference"))
							government[row][col++]=3;
						government[row][col++]=rse.getInt("PlannedSpending");
						government[row][col++]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
			}
			else if(o.equals("greater"))
			{
				baseQuery = "select GoCoName, PlannedSpending, ActualSpending from GovernmentAffairs where PlannedSpending > " + o2 + " AND ActualSpending > " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("GoCoName").equals("Well-managed and efficient government operations"))
							government[row][col++]=1;
						else if(rse.getString("GoCoName").equals("A transparent, accountable and responsive federal government"))
							government[row][col++]=2;
						else if(rse.getString("GoCoName").equals("Strong and independent democratic institutions"))
							government[row][col++]=3;
							
						government[row][col++]=rse.getInt("PlannedSpending");
						government[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}
			else if(o.equals("less"))
			{
				baseQuery = "select GoCoName, PlannedSpending, ActualSpending from GovernmentAffairs where PlannedSpending < " + o2 + " and ActualSpending < " + o2;
				Statement stat = conn.createStatement();
				ResultSet rse = stat.executeQuery( baseQuery);
				while(rse.next() ){
						if(rse.getString("GoCoName").equals("Well-managed and efficient government operations"))
							government[row][col++]=1;
						else if(rse.getString("GoCoName").equals("A transparent, accountable and responsive federal government"))
							government[row][col++]=2;
						else if(rse.getString("GoCoName").equals("Strong and independent democratic institutions"))
							government[row][col++]=3;
							
						government[row][col++]=rse.getInt("PlannedSpending");
						government[row][col]=rse.getInt("ActualSpending");
						row++;
						col = 0;
				}			
	 		rse.close();   // close the ResultSet object
	 		stat.close(); // close the Statement object
			}

		}
		catch ( SQLException exc )
        {
           System.out.println( " query failed with: " + exc.getMessage() );
        }
		
		
			return government;
	}
	
	public String Choose() throws RemoteException
	{
		String msg = "Here are options \n";
		msg = msg + "department - Planned spending and Actual spending from all department\n";
		msg = msg + "economic - Planned spending and Actual spending from Economic Affair\n";
		msg = msg + "social - Planned spending and Actual spending from Social Affair\n";
		msg = msg + "international - Planned spending and Actual spending from International Affair\n";
		msg = msg + "government - Planned spending and Actual spending from Government Affair\n";
		msg = msg + "exit - End the program\n";
		msg = msg + "Which information do you want to see - ";
		
		return msg;
	}
	
	public String option1() throws RemoteException
	{
		String msg = "How do you want this data : \n";
		msg = msg + "specific - Add an extra option to it \n";
		msg = msg + "all - Display general data\n";
		msg = msg + "exit - Done with this option\n";
		msg = msg + "Which option do you want - ";
		
		return msg;
	}
	
	public String option2() throws RemoteException
	{
		String msg = "Here are specific options \n";
		msg = msg + "range - Find amount with a specific range \n";
		msg = msg + "difference - Find difference between planned and actual amount \n";
		msg = msg + "exit - Done with this option\n";
		msg = msg + "Which option do you want - ";
		
		return msg;
	}
}