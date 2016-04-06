package Prac;

import java.util.ArrayList;

public abstract class Rule 
{
	class Rank// class checking rank of cards.
	{
		public boolean checkRank(int num1, int num2, String s1, String s2)
		{
			if(num1 == num2)
			{
				if(s1.equals("c") && s2.equals("d"))
					return true;
				
				if(s1.equals("h") && (s2.equals("d") || s2.equals("c")))
					return true;
				
				if(s1.equals("s") && (s2.equals("d") || s2.equals("c") || s2.equals("h")))
					return true;
			}
			else if(num1 > num2)
			{
				return true;
			}
			return false;
		}
	}
	public abstract boolean single(ArrayList<Card> cardPlayed, ArrayList<Card> onTheTable);
	public abstract boolean pair(ArrayList<Card> cardDealt);
	public abstract boolean twoPair(ArrayList<Card> cardDealt);
	public abstract boolean triple(ArrayList<Card> cardDealt);
	public abstract boolean straight(ArrayList<Card> cardDealt);
	public abstract boolean flush(ArrayList<Card> cardDealt);
	public abstract boolean fullHouse(ArrayList<Card> cardDealt);
	public abstract boolean fourOfaKind(ArrayList<Card> cardDealt);
	public abstract boolean straightFlush(ArrayList<Card> cardDealt);
	
}
