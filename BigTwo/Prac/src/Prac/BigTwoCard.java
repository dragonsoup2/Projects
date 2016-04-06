package Prac;

import java.util.ArrayList;

public class BigTwoCard implements Card
{ 
	private int CardNum;
	private String CardSuit;
	
	public BigTwoCard(int cn, String cs)
	{
		CardNum = cn;
		CardSuit = cs;
	}
	public BigTwoCard() 
	{
		CardNum = 0;
		CardSuit = "";
	}
	public String getSuit()
	{
		return CardSuit;
	}
	@Override
	public int getNumber()
	{
		return CardNum;
	}
	@Override
	public void cardRemove(Player player) 
	{
		ArrayList<Card> playerCard = player.getHand();
		boolean found = false;
		
		for(int i = 0; i < playerCard.size() && !found; i++)
		{
			if(CardNum == playerCard.get(i).getNumber() && CardSuit.equals(playerCard.get(i).getSuit()))
			{
				playerCard.remove(i);
				player.setCard(playerCard);
				found = true;
			}					
		}
	}
	public void firstCard(Player player)
	{
		System.out.println(player.getName() + " has put down " + CardNum + CardSuit);
		cardRemove(player);
	}
}
