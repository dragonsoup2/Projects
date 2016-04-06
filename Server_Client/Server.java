// Source of idea:
//Core Java 2, Vol. II, p. 267

// a server program

import java.rmi.*;
import java.rmi.server.*;

public class Server {

   public static void main(String[] args) {
		 String url = "rmi://localhost:6667/";
		 int choice;
      try 
	  {
	   OpenDatabase p1 = new OpenDatabase();
       Naming.rebind( "rmi://localhost:6667/yong", p1 );
      }

      catch( Exception e ) {
	                        System.out.println( "Error: " + e );
      }
   }
}
