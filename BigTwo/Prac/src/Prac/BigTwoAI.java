package Prac;

import java.util.ArrayList;

public class BigTwoAI extends AIType
{
	ArrayList<Card> opponentCard;
	int myPlayedCard;
	Rule rule;
	
	public BigTwoAI(Player aip, String name) 
	{
		super(aip, name);
		opponentCard = new ArrayList<Card>();
		myPlayedCard = -1;
		rule = new BigTwoRule();
		System.out.println(name + " created");
	}

	@Override
	public void setCard(ArrayList<Card> d) 
	{
		card = d;
	}

	@Override
	public ArrayList<Card> playCard() 
	{
		
		if(opponentCard.size() > 1)
		{
			System.out.println(getName());
			return null;
		}
		for(int i = 0; i < card.size(); i++)
		{
			ArrayList<Card> eachCard = new ArrayList<Card>();
			eachCard.add(card.get(i));
			if(rule.single(eachCard, opponentCard))
			{
				System.out.println(getName() + " puts down " + eachCard.get(0).getNumber() + eachCard.get(0).getSuit());
				myPlayedCard = i;
				eachCard.get(0).cardRemove(this);
				return eachCard;
			}
		}
		
		System.out.println(getName() + " passed "); 
	
		
		return null;
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
