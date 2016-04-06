package Prac;

public class DeckFactory extends CardDeck
{

	@Override
	Card createCard(String gameType) 
	{
		return null;
	}

	@Override
	Deck createDeck(String gameType) 
	{
		if(gameType.equalsIgnoreCase("bigtwo"))
			return new BigTwoDeck();
		else if(gameType.equalsIgnoreCase("crazyeight"))
			return new CrazyEightDeck();
	
		return null;
	}

}
