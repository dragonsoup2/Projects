package Prac;

import java.util.ArrayList;

public abstract class AIType implements Player
{
	protected String name;
	protected Player aiPlayer;
	protected ArrayList<Card> card;
	
	public AIType(Player aip, String n)
	{
		this.aiPlayer = aip;
		card = new ArrayList<Card>();
		name = n;
	}
}

