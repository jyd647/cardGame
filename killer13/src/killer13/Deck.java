package killer13;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private ArrayList <Card> deck;
	private ArrayList <Combo> ways;
	
	
	public Deck() {
		deck = new ArrayList<>();
		initializeDeck(); 
		System.out.println("meow");
	}
	
	
	private void initializeDeck() {
		
		//creating deck with cards with numbers assigned to them
		
		//adding to deck face cards, with assigned values
		deck.add(new Card(getImage("/imgs/jackofspades.png"), "Spades", 9));
        deck.add(new Card(getImage("/imgs/jackofclubs.png"), "Clubs", 9));
        deck.add(new Card(getImage("/imgs/jackofdiamonds.png"), "Diamonds", 9));
        deck.add(new Card(getImage("/imgs/jackofhearts.png"), "Hearts", 9));
        
        deck.add(new Card(getImage("/imgs/queenofspades.png"), "Spades", 10));
        deck.add(new Card(getImage("/imgs/queenofclubs.png"), "Clubs", 10));
        deck.add(new Card(getImage("/imgs/queenofdiamonds.png"), "Diamonds", 10));
        deck.add(new Card(getImage("/imgs/queenofhearts.png"), "Hearts", 10));
        
        deck.add(new Card(getImage("/imgs/kingofspades.png"), "Spades", 11));
        deck.add(new Card(getImage("/imgs/kingofclubs.png"), "Clubs", 11));
        deck.add(new Card(getImage("/imgs/kingofdiamonds.png"), "Diamonds", 11));
        deck.add(new Card(getImage("/imgs/kingofhearts.png"), "Hearts", 11));
        
        deck.add(new Card(getImage("/imgs/aceofspades.png"), "Spades", 12));
		deck.add(new Card(getImage("/imgs/aceofclubs.png"), "Clubs", 12));
		deck.add(new Card(getImage("/imgs/aceofdiamonds.png"), "Diamonds", 12));
		deck.add(new Card(getImage("/imgs/aceofhearts.png"), "Hearts", 12));
		
		//deck.add(new Card(getImage("/imgs/2hearts.png"), "Hearts", 13));)
		
		//number cards - assigning values
		for (int i = 3; i <= 10; i++) {
//			if(i == 2) {
//				i = 13;
//			} else if(i == 3) {
//				i = 1;
//			} else if(i == 4) {
//				i = 2;
//			} else if(i == 5) {
//				i = 3;
//			} else if(i == 6) {
//				i = 4;
//			} else if(i == 7) {
//				i = 5;
//			} else if(i == 8) {
//				i = 6;
//			} else if(i == 9) {
//				i = 7;
//			} else if(i == 10) {
//				i = 8;
//			}
			
			//adding to deck
            deck.add(new Card(getImage("/imgs/" + i + "spades.png"), "Spades", i-2));
            deck.add(new Card(getImage("/imgs/" + i + "clubs.png"), "Clubs", i-2));
            deck.add(new Card(getImage("/imgs/" + i + "diamonds.png"), "Diamonds", i-2));
            deck.add(new Card(getImage("/imgs/" + i + "hearts.png"), "Hearts", i-2));
        }
		
		
		
	
	}


	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	
	public Card drawCard() {
		if(deck.isEmpty()) {
			return null;
		}
		return deck.remove(deck.size() - 1);
	}
	
	public List<Card> dealHand(int numCards){
		List<Card> hand = new ArrayList<>();
		for(int i = 0; i < numCards; i++) {
			hand.add(drawCard());
		}
		return hand;
	}
	
	//in the main/driver class, player1 = new Player(deck.dealHand(13)); to draw 13 cards   assuming deck = new Deck(); in the main class
	
	
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	
	
	
	
}
