package Prac;

import java.util.ArrayList;

//second
public class BigTwo implements Game
{
	private String gameName;
	private Component btc;
	private ArrayList<Player> players;
	
	public BigTwo(String name)
	{
		gameName = name;
		players = new ArrayList<Player>();
	}

	@Override
	public void play() 
	{
		boolean noCard = false;
		ArrayList<Card> opponent = new ArrayList<Card>();
		System.out.println("----------------Let's play Big Two-----------------");
		System.out.println("----a player who has 3 Diamond plays first turn----");
		System.out.println("---------------------------------------------------");
		findFirstTurn();
		
		do
		{
			for(int i = 0; i < players.size() && !noCard; i++)
			{
				opponent = players.get(i).playCard();
				if(players.get(i).cardCount() == 0)
				{
					System.out.println(players.get(i).getName() + " win the game!!!");
					noCard = true;
				}
				if(i != 3 && opponent != null)
				{
					players.get(i+1).setCardOnTheTable(opponent);
				}
				else if(i != 3 && opponent == null)
				{
					players.get(i+1).setCardOnTheTable(players.get(i).getCardOnTheTable());
				}
			}
			
			if(!noCard && opponent == null)
			{
				players.get(0).setCardOnTheTable(players.get(3).getCardOnTheTable());
			}
			else if(!noCard && opponent != null)
			{
				players.get(0).setCardOnTheTable(opponent);
			}
		}
		while(!noCard);
	}
	public void findFirstTurn() 
	{
		Player player = null;
		BigTwoCard firstcard = null;
		ArrayList<Card> cardPlayed = new ArrayList<Card>();
		
		for(int i = 0; i < players.size() && player == null; i++)
		{
			ArrayList<Card> card = players.get(i).getHand();
			for(int r = 0; r < card.size() && player == null; r++)
			{
				if(card.get(r).getNumber() == 1 && card.get(r).getSuit().equals("d"))
				{
					firstcard = new BigTwoCard(1, "d");
					cardPlayed.add(firstcard);
					player = players.get(i);
				}
			}
		}
		firstcard.firstCard(player);//bigtwocard class
		players = player.reArrange(players);//bigtwoplayer class
		players.get(0).setCardOnTheTable(cardPlayed);
	}

	@Override
	public void setComponent(Component component) 
	{
		btc = component;
		btc.setPlayers();
		btc.setCard();
		players = btc.getPlayers();
	}
	
}
