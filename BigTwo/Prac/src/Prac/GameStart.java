package Prac;

import java.util.Scanner;

public class GameStart 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Choose your game = ");
		String yourGame = input.next();
		
		
		GameType gameType = new GameType();
		Game game;
		do
		{
			game = gameType.createGame(yourGame);
			if(game == null)
			{
				System.out.print("Choose either BigTwo or CrazyEight = ");
				yourGame = input.next();
			}
		}while(game == null);
		
		game.play();
	}
}
