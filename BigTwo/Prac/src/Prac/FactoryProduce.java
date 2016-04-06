package Prac;

public class FactoryProduce 
{
	public static CardDeck getFactory(String factoryType)
	{
		if(factoryType.equalsIgnoreCase("card"))
			return new CardFactory();
		else if(factoryType.equalsIgnoreCase("deck"))
			return new DeckFactory();
		
		return null;	
	}

}
