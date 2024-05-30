package killer13;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.net.URL;

public class Card {
	
//	private Image cardBack, aceSpades, aceClubs, aceDiamonds, aceHearts, jackSpades, jackClubs, jackHearts, jackDiamonds,
//	queenSpades, queenClubs, queenDiamonds, queenHearts, kingSpades, kingClubs, kingDiamonds, kingHearts, threeSpades, threeClubs,
//	threeDiamonds, threeHearts, fourSpades, fourClubs, fourDiamonds, fourHearts, fiveSpades, fiveClubs, fiveDiamonds, fiveHearts,
//	sixSpades, sixClubs, sixDiamonds, sixHearts, sevenSpades, sevenClubs, sevenDiamond, sevenHearts, eightSpades, eightClubs,
//	eightDiamonds, eightHearts, nineSpades, nineClubs, nineDiamonds, nineHearts, tenSpades, tenClubs, tenDiamonds, tenHearts,
//	twoSpades, twoClubs, twoDiamonds, twoHearts;
//	private Image image;
	private int suit;
	private int rank;
	private String[] suits = {"S", "C", "D", "H"};
	private String[] ranks = {"X", "X", "X", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
//	private double scaleWidth;
	
	
	public Card(int r, int s) {
		
		rank = r;
		suit = s;
		
//		cardBack = getImage("/imgs/" + "cardback.png");
//		aceSpades = getImage("/imgs/" + "aceofspades.png");
//		aceClubs = getImage("/imgs/" + "aceofclubs.png");
//		aceDiamonds = getImage("/imgs/" + "aceofdiamonds.png");
//		aceHearts = getImage("/imgs/" + "aceofhearts.png");
//		jackSpades = getImage("/imgs/" + "jackofspades.png");
//		jackClubs = getImage("/imgs/" + "jackofclubs.png");
//		jackHearts = getImage("/imgs/" + "jackofhearts.png");
//		jackDiamonds = getImage("/imgs/" + "jackofdiamonds.png");
//		queenSpades = getImage("/imgs/" + "queenofspades.png");
//		queenClubs = getImage("/imgs/" + "queenofclubs.png");
//		queenDiamonds = getImage("/imgs/" + "queenofdiamonds.png");
//		queenHearts = getImage("/imgs/" + "queenofhearts.png");
//		kingSpades = getImage("/imgs/" + "kingofspades.png");
//		kingClubs = getImage("/imgs/" + "kingofclubs.png");
//		kingDiamonds = getImage("/imgs/" + "kingofdiamonds.png");
//		kingHearts = getImage("/imgs/" + "kingofhearts.png");
//		threeSpades = getImage("/imgs/" + "3spades.png");
//		threeClubs = getImage("/imgs/" + "3clubs.png");
//		threeDiamonds = getImage("/imgs/" + "3diamonds.png");
//		threeHearts = getImage("/imgs/" + "3hearts.png");
//		fourSpades = getImage("/imgs/" + "4spades.png");
//		fourClubs = getImage("/imgs/" + "4clubs.png");
//		fourDiamonds = getImage("/imgs/" + "4diamonds.png");
//		fourHearts = getImage("/imgs/" + "4hearts.png");
//		fiveSpades = getImage("/imgs/" + "5spades.png");
//		fiveClubs = getImage("/imgs/" + "5clubs.png");
//		fiveDiamonds = getImage("/imgs/" + "5diamonds.png");
//		fiveHearts = getImage("/imgs/" + "5hearts.png");
//		sixSpades = getImage("/imgs/" + "6spades.png");
//		sixClubs = getImage("/imgs/" + "6clubs.png");
//		sixDiamonds = getImage("/imgs/" + "6diamonds.png");
//		sixHearts = getImage("/imgs/" + "6hearts.png");
//		sevenSpades = getImage("/imgs/" + "7spades.png"); 
//		sevenClubs = getImage("/imgs/" + "7clubs.png");
//		sevenDiamond = getImage("/imgs/" + "7diamonds.png");
//		sevenHearts = getImage("/imgs/" + "7hearts.png");
//		eightSpades = getImage("/imgs/" + "8spades.png");
//		eightClubs = getImage("/imgs/" + "8clubs.png");
//		eightDiamonds = getImage("/imgs/" + "8diamonds.png"); 
//		eightHearts = getImage("/imgs/" + "8hearts.png");
//		nineSpades = getImage("/imgs/" + "9spades.png");
//		nineClubs = getImage("/imgs/" + "9clubs.png"); 
//		nineDiamonds = getImage("/imgs/" + "9diamonds.png");
//		nineHearts = getImage("/imgs/" + "9hearts.png");
//		tenSpades = getImage("/imgs/" + "10spades.png");
//		tenClubs = getImage("/imgs/" + "10clubs.png");
//		tenDiamonds = getImage("/imgs/" + "10diamonds.png");
//		tenHearts = getImage("/imgs/" + "10hearts.png");
//		twoSpades = getImage("/imgs/" + "2spades.png");
//		twoClubs = getImage("/imgs/" + "2clubs.png");
//		twoDiamonds = getImage("/imgs/" + "2diamonds.png");
//		twoHearts = getImage("/imgs/" + "2hearts.png");
		
	}
	
	public int getRank() {
		return rank;
		
	}
	
	public int getSuit() {
		return suit;
	}
	
	public String rankToString(int r) {
		return ranks[r];
	}
	
	public String suitToString(int s) {
		return suits[s];
	}
	
	public String getSuitAsString() {
		return suitToString(suit);
	}
	
	public String getRankAsString() {
		return rankToString(rank);
	}
	
	public String toString() {
		return ranks[rank] + suits[suit];
	}
	
	public int overallRank() {
		int rank4 = rank*4;
		return rank4 + suit;
	}
	
	public boolean equals(Card c) {
		if(rank == c.getRank() && suit == c.getSuit()) {
			return true;
		} else {
			return false;
		}
	}
	

	

}
