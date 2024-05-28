package killer13;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import killer13.Card;
import killer13.Randomizer;

public class Deck {
	private ArrayList <Card> deck;
//DONT TOUCH LET ME COOK
	
	public Deck() {
		deck = new ArrayList<Card>();
		for(int i = 3; i < 16; i++) {
			for(int j = 0; j < 4; j++) {
				Card c = new Card(i, j);
				deck.add(c);
			}
		}
		
	}
	
	
	public Card deal(){
		
		return deck.remove(0);
	}
	
	public ArrayList<Card> getCards(){
		
		return deck;
	}

	public void shuffle(){
		
        for(int i = 0; i < deck.size(); i++){
            int randomIndex = Randomizer.nextInt(52);
            Card x = deck.get(i);
            Card y = deck.get(randomIndex);
            
            deck.set(i, y);
            deck.set(randomIndex, x);
        }
    }

	public boolean deckEmpty(){
		if(deck.size() == 0)
		{
			return true;
		}
		return false;
	}
}
	
	
	
	
	
	
	//public void initializeDeck() {  
		
		//creating deck with cards with numbers assigned to them
		
		//adding to deck face cards, with assigned values
//		deck.add(new Card(this.getImage("title.png"), "Spades", 9));
//		System.out.println("bark");
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\jackofclubs.png"), "Clubs", 9));
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\jackofdiamonds.png"), "Diamonds", 9));
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\jackofhearts.png"), "Hearts", 9));
//        
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\queenofspades.png"), "Spades", 10));
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\queenofclubs.png"), "Clubs", 10));
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\queenofdiamonds.png"), "Diamonds", 10));
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\queenofhearts.png"), "Hearts", 10));
//        
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\kingofspades.png"), "Spades", 11));
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\kingofclubs.png"), "Clubs", 11));
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\kingofdiamonds.png"), "Diamonds", 11));
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\kingofhearts.png"), "Hearts", 11));
//        
//        deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\aceofspades.png"), "Spades", 12));
//		deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\aceofclubs.png"), "Clubs", 12));
//		deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\aceofdiamonds.png"), "Diamonds", 12));
//		deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\aceofhearts.png"), "Hearts", 12));
//		
//		deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\2spades.png"), "Spades", 13));
//		deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\2clubs.png"), "Clubs", 13));
//		deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\2Diamonds.png"), "Diamonds", 13));
//		deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\2Hearts.png"), "Hearts", 13));
//		
//		//number cards - assigning values
//		for (int i = 3; i <= 10; i++){
//			
//			//adding to deck
//            deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\" + i + "spades.png"), "Spades", i-2));
//            deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\" + i + "clubs.png"), "Clubs", i-2));
//            deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\" + i + "diamonds.png"), "Diamonds", i-2));
//            deck.add(new Card(getImage("H:\\git\\cardGame\\killer13\\images\\" + i + "hearts.png"), "Hearts", i-2));
//        }
//	}
	

	
	

