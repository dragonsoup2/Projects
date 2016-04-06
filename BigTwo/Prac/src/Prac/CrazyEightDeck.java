package Prac;

import java.util.ArrayList;
import java.util.Arrays;

public class CrazyEightDeck implements Deck
{
	public CrazyEightDeck()
	{
		//rank of number and suit of cards in your game would be different from Big two
		// so you can change those deckNum and deckSuit
		// in deckNum, 13 represents '2' in bigtwo which is highest rank. and 3 represents '1'
		//deckNum  = new ArrayList<Integer>(Arrays.asList(12,13,1,2,3,4,5,6,7,8,9,10,11));
		//deckSuit = new ArrayList<String>(Arrays.asList("s", "h", "c", "d"));
	}

	@Override
	public ArrayList<Card> cardCreate() {
		// TODO Auto-generated method stub
		return null;
	}
}
