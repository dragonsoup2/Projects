package Prac;

public class CardFactory extends CardDeck
{

	@Override
	Card createCard(String gameType) 
	{
		if(gameType.equalsIgnoreCase("bigtwo"))
				return new BigTwoCard();
		else if(gameType.equalsIgnoreCase("crazyeight"))
			return new CrazyEightCard();
		
		return null;
	}

	@Override
	Deck createDeck(String gameType) 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
