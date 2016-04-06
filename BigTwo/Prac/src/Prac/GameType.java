package Prac;
//first
public class GameType
{
	Game game = null;
	
	public Game createGame(String gameType) 
	{
			if(gameType.equalsIgnoreCase("bigtwo"))
			{
				game = new BigTwo(gameType);
				game.setComponent(new BigTwoComponent(gameType));
			}
			else if(gameType.equalsIgnoreCase("crazyeight"))
			{
				game = new CrazyEight(gameType);
			}

		return game;
	}

}
