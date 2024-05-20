package killer13;

import java.awt.Graphics;
import java.util.ArrayList;


public class Hand {
	private ArrayList<Card> curr;
	private ArrayList<Card> combos;
	private ArrayList<Card> enemy;
	private Deck d = new Deck();
	
	public Hand() {
		curr = d.dealHand(13);
		combos = new ArrayList<Card>();
		enemy = d.dealHand(13);		
		
	}
	
	public ArrayList<Card> combos(){
		return combos;
	}

	public ArrayList<Card> getCurr() {
		return curr;
	}

	public void setCurr(ArrayList<Card> curr) {
		this.curr = curr;
	}

	public ArrayList<Card> getCombos() {
		return combos;
	}

	public void setCombos(ArrayList<Card> combos) {
		this.combos = combos;
	}

	public ArrayList<Card> getEnemy() {
		return enemy;
	}

	public void setEnemy(ArrayList<Card> enemy) {
		this.enemy = enemy;
	}


	
	
	public void paintCurr(Graphics g) {
		for (int i = 0; i < curr.size(); i++) {
			
		}
	}
	
	
}
