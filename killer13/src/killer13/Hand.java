package killer13;

import java.util.ArrayList;


public class Hand {
	private ArrayList<Card> curr;
	private ArrayList<Card> combos;
	
	
	public Hand() {
		
		combos = new ArrayList<Card>();
		
		
	}
	
	public ArrayList<Card> combos(){
		return combos;
	}

}
