package Prac;

import java.util.ArrayList;

//create players and get a deck of cards for playing
public class BigTwoComponent implements Component
{
	private PlayerType playerType; // decide players for bigtwo or crazy8
	private String gameType; // decide game for bigtwo or crazy8
	private CardDeck cardDeck;
	private Card card;
	private Deck deck;
	private ArrayList<Player> players;
	
	public BigTwoComponent(String game)
	{
		gameType = game;	
		playerType = new PlayerType();
		players = new ArrayList<Player>();
		cardDeck = FactoryProduce.getFactory("card");
		card = cardDeck.createCard(gameType);//choose type of card(bigtwo or crazyeight)
		
	}
	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	public void setCard()
	{
		cardDeck = FactoryProduce.getFactory("deck");
		Deck deck = cardDeck.createDeck(gameType);//inherited from Deck(not an interface!)
		ArrayList<Card> card = deck.cardCreate();
		int i = 0;
		int player = 0;
		
		while(i < card.size())
		{
			if(players.get(player).getHand().size() != 13)
				players.get(player).getHand().add(card.get(i++));
			else
				player++;
		}
		
	}
	public void setPlayers()
	{
		playerType.createPlayer(gameType);//create a player(you)
		playerType.createAI(gameType);//create AI
		players = playerType.getPlayers(); //save the players in bigtwocomponent players
	}
}
