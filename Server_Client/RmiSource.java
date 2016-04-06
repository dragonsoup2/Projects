// Source of idea: Core Java 2, Vol. II, p. 267

import java.rmi.*;

public interface RmiSource extends Remote
{
	public int[][] getDepartment(String o, String o2) throws RemoteException;

	public int[][] getEconomic(String o, String o2) throws RemoteException;
	
	public int[][] getSocial(String o, String o2) throws RemoteException;
	
	public int[][] getInternational(String o, String o2) throws RemoteException;
	
	public int[][] getGovernment(String o, String o2) throws RemoteException;
	
	public String Choose() throws RemoteException;
	
	public String option1() throws RemoteException;
	
	public String option2() throws RemoteException;
}