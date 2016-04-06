// Source of idea: Core Java 2, Vol. II, p. 270

// a client program
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class Client
{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
	   String choice;
       String url = "rmi://localhost:6667/";

	   try {
			RmiSource r1 = (RmiSource) Naming.lookup( url + "yong" );
			
			System.out.print(r1.Choose());
			choice = in.nextLine();
			System.out.println("\n");
			
		while(!choice.equals("exit"))
		{		
			if(choice.equals("department"))
			{
				int department[][] = new int[4][3];
				System.out.print(r1.option1());
				String opt = in.nextLine();
				String opt2 = "";
				System.out.println("\n");
				while(!opt.equals("exit"))
				{
					if(opt.equals("specific"))
					{	
						System.out.print(r1.option2());
						opt = in.nextLine();
						int done = 0;
						while(!opt.equals("exit") && done == 0)
						{
							if(opt.equals("range"))
							{
								System.out.print("greater or less - ");
								opt = in.nextLine();
								System.out.print("Type a specific amount - ");
								opt2 = in.nextLine();
								System.out.println("\n");
								done = 1;
							}
							else if(opt.equals("difference"))
							{
								opt = "difference";
								done = 1;
							}
							else
							{
								System.out.println("\nChose a wrong option\n");
								System.out.print(r1.option2());
								opt = in.nextLine();
							}
						}
						if(!opt.equals("exit"))
						{
							department = r1.getDepartment(opt, opt2);
							BarChart dp = new BarChart("2013-14 OutcomeArea - Planned and Actual spendings", "Departments", department);
							dp.pack( );        
							RefineryUtilities.centerFrameOnScreen( dp );        
							dp.setVisible( true );
						}
						System.out.print(r1.option1());
						opt = in.nextLine();
					}
					else if(opt.equals("all"))
					{
						department = r1.getDepartment(opt, opt2);
						BarChart dp = new BarChart("2013-14 OutcomeArea - Planned and Actual spendings", "Departments", department);
						dp.pack( );        
						RefineryUtilities.centerFrameOnScreen( dp );        
						dp.setVisible( true );
						System.out.print(r1.option1());
						opt = in.nextLine();
					}
					else
					{
						System.out.println("\nChose a wrong option\n");
						System.out.print(r1.option1());
						opt = in.nextLine();
					}
				}
						System.out.print("Any other infomation( department, economic, social, international, government ) = ");
						choice = in.nextLine();
			}
			else if(choice.equals("economic"))
			{
				int economic[][] = new int[6][3];
				System.out.print(r1.option1());
				String opt = in.nextLine();
				System.out.println("\n");
				String opt2 = "";
				while(!opt.equals("exit"))
				{				
					if(opt.equals("specific"))
					{	
						System.out.print(r1.option2());
						opt = in.nextLine();
						int done = 0;
						while(!opt.equals("exit") && done == 0)
						{
							if(opt.equals("range"))
							{
								System.out.print("greater or less - ");
								opt = in.nextLine();
								System.out.print("Type a specific amount - ");
								opt2 = in.nextLine();			
								System.out.println("\n");
								done = 1;
							}
							else if(opt.equals("difference"))
							{
								opt = "difference";
								done = 1;
							}
							else
							{
								System.out.println("\nChose a wrong option\n");
								System.out.print(r1.option2());
								opt = in.nextLine();
							}
						}
						if(!opt.equals("exit"))
						{
							economic = r1.getEconomic(opt, opt2);
							BarChart2 dp = new BarChart2("2013-14 OutcomeArea - Planned and Actual spendings", "Economic", economic);
							dp.pack( );        
							RefineryUtilities.centerFrameOnScreen( dp );        
							dp.setVisible( true );
						}
						System.out.print(r1.option1());
						opt = in.nextLine();						
					}
					else if(opt.equals("all"))
					{
						economic = r1.getEconomic(opt, opt2);
						BarChart2 dp = new BarChart2("2013-14 OutcomeArea - Planned and Actual spendings", "Economic", economic);
						dp.pack( );        
						RefineryUtilities.centerFrameOnScreen( dp );        
						dp.setVisible( true );
						System.out.print(r1.option1());
						opt = in.nextLine();
					}
					else
					{
						System.out.println("\nChose a wrong option\n");
						System.out.print(r1.option1());
						opt = in.nextLine();				
					}
				}
						System.out.print("Any other infomation( department, economic, social, international, government ) = ");
						choice = in.nextLine();
			}
			else if(choice.equals("social"))
			{
				int social[][] = new int[4][3];
				System.out.print(r1.option1());
				String opt = in.nextLine();
				String opt2 = "";
				System.out.println("\n");
				while(!opt.equals("exit"))
				{
					if(opt.equals("specific"))
					{	
						System.out.print(r1.option2());
						opt = in.nextLine();
						int done = 0;
						while(!opt.equals("exit") && done == 0)
						{
							if(opt.equals("range"))
							{
								System.out.print("greater or less - ");
								opt = in.nextLine();
								System.out.print("Type a specific amount - ");
								opt2 = in.nextLine();
								System.out.println("\n");
								done = 1;
							}
							else if(opt.equals("difference"))
							{
								opt = "difference";
								done = 1;
							}
							else
							{
								System.out.println("\nChose a wrong option\n");
								System.out.print(r1.option2());
								opt = in.nextLine();
							}
						}
						if(!opt.equals("exit"))
						{
							social = r1.getSocial(opt, opt2);
							BarChart3 dp = new BarChart3("2013-14 OutcomeArea - Planned and Actual spendings", "Social", social);
							dp.pack( );        
							RefineryUtilities.centerFrameOnScreen( dp );        
							dp.setVisible( true );
						}
						System.out.print(r1.option1());
						opt = in.nextLine();						
					}
					else if(opt.equals("all"))
					{
						social = r1.getSocial(opt, opt2);
						BarChart3 dp = new BarChart3("2013-14 OutcomeArea - Planned and Actual spendings", "Social", social);
						dp.pack( );        
						RefineryUtilities.centerFrameOnScreen( dp );        
						dp.setVisible( true );
						System.out.print(r1.option1());
						opt = in.nextLine();						
					}
					else
					{
						System.out.println("\nChose a wrong option\n");
						System.out.print(r1.option1());
						opt = in.nextLine();				
					}
				}
						System.out.print("Any other infomation( department, economic, social, international, government ) = ");
						choice = in.nextLine();	
			}
			else if(choice.equals("international"))
			{
				int international[][] = new int[4][3];
				System.out.print(r1.option1());
				String opt = in.nextLine();
				String opt2 = "";
				System.out.println("\n");
				while(!opt.equals("exit"))
				{
					if(opt.equals("specific"))
					{	
						System.out.print(r1.option2());
						opt = in.nextLine();
						int done = 0;
						while(!opt.equals("exit") && done == 0)
						{
							if(opt.equals("range"))
							{
								System.out.print("greater or less - ");
								opt = in.nextLine();
								System.out.print("Type a specific amount - ");
								opt2 = in.nextLine();												
								System.out.println("\n");
								done = 1;
							}
							else if(opt.equals("difference"))
							{
								opt = "difference";
								done = 1;
							}
							else
							{
								System.out.println("\nChose a wrong option\n");
								System.out.print(r1.option2());
								opt = in.nextLine();
							}
						}
						if(!opt.equals("exit"))
						{
							international = r1.getInternational(opt, opt2);
							BarChart4 dp = new BarChart4("2013-14 OutcomeArea - Planned and Actual spendings", "International", international);
							dp.pack( );        
							RefineryUtilities.centerFrameOnScreen( dp );        
							dp.setVisible( true );
						}
						System.out.print(r1.option1());
						opt = in.nextLine();
					}
					else if(opt.equals("all"))
					{
						international = r1.getInternational(opt, opt2);
						BarChart4 dp = new BarChart4("2013-14 OutcomeArea - Planned and Actual spendings", "International", international);
						dp.pack( );        
						RefineryUtilities.centerFrameOnScreen( dp );        
						dp.setVisible( true );
						System.out.print(r1.option1());
						opt = in.nextLine();
					}
					else
					{
						System.out.println("\nChose a wrong option\n");
						System.out.print(r1.option1());
						opt = in.nextLine();				
					}
				}
						System.out.print("Any other infomation( department, economic, social, international, government ) = ");
						choice = in.nextLine();
			}
			else if(choice.equals("government"))
			{
				int government[][] = new int[3][3];
				System.out.print(r1.option1());
				String opt = in.nextLine();
				String opt2 = "";
				System.out.println("\n");
				while(!opt.equals("exit"))
				{
					if(opt.equals("specific"))
					{	
						System.out.print(r1.option2());
						opt = in.nextLine();
						int done = 0;
						while(!opt.equals("exit") && done == 0)
						{
							if(opt.equals("range"))
							{
								System.out.print("greater or less - ");
								opt = in.nextLine();
								System.out.print("Type a specific amount - ");
								opt2 = in.nextLine();
								System.out.println("\n");
								done = 1;
							}
							else if(opt.equals("difference"))
							{
								opt = "difference";
								done = 1;
							}
							else
							{
								System.out.println("\nChose a wrong option\n");
								System.out.print(r1.option2());
								opt = in.nextLine();
							}
						}
						if(!opt.equals("exit"))
						{
							government = r1.getGovernment(opt, opt2);
							BarChart5 dp = new BarChart5("2013-14 OutcomeArea - Planned and Actual spendings", "Government", government);
							dp.pack( );        
							RefineryUtilities.centerFrameOnScreen( dp );        
							dp.setVisible( true );
						}
						System.out.print(r1.option1());
						opt = in.nextLine();
					}
					else if(opt.equals("all"))
					{
						government = r1.getGovernment(opt, opt2);
						BarChart5 dp = new BarChart5("2013-14 OutcomeArea - Planned and Actual spendings", "Government", government);
						dp.pack( );        
						RefineryUtilities.centerFrameOnScreen( dp );        
						dp.setVisible( true );
						System.out.print(r1.option1());
						opt = in.nextLine();
					}
					else
					{
						System.out.println("\nChose a wrong option\n");
						System.out.print(r1.option1());
						opt = in.nextLine();				
					}
				}
						System.out.print("Any other infomation( department, economic, social, international, government ) = ");
						choice = in.nextLine();
			}
			else
			{
				System.out.println("Chose a wrong option");
				System.out.print(r1.Choose());
				choice = in.nextLine();
			}
		}
	   }

	   catch( Exception e ) {
				 System.out.println( "Error " + e );
 	   }

	   System.out.println( "rmi client: THE END!" );
	}
}