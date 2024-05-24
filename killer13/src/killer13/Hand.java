package killer13;

import java.awt.Graphics;
import java.util.ArrayList;

import killer13.Card;
import killer13.Hand;


public class Hand {
	private ArrayList<Card> totalCards;
	private ArrayList<Card> combos;
	
	
	
	public Hand() {
		totalCards = new ArrayList<Card>();
		combos = new ArrayList<Card>();
		
	}
	
	public ArrayList<Card> combos(){
		return combos;
	}

	public ArrayList<Card> totalCards() {
		return totalCards;
	}

	public void insertCard(Card c) 
	{
		totalCards.add(c);
	}

	public void addToCombo(Card c) 
	{
		combos.add(c);
	}

	public void printHand() 
	{
		System.out.println(totalCards);
	}

	public void resetCombo() 
	{
		combos.clear();
	}

	public String type() 
	{
		// Some dumb way of figuring out how many of a kind
		sortAll();
		if (combos.size() == 1) 
		{
			return "1 of a Kind";
		}
		int a = 0;
		while (a < combos.size() - 1) 
		{
			if (combos.get(a).getRank() == combos.get(a + 1).getRank()) 
			{
				a++;
			} 
			else 
			{
				a = 0;
				break;
			}
		}
		if (a == 1) 
		{
			return "2 of a Kind";
		}
		if (a == 2) 
		{
			return "3 of a Kind";
		}
		if (a == 3) 
		{
			return "4 of a Kind";
		}
		return straightType();
	}

	public void sortAll() 
	{
		int n = totalCards.size();
		for (int i = 0; i < n - 1; i++) 
		{
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
			{
				if (totalCards.get(j).overallRank() < totalCards.get(min_idx).overallRank()) 
				{
					min_idx = j;
				}
			}
			Card temp = totalCards.get(min_idx);
			totalCards.set(min_idx, totalCards.get(i));
			totalCards.set(i, temp);
		}
		int x = combos.size();
		for (int i = 0; i < x - 1; i++) 
		{
			int min_idx = i;
			for (int j = i + 1; j < x; j++)
			{
				if (combos.get(j).overallRank() < combos.get(min_idx).overallRank()) 
				{
					min_idx = j;
				}
			}
			Card temp2 = combos.get(min_idx);
			combos.set(min_idx, combos.get(i));
			combos.set(i, temp2);
		}
	}

	public void transfer(Hand player) 
	{
		for (Card c : combos) 
		{
			player.addToCombo(c);
		}
	}

	public void resetTotalCards() 
	{
		totalCards.clear();
	}

	public void printCombos() 
	{
		System.out.println(combos);
	}

	public String straightType() 
	{
		// Pre-condition: comboList must be sorted by rank
		int x = 0;
		if (combos.size() >= 3) 
		{
			while (x < combos.size() - 1) 
			{
				if (combos.get(x).getRank() == combos.get(x + 1).getRank() - 1) 
				{
					x++;
				} 
				else 
				{
					x = 0;
					break;
				}
			}
			if (x >= 2)
			{
				return (x + 1) + "-straight";
			}
		}
		return bomb();
	}

	public String bomb()
	{
		// check for bomb (3 straight of doubles)
		
		int doublesCounter = 0;
		int triplesCounter = 0;
		int quadsCounter = 0;
		if (combos.size() >= 6) 
		{
			for(int i = 0; i < combos.size() - 1; i += 2)
			{
				if(combos.size() % 2 == 1)
				{
					break;
				}
				if(combos.get(i).getRank() == combos.get(i + 1).getRank())
				{
					if(i >= 2 && combos.get(i).getRank() == combos.get(i - 1).getRank() + 1)
					{
						doublesCounter++;
					}
					else if(i < 2)
					{
						doublesCounter++;
					}
					else
					{
						doublesCounter = 0;
						break;
					}
				}
				else
				{
					doublesCounter = 0;
					break;
				}
			}
			for(int j = 0; j < combos.size() - 2; j += 3)
			{
				if(combos.size() == 9 || combos.size() == 12)
				{
					if(combos.get(j).getRank() == combos.get(j + 1).getRank() && combos.get(j).getRank() == combos.get(j + 2).getRank())
					{
						if(j >= 3 && combos.get(j).getRank() == combos.get(j -  1).getRank() + 1)
						{
							triplesCounter++;
						}
						else if(j < 3)
						{
							triplesCounter++;
						}
						else
						{
							triplesCounter = 0;
							break;
						}
					}
					else
					{
						triplesCounter = 0;
						break;
					}
				}
				else
				{
					break;
				}
			}
			for(int k = 0; k < combos.size() - 3; k += 4)
			{
				if(combos.size() != 12)
				{
					break;
				}
				if(combos.get(k).getRank() == combos.get(k + 1).getRank() && combos.get(k).getRank() == combos.get(k + 2).getRank() && combos.get(k).getRank() == combos.get(k + 3).getRank())
				{
					if(k >= 4 && combos.get(k).getRank() == combos.get(k - 1).getRank() + 1)
					{
						quadsCounter++;
					}
					else if(k < 4)
					{
						quadsCounter++;
					}
					else
					{
						quadsCounter = 0;
						break;
					}
				}
				else
				{
					quadsCounter = 0;
					break;
				}
			}
			if(quadsCounter >= 3)
			{
				return quadsCounter + " 4-bomb";
			}
			else if(triplesCounter >= 3)
			{
				return triplesCounter + " 3-bomb";
			}
			else if(doublesCounter >= 3)
			{
				return doublesCounter + " 2-bomb";
			}
			else
			{
				return "none";
			}
		} 
		else 
		{
			return "none";
		}
	}
}
