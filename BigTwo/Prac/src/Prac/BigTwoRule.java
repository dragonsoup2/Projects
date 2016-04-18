package Prac;

import java.util.ArrayList;

import Prac.Rule.Rank;

public class BigTwoRule extends Rule
{

	public boolean single(ArrayList<Card> cardPlayed, ArrayList<Card> onTheTable)
	{
		Rank rank = new Rank();
		if(cardPlayed.size() == 1)
		{
			String cardDealtSuit = cardPlayed.get(0).getSuit();
			int cardDealtNum = cardPlayed.get(0).getNumber();
			
			String onTheTableSuit = onTheTable.get(0).getSuit();
			int onTheTableNum = onTheTable.get(0).getNumber();
			
			if(rank.checkRank(cardDealtNum, onTheTableNum, cardDealtSuit, onTheTableSuit))
				return true;
		}
		
		return false;
	}
	public boolean pair(ArrayList<Card> cardDealt)
	{
		boolean valid = true;
		
		if(cardDealt.size() != 2)
			valid = false;
		else
			if(cardDealt.get(0).getNumber() != cardDealt.get(1).getNumber())
				valid = false;
		
		return valid;
	}
	public boolean twoPair(ArrayList<Card> cardDealt)
	{
		/*boolean valid = true;
		ArrayList<Card> twopairs = new ArrayList<Card>();
		int count = 0;
		if(cardDealt.size() != 4)
			valid = false;
		else
		{
			for(int i = 0; i < cardDealt.size(); i++)
				for(int r = 1; r < cardDealt.size();r++)
				{
					if(cardDealt.get(i).getNumber() == cardDealt.get(r).getNumber())
					{
						twopairs.add(cardDealt.get(i));
						twopairs.add(cardDealt.get(r));
						count++;
					}
				}
			if(count != 2)
				valid = false;
		}*/
		// Since there is no such a rule that a player play two pairs.
		return false;
	}
	public boolean triple(ArrayList<Card> cardDealt)
	{
		boolean valid = true;
		int index = 1;
		int count = 0;
		if(cardDealt.size() != 3)
			valid = false;
		else
		{
			int first = cardDealt.get(0).getNumber();
			while(index < 3)
				if(first == cardDealt.get(index).getNumber())
				{
					index++;
					count++;
				}
			if(count != 2)
				valid = false;
		}
		return valid;
	}
	public boolean straight(ArrayList<Card> cardDealt)
	{
		boolean valid = true;
		
		if(cardDealt.size() != 5)
			valid = false;
		else
		{
			if(cardDealt.get(1).getNumber() == 13 && 
			   cardDealt.get(2).getNumber() == 13 && cardDealt.get(3).getNumber() == 13)
				valid = false;
			else
			{
				int first = cardDealt.get(0).getNumber();
				int index = 1;
				while(index < 5 && cardDealt.get(index).getNumber() == (first + 1))
				{
					first++;
					index++;
				}
				if(first != cardDealt.get(4).getNumber())
					valid = false;
			}
		}
		return valid;
	}
	public boolean flush(ArrayList<Card> cardDealt)
	{
		boolean valid = true;
		int count = 0;
		int index = 1;
		if(cardDealt.size() != 5)
			valid = false;
		else
		{
			String letter = cardDealt.get(0).getSuit();
			while(index < 5)
				if(cardDealt.get(index).getSuit().equals(letter))
				{
					index++;
					count++;
				}
			if(count != 4)
				valid = false;
		}
		return valid;
	}
	public boolean fullHouse(ArrayList<Card> cardDealt)
	{
		ArrayList<Card> cg1 = new ArrayList<Card>();
		ArrayList<Card> cg2 = new ArrayList<Card>();
		boolean valid = true;
		int i = 0;
		if(cardDealt.size() != 5)
			valid = false;
		else
		{
			while(i < 5)
			{
				if(0 <= i && i < 3)
					cg1.add(cardDealt.get(i));
				
				if(3 <= i && i < 5)
					cg2.add(cardDealt.get(i));
				i++;
				
			}
			if(!(triple(cg1) && pair(cg2)))
			{
				valid = false;
				i = 0;
				cg1 = new ArrayList<Card>();
				cg2 = new ArrayList<Card>();
			}
			else
				return true;
			
			while(i < 5)
			{
				if(0 <= i && i < 3)
					cg2.add(cardDealt.get(i));
				
				if(3 <= i && i < 5)
					cg1.add(cardDealt.get(i));
				i++;
			}
			
			if(!(triple(cg2) && pair(cg1)))
				valid = false;
				
		}
		return valid;
	}
	public boolean fourOfaKind(ArrayList<Card> cardDealt)
	{
		boolean valid = true;
		int index = 1;
		int count = 0;
		if(cardDealt.size() != 4)
			valid = false;
		else
		{
			int first = cardDealt.get(0).getNumber();
			while(index < 4)
				if(first == cardDealt.get(index).getNumber())
				{
					index++;
					count++;
				}
			if(count != 3)
				valid = false;
		}
		return valid;
	}
	public boolean straightFlush(ArrayList<Card> cardDealt)
	{
		boolean valid = true;
		if(cardDealt.size() != 5)
			valid = false;
		else
		{
			ArrayList<Card> cg = new ArrayList<Card>();
			cg = cardDealt;
			if(!(flush(cg) && straight(cg)))
				valid = false;
		}
		return valid;
	}
}
