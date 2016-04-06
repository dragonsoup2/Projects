package Prac;

import java.util.ArrayList;

public class PlayerType 
{
	private ArrayList<Player> players;
	
	public PlayerType()
	{
		players = new ArrayList<Player>();
	}
	
	public void createPlayer(String gameType)
	{
		if(gameType.equalsIgnoreCase("bigtwo"))
		{
			Player p = new BigTwoPlayer();
			players.add(p);
		}
		else if(gameType.equalsIgnoreCase("crazyeight"))
		{
			Player cePlayer = new CrazyEightPlayer();
		}
	}
	public void createAI(String gameType)
	{
		if(gameType.equalsIgnoreCase("bigtwo"))
		{
			Player[] aiPlayer = new Player[3];
			
			for(int i = 0; i < aiPlayer.length; i++)
				players.add(new BigTwoAI(new BigTwoPlayer(), "AI" + (i+1)));
		}
		else if(gameType.equalsIgnoreCase("crazyeight"))
		{
			Player cePlayer = new CrazyEightPlayer();
		}
	}
	
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
}
