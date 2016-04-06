package Prac;

import java.util.ArrayList;
import java.util.Scanner;

public class BigTwoPlayer implements Player
{
	Rule rule;
	ArrayList<Card> card;
	ArrayList<Card> opponentCard;
	int myPlayedCard;
	String name;
	
	public BigTwoPlayer()
	{
		rule = new BigTwoRule();
		card = new ArrayList<Card>();
		opponentCard = new ArrayList<Card>();
		myPlayedCard = -1;
		name = "Yong";
		System.out.println(name + " created");
	}
	
	@Override
	public int cardCount() 
	{
		return getHand().size();
	}
	@Override
	public void setCard(ArrayList<Card> d) 
	{
		card = d;
		System.out.print("Your cards are ");
		for(int i = 0; i < card.size(); i++)
			System.out.print(card.get(i).getNumber()+card.get(i).getSuit() + " ");
		System.out.println();
	}

	@Override
	public ArrayList<Card> playCard() 
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Card> check;
		do
		{
			choice();
			if(myPlayedCard != -1)
			{
				return allPassed(myPlayedCard);
			}
			System.out.print("Choose your card(s) or type pass - ");
			String chosen = input.next();
			System.out.println("---------------------------------------------------");
			if(chosen.equals(("pass")))
			{
				return null;
			}
			else
			{
				String cardPutDown[] = chosen.split(",");
				check = cardCheck(cardPutDown);
				
				if(check == null)
				{
					System.out.println("---------------------------------------------------");
					System.out.println("Invalid move! Try again");
					System.out.println("---------------------------------------------------");
				}
			}
		}while(check == null);
		
		return check;
	}
	public ArrayList<Card> cardCheck(String[] choice)
	{
		int num = 0;
		ArrayList<Card> cardPlayed = new ArrayList<Card>();
		
		for(int i = 0; i < choice.length; i++)
		{
			num = Integer.parseInt(choice[i]) - 1;
			cardPlayed.add(card.get(num));	
		}
				if(rule.single(cardPlayed, opponentCard) || rule.pair(cardPlayed) || rule.triple(cardPlayed)
					|| rule.fourOfaKind(cardPlayed) || rule.straight(cardPlayed) || rule.flush(cardPlayed)
					|| rule.straightFlush(cardPlayed))
				{	
					for(int i = 0; i < cardPlayed.size(); i++)
					{
						cardPlayed.get(i).cardRemove(this);
					}
					myPlayedCard = num;
					return cardPlayed;
				}
				
		return null;
	}
	public ArrayList<Card> allPassed(int cardIndex)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Card> playCard = new ArrayList<Card>();
		if(card.get(cardIndex).getNumber() == opponentCard.get(0).getNumber() &&
				card.get(cardIndex).getSuit().equals(opponentCard.get(0).getSuit() ))
		{
			System.out.println("---------------------------------------------------");
			System.out.println("All other players passed!");
			System.out.print("Pick any card - ");
			String chosen = input.next();
			String choice[] = chosen.split(" ");
			int num;
			
			for(int i = 0; i < choice.length; i++)
			{
				num = Integer.parseInt(choice[i]) - 1;
				playCard.add(card.get(num));	
			}
		}
	
		return playCard;
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
	
	public void choice()
	{
		System.out.println("---------------------------------------------------");
		System.out.println("-----------------Your cards in hand----------------");
		for(int i = 0; i < card.size(); i++)
			System.out.print(card.get(i).getNumber()+card.get(i).getSuit() + " ");
		System.out.println();
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

}
