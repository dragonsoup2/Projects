package Prac;

import java.util.ArrayList;
import java.util.Scanner;

public class BigTwoAI extends AIType
{
	ArrayList<Card> opponentCard;
	ArrayList<Card> myPlayedCard;
	Rule rule;
	
	public BigTwoAI(Player aip, String name) 
	{
		super(aip, name);
		opponentCard = new ArrayList<Card>();
		myPlayedCard = new ArrayList<Card>();
		rule = new BigTwoRule();
		//System.out.println(name + " created");
	}

	@Override
	public void setCard(ArrayList<Card> d) 
	{
		card = d;
	}

	@Override
	public ArrayList<Card> playCard() 
	{
		ArrayList<Card> newCard = new ArrayList<Card>();
		
		if(!myPlayedCard.isEmpty())
			newCard = allPassed(myPlayedCard);
		else
			newCard = null;

		if(newCard != null)
			return newCard;
		
		if(opponentCard.size() > 1)
		{
			System.out.println(getName() + "passed");
			return null;
		}
		else
		{
			for(int i = 0; i < card.size(); i++)
			{
				ArrayList<Card> eachCard = new ArrayList<Card>();
				eachCard.add(card.get(i));
				if(rule.single(eachCard, opponentCard))
				{
					System.out.println(getName() + " puts down " + eachCard.get(0).getNumber() + eachCard.get(0).getSuit());
					myPlayedCard = eachCard;
					eachCard.get(0).cardRemove(this);
					return eachCard;
				}
			}
			
			System.out.println(getName() + " passed ");
		}
		
		
		return null;
	}
	public ArrayList<Card> allPassed(ArrayList<Card> playedCard)
	{
		ArrayList<Card> playCard = new ArrayList<Card>();
		
		if(playedCard.get(0).getNumber() == opponentCard.get(0).getNumber() && playedCard.get(0).getSuit().equals(opponentCard.get(0).getSuit() ))
		{
			System.out.println("---------------------------------------------------");
			System.out.println("All other players passed!");
			System.out.println(getName() + " picks any card - " + card.get(0).getNumber() + card.get(0).getSuit());
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			playCard.add(card.get(0));
			myPlayedCard = playCard;
			card.get(0).cardRemove(this);			
		}
		else
			playCard = null;
	
		return playCard;
	}

	@Override
	public ArrayList<Card> getHand() 
	{
		return card;
	}

	@Override
	public String getName()
	{
		return name;
	}
	public ArrayList<Player> reArrange(ArrayList<Player> players) 
	{
		ArrayList<Player> reArrange = new ArrayList<Player>();
		
		for(int i = 0; i < players.size(); i++)
			if(!getName().equals(players.get(i).getName()))
				reArrange.add(players.get(i));
		reArrange.add(this);
		
		return reArrange;
	}

	@Override
	public void setCardOnTheTable(ArrayList<Card> cardOnTheTable) 
	{
		opponentCard = cardOnTheTable;
	}
	@Override
	public ArrayList<Card> getCardOnTheTable() 
	{
		return opponentCard;
	}

	@Override
	public int cardCount() 
	{
		return getHand().size();
	}
}
