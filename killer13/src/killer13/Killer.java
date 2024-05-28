package killer13;

import java.util.ArrayList;
import java.util.Scanner;

import killer13.Hand;


public class Killer {
	///DONT TOUCH LET ME COOK
	
	private static ArrayList<Hand> totalHands = new ArrayList<Hand>();
	private static Hand currentPlay = new Hand();
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
	
	private static boolean isInHand(Hand player, String cardInput) {
		for (Card card : player.totalCards()) 
		{
			if (card.toString().equals(cardInput)) 
			{
				return true;
			}
		}
		return false;
	}
	
	private static int stringToRank(String x) {
		
		int returnedRank = -1;
		
		switch (x.toUpperCase()) {
		
		case "J":
			returnedRank = 11;
			break;
		case "Q":
			returnedRank = 12;
			break;
		case "K":
			returnedRank = 13;
			break;
		case "A":
			returnedRank = 14;
			break;
		case "2":
			returnedRank = 15;
			break;
		default:
			returnedRank = Integer.parseInt(x);
			break;
			
		}
		return returnedRank;
	}
	
	private static int stringToSuit(String x) {
		int returnedSuit = -1;
		switch (x.toUpperCase()) {
		case "S":
			returnedSuit = 0;
			break;
		case "C":
			returnedSuit = 1;
			break;
		case "D":
			returnedSuit = 2;
			break;
		case "H":
			returnedSuit = 3;
			break;
		default:
			System.out.println("Invalid suit. Try again.");
			break;
		}
		return returnedSuit;
	}
	
	private static void playerTurn(Hand player) {
		player.sortAll();
		player.combos().clear();
		Scanner scanner = new Scanner(System.in);
		System.out.println("This is your current hand: ");
		player.printHand();
		if(currentPlay.combos().size() != 0) {
			System.out.println("This was the previous play: ");
			currentPlay.printCombos();
		}
		while(true) {
			System.out.println("What card do you want to add to your combo?");
			System.out.println("If you want to pass or finish your combo, press enter.");
			String cardInput = scanner.nextLine();
		 if(cardInput.equals("")) {
			break;
		} else if(cardInput.length()> 1 && cardInput.length() < 4) {
			String rank = cardInput.substring(0, cardInput.length() - 1);
			String suit = cardInput.substring(cardInput.length() - 1, cardInput.length());
			Card input = new Card(stringToRank(rank), stringToSuit(suit));
			if (isInHand(player, input.toString()) && cardInput.length() <= 3) 
			{
				player.addToCombo(input);
				player.sortAll();
				player.printCombos();
			} 
			else 
			{
				System.out.println("Retry, invalid card.");
				System.out.println("");
			}
		} else {
			System.out.println("Retry, invalid card.");
			playerTurn(player);
			return;
		}
	}
	System.out.println("Are you sure you want to play this? Y/N");
	String input2 = scanner.nextLine();
	if (didAllPass()) 
	{
		currentPlay.resetCombo();
	}
	if (currentPlay.combos().size() == 0 && input2.toUpperCase().equals("Y")) 
	{
		if (player.type().equals("none")) 
		{
			System.out.println("Retry, not a valid combo");
			player.printCombos();
			System.out.println("");
			playerTurn(player);
			return;
		} 
		else 
		{
			for (int i = 0; i < player.combos().size(); i++) 
			{
				for (int j = 0; j < player.totalCards().size(); j++) 
				{
					if (player.combos().get(i).equals(player.totalCards().get(j))) 
					{
						player.totalCards().remove(j);
					}
				}
			}
			System.out.println("You played a " + player.type() + " successfully.");
			System.out.println("Current pile: " + player.combos());
			System.out.println("");
			currentPlay.resetCombo();
			player.transfer(currentPlay);
			counter = 0;
		}
	} 
	else if (input2.toUpperCase().equals("Y")) 
	{
		if (player.type().equals(currentPlay.type())) 
		{
			if (player.combos().get(player.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) 
			{
				for (int i = 0; i < player.combos().size(); i++) 
				{
					for (int j = 0; j < player.totalCards().size(); j++) 
					{
						if (player.combos().get(i).equals(player.totalCards().get(j))) 
						{
							player.totalCards().remove(j);
						}
					}
				}
				currentPlay.resetCombo();
				player.transfer(currentPlay);
				System.out.println("You played a " + player.type() + " successfully.");
				System.out.println("Current pile: " + player.combos());
				System.out.println("");
				counter = 0;
			} 
			else 
			{
				System.out.println("Retry, combo is lower tier than last play.");
				System.out.println("");
				playerTurn(player);
				return;
			}
		} 
		else if ((player.type().substring(player.type().length() - 4, player.type().length()).equals("bomb") || player.type().equals("4 of a Kind")) && currentPlay.type().equals("1 of a Kind")) 
		{
			for (int i = 0; i < player.combos().size(); i++) 
			{
				for (int j = 0; j < player.totalCards().size(); j++) 
				{
					if (player.combos().get(i).equals(player.totalCards().get(j)))
					{
						player.totalCards().remove(j);
					}
				}
			}
			currentPlay.resetCombo();
			player.transfer(currentPlay);
			System.out.println("You played a " + player.type() + " successfully.");
			System.out.println("Current pile: " + player.combos());
			System.out.println("");
			counter = 0;
		} 
		else if (player.combos().size() == 0) 
		{
			System.out.println("You passed.");
			System.out.println("Current pile: " + currentPlay.combos());
			System.out.println("");
			counter++;
		} 
		else 
		{
			System.out.println("Retry, combo does not match previous play.");
			playerTurn(player);
			return;
		}
	} 
	else if (input2.toUpperCase().equals("N")) 
	{
		playerTurn(player);
		return;
	} 
	else 
	{
		System.out.println("Type in Y/N, retry.");
		playerTurn(player);
		return;
	}
}
	
	private static boolean isGameStillRunning() 
	{
		for (Hand hand : totalHands) 
		{
			if (hand.totalCards().size() == 0) 
			{
				return false;
			}
		}
		return true;
	}

	private static boolean didAllPass() 
	{
		if (counter == totalHands.size() - 1) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
