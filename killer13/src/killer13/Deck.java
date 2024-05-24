package killer13;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	//shuffle method
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	
	public Card drawCard() {
		if(deck.isEmpty()) {
			return null;
		}
		return deck.remove(deck.size() - 1);
	}
	
	public ArrayList<Card> dealHand(int numCards){
		ArrayList<Card> hand = new ArrayList<>();
		for(int i = 0; i < numCards; i++) {
			hand.add(drawCard());
		}
		return hand;
	}
	
	//in the main/driver class, player1 = new Player(deck.dealHand(13)); to draw 13 cards   assuming deck = new Deck(); in the main class
	
	public ArrayList<Card> getDeck() {
		return deck;
	}


	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Deck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
	
	
}
