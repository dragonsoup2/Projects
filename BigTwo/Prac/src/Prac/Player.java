package Prac;

import java.util.ArrayList;

public interface Player 
{
	public void setCard(ArrayList<Card> d);
	public int cardCount();
	public ArrayList<Card> playCard();
	public void setCardOnTheTable(ArrayList<Card> cardOnTheTable);
	public ArrayList<Card> getCardOnTheTable();
	public ArrayList<Card> getHand();
	public String getName();
	public ArrayList<Player> reArrange(ArrayList<Player> players);
}
