package killer13;

import java.util.ArrayList;

public class Killer {
	
	private static ArrayList<Hand> totalHands = new ArrayList<Hand>();
	private Hand currentPlay = new Hand();
	private static int counter;
	
	private static Hand firstTurn(ArrayList<Hand> totalHands) {
		for(int i = 3; i <= 15; i++) {
			for(int j = 0; j <= 3; j++) {
				for(Hand hand : totalHands) {
					for(int x = 0; x < hand.totalCards().size(); x++) {
						if(hand.totalCards().get(x).getRank() == i && hand.totalCards().get(x).getSuit() == j) {
							return hand;
						}
					}
				}
			}
		}
		return totalHands.get(0);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
