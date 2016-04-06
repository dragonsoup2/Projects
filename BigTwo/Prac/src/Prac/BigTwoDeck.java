package Prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BigTwoDeck implements Deck
{
	private ArrayList<Card> cardOwned;
	
	public BigTwoDeck()
	{
		cardOwned = new ArrayList<Card>();
	}
	
	public ArrayList<Card> cardCreate()
	{
		ArrayList<Integer> deckNum = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13));
		ArrayList<String> deckSuit = new ArrayList<String>(Arrays.asList("s", "h", "c", "d"));

		for(int r = 0; r < deckSuit.size(); r++)
		{
			for(int i = 0; i < deckNum.size(); i++)
			{
				BigTwoCard card = new BigTwoCard(deckNum.get(i), deckSuit.get(r));
				cardOwned.add(card);
			}
		}
		Long seed = System.nanoTime();
		Collections.shuffle(cardOwned, new Random(seed));
		
		return cardOwned;
	}
}
