package killer13;

import java.awt.GraphicsEnvironment;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import killer13.Hand;
import killer13.Deck;
import killer13.Card;


public class Killer {
	///DONT TOUCH LET ME COOK

	private static ArrayList<Hand> totalHands = new ArrayList<Hand>();
	private static Hand currentPlay = new Hand();
	private static int counter;
	static String text;
    //ConsoleView consoleView = new ConsoleView();

	
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
		System.out.println("This is your current hand: ");
		Scanner scanner = new Scanner(System.in);
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
	if (didAllPass()) {
		currentPlay.resetCombo();
	}
	if (currentPlay.combos().size() == 0 && input2.toUpperCase().equals("Y")) {
		if (player.type().equals("none")) {
			System.out.println("Retry, not a valid combo");
			player.printCombos();
			System.out.println("");
			playerTurn(player);
			return;
		} 
		else {
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
	else if (input2.toUpperCase().equals("Y")) {
		if (player.type().equals(currentPlay.type())) {
			if (player.combos().get(player.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) {
				for (int i = 0; i < player.combos().size(); i++) {
					for (int j = 0; j < player.totalCards().size(); j++) {
						if (player.combos().get(i).equals(player.totalCards().get(j))) {
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
			else {
				System.out.println("Retry, combo is lower tier than last play.");
				System.out.println("");
				playerTurn(player);
				return;
			}
		} 
		else if ((player.type().substring(player.type().length() - 4, player.type().length()).equals("bomb") || player.type().equals("4 of a Kind")) && currentPlay.type().equals("1 of a Kind")) {
			for (int i = 0; i < player.combos().size(); i++) {
				for (int j = 0; j < player.totalCards().size(); j++) 	{
					if (player.combos().get(i).equals(player.totalCards().get(j))){
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
		else if (player.combos().size() == 0) {
			System.out.println("You passed.");
			System.out.println("Current pile: " + currentPlay.combos());
			System.out.println("");
			counter++;
		} 
		else {
			System.out.println("Retry, combo does not match previous play.");
			playerTurn(player);
			return;
		}
	} 
	else if (input2.toUpperCase().equals("N")) {
		playerTurn(player);
		return;
	} 
	else {
		System.out.println("Type in Y/N, retry.");
		playerTurn(player);
		return;
	}
}
	
	private static void compTurn(Hand comp) {
		if (didAllPass()) {
			currentPlay.resetCombo();
		}
		comp.combos().clear();
		comp.sortAll();
		// Following 'if' executes if the computer has the first turn.
		if (currentPlay.combos().size() == 0 && comp.totalCards().size() != 0) {
			comp.addToCombo(comp.totalCards().get(0));
			comp.totalCards().remove(0);
			currentPlay.resetCombo();
			comp.transfer(currentPlay);
			System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
			System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
			System.out.println("Current pile: " + currentPlay.combos());
			counter = 0;
		} else {
			String typeToBeat = currentPlay.type();
			Card cardToBeat = currentPlay.combos().get(currentPlay.combos().size() - 1);
			boolean played = false;
			if (typeToBeat.length() >= 11 && typeToBeat.substring(typeToBeat.length() - 10).equals(" of a Kind")) {
				int ofAKind = Integer.parseInt(typeToBeat.substring(0, typeToBeat.length() - 10));
				int ofAKindCounter = 1;
				for (int i = 0; i < comp.totalCards().size() - 1; i++) {
					if (ofAKind == 1) {
						if (comp.totalCards().get(i).overallRank() > cardToBeat.overallRank()) {
							comp.addToCombo(comp.totalCards().get(i));
							played = true;
							comp.totalCards().remove(i);
							currentPlay.resetCombo();
							comp.transfer(currentPlay);
							counter = 0;
							System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
							System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
							System.out.println("Current pile: " + currentPlay.combos());
							break;
						} 
						else if (comp.totalCards().get(comp.totalCards().size() - 1).overallRank() > cardToBeat.overallRank()) {
							comp.addToCombo(comp.totalCards().get(comp.totalCards().size() - 1));
							played = true;
							comp.totalCards().remove(comp.totalCards().size() - 1);
							currentPlay.resetCombo();
							comp.transfer(currentPlay);
							counter = 0;
							System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
							System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
							System.out.println("Current pile: " + currentPlay.combos());
							break;
						}
						else{
							
						}
					} 
					else if (comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank()) {
						comp.addToCombo(comp.totalCards().get(i));
						ofAKindCounter++;
						if (ofAKindCounter == ofAKind)	{
							comp.addToCombo(comp.totalCards().get(i + 1));
							if (comp.combos().get(comp.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) {
								for (int j = 0; j < comp.combos().size(); j++) {
									for (int k = 0; k < comp.totalCards().size(); k++) {
										if (comp.combos().get(j).equals(comp.totalCards().get(k))) {
											comp.totalCards().remove(k);
										}
									}
								}
								played = true;
								currentPlay.resetCombo();
								comp.transfer(currentPlay);
								counter = 0;
								System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
								System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
								System.out.println("Current pile: " + currentPlay.combos());
								break;
							}
						}
					} 
					else {
						ofAKindCounter = 1;
						comp.resetCombo();
					}
				}
				if(!played){
					for(int a = 2; a < 5; a++){
						for(int b = 3; b < 7; b++){
							int bombType = a;
							int bombLength = b;
							int bombCounter = 0;
							if(bombType == 2){
								for(int i = 0; i < comp.totalCards().size() - 1; i++){
									if(comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank()){
										if(i >= 1 && comp.totalCards().get(i).getRank() == comp.totalCards().get(i - 1).getRank() + 1){
											bombCounter++;
											comp.addToCombo(comp.totalCards().get(i));
											comp.addToCombo(comp.totalCards().get(i + 1));
											i++;
										}
										else if(i < 1){
											bombCounter++;
											comp.addToCombo(comp.totalCards().get(i));
											comp.addToCombo(comp.totalCards().get(i + 1));
											i++;
										}
									}
									else if(i >= 1 && comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 1).getRank()){
										bombCounter = 0;
										comp.resetCombo();
									}
									if(bombCounter == bombLength){
										if (comp.combos().get(comp.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) {
											for (int j = 0; j < comp.combos().size(); j++) {
												for (int k = 0; k < comp.totalCards().size(); k++) {
													if (comp.combos().get(j).equals(comp.totalCards().get(k))) {
														comp.totalCards().remove(k);
													}
												}
											}
											played = true;
											currentPlay.resetCombo();
											comp.transfer(currentPlay);
											counter = 0;
											System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
											System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
											System.out.println("Current pile: " + currentPlay.combos());
											break;
										}
									}
								}
							}
							else if(bombType == 3){
								for(int i = 0; i < comp.totalCards().size() - 2; i++)	{
									if(comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 2).getRank()){
										if(i >= 1 && comp.totalCards().get(i).getRank() == comp.totalCards().get(i - 1).getRank() + 1){
											bombCounter++;
											comp.addToCombo(comp.totalCards().get(i));
											comp.addToCombo(comp.totalCards().get(i + 1));
											comp.addToCombo(comp.totalCards().get(i + 2));
											i += 2;
										}
										else if(i < 1){
											bombCounter++;
											comp.addToCombo(comp.totalCards().get(i));
											comp.addToCombo(comp.totalCards().get(i + 1));
											comp.addToCombo(comp.totalCards().get(i + 2));
											i += 2;
										}
									}
									else if(i >= 2 && i <= comp.totalCards().size() - 3)	{
										if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 1).getRank()){
											if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 2).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 2).getRank()){
												bombCounter = 0;
												comp.resetCombo();
											}
										}
									}
									if(bombCounter == bombLength){
										if (comp.combos().get(comp.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) {
											for (int j = 0; j < comp.combos().size(); j++) {
												for (int k = 0; k < comp.totalCards().size(); k++) {
													if (comp.combos().get(j).equals(comp.totalCards().get(k))) {
														comp.totalCards().remove(k);
													}
												}
											}
											played = true;
											currentPlay.resetCombo();
											comp.transfer(currentPlay);
											counter = 0;
											System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
											System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
											System.out.println("Current pile: " + currentPlay.combos());
											break;
										}
									}
								}
							}
							else if(bombType == 4){
								for(int i = 0; i < comp.totalCards().size() - 3; i++){
									if(comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 2).getRank() && comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 3).getRank()){
										if(i >= 1 && comp.totalCards().get(i).getRank() == comp.totalCards().get(i - 1).getRank() + 1){
											bombCounter++;
											comp.addToCombo(comp.totalCards().get(i));
											comp.addToCombo(comp.totalCards().get(i + 1));
											comp.addToCombo(comp.totalCards().get(i + 2));
											comp.addToCombo(comp.totalCards().get(i + 3));
											i += 2;
										}
										else if(i < 1){
											bombCounter++;
											comp.addToCombo(comp.totalCards().get(i));
											comp.addToCombo(comp.totalCards().get(i + 1));
											comp.addToCombo(comp.totalCards().get(i + 2));
											comp.addToCombo(comp.totalCards().get(i + 3));
											i += 2;
										}
									}
									else if(i >= 3 && i <= comp.totalCards().size() - 4)
									{
										if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 1).getRank())
										{
											if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 2).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 2).getRank())
											{
												if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 3).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 3).getRank())
												{
													bombCounter = 0;
													comp.resetCombo();
												}
											}
										}
									}
									if(bombCounter == bombLength)
									{
										if (comp.combos().get(comp.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) 
										{
											for (int j = 0; j < comp.combos().size(); j++) 
											{
												for (int k = 0; k < comp.totalCards().size(); k++) 
												{
													if (comp.combos().get(j).equals(comp.totalCards().get(k))) 
													{
														comp.totalCards().remove(k);
													}
												}
											}
											played = true;
											currentPlay.resetCombo();
											comp.transfer(currentPlay);
											counter = 0;
											System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
											System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
											System.out.println("Current pile: " + currentPlay.combos());
											break;
										}
									}
								}
							}
						}
					}
				}
				if (!played) 
				{
					counter++;
					System.out.println("Computer " + totalHands.indexOf(comp) + " has passed.");
				}
			}
			if (typeToBeat.length() >= 10 && typeToBeat.substring(typeToBeat.length() - 9).equals("-straight")) 
			{
				int straightType = Integer.parseInt(typeToBeat.substring(0, typeToBeat.length() - 9));
				int straightCounter = 1;
				for(int i = 0; i < comp.totalCards().size() - 1; i++)
				{
					if(comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank() - 1)
					{
						comp.addToCombo(comp.totalCards().get(i));
						straightCounter++;
						if(straightCounter == straightType)
						{
							comp.addToCombo(comp.totalCards().get(i + 1));
							if (comp.combos().get(comp.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) 
							{
								for (int j = 0; j < comp.combos().size(); j++) 
								{
									for (int k = 0; k < comp.totalCards().size(); k++) 
									{
										if (comp.combos().get(j).equals(comp.totalCards().get(k))) 
										{
											comp.totalCards().remove(k);
										}
									}
								}
								played = true;
								currentPlay.resetCombo();
								comp.transfer(currentPlay);
								counter = 0;
								System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
								System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
								System.out.println("Current pile: " + currentPlay.combos());
								break;
							}
						}
					}
					else if(comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank())
					{
						if(i != comp.totalCards().size() - 2)
						{
							i++;
						}
					}
					else
					{
						straightCounter = 1;
						comp.resetCombo();
					}
				}
				if(!played)
				{
					counter++;
					System.out.println("Computer " + totalHands.indexOf(comp) + " has passed.");
				}
			}
			if(typeToBeat.substring(typeToBeat.length() - 5, typeToBeat.length()).equals("-bomb"))
			{
				int bombType = Integer.parseInt(typeToBeat.substring(2, 3));
				int bombLength = Integer.parseInt(typeToBeat.substring(0, 1));
				int bombCounter = 0;
				if(bombType == 2)
				{
					for(int i = 0; i < comp.totalCards().size() - 1; i++)
					{
						if(comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank())
						{
							if(i >= 1 && comp.totalCards().get(i).getRank() == comp.totalCards().get(i - 1).getRank() + 1)
							{
								bombCounter++;
								comp.addToCombo(comp.totalCards().get(i));
								comp.addToCombo(comp.totalCards().get(i + 1));
								i++;
							}
							else if(i < 1)
							{
								bombCounter++;
								comp.addToCombo(comp.totalCards().get(i));
								comp.addToCombo(comp.totalCards().get(i + 1));
								i++;
							}
						}
						else if(i >= 1 && comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 1).getRank())
						{
							bombCounter = 0;
							comp.resetCombo();
						}
						if(bombCounter == bombLength)
						{
							if (comp.combos().get(comp.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) 
							{
								for (int j = 0; j < comp.combos().size(); j++) 
								{
									for (int k = 0; k < comp.totalCards().size(); k++) 
									{
										if (comp.combos().get(j).equals(comp.totalCards().get(k))) 
										{
											comp.totalCards().remove(k);
										}
									}
								}
								played = true;
								currentPlay.resetCombo();
								comp.transfer(currentPlay);
								counter = 0;
								System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
								System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
								System.out.println("Current pile: " + currentPlay.combos());
								break;
							}
						}
					}
				}
				else if(bombType == 3)
				{
					for(int i = 0; i < comp.totalCards().size() - 2; i++)
					{
						if(comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 2).getRank())
						{
							if(i >= 1 && comp.totalCards().get(i).getRank() == comp.totalCards().get(i - 1).getRank() + 1)
							{
								bombCounter++;
								comp.addToCombo(comp.totalCards().get(i));
								comp.addToCombo(comp.totalCards().get(i + 1));
								comp.addToCombo(comp.totalCards().get(i + 2));
								i += 2;
							}
							else if(i < 1)
							{
								bombCounter++;
								comp.addToCombo(comp.totalCards().get(i));
								comp.addToCombo(comp.totalCards().get(i + 1));
								comp.addToCombo(comp.totalCards().get(i + 2));
								i += 2;
							}
						}
						else if(i >= 2 && i <= comp.totalCards().size() - 3)
						{
							if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 1).getRank())
							{
								if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 2).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 2).getRank())
								{
									bombCounter = 0;
									comp.resetCombo();
								}
							}
						}
						if(bombCounter == bombLength)
						{
							if (comp.combos().get(comp.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) 
							{
								for (int j = 0; j < comp.combos().size(); j++) 
								{
									for (int k = 0; k < comp.totalCards().size(); k++) 
									{
										if (comp.combos().get(j).equals(comp.totalCards().get(k))) 
										{
											comp.totalCards().remove(k);
										}
									}
								}
								played = true;
								currentPlay.resetCombo();
								comp.transfer(currentPlay);
								counter = 0;
								System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
								System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
								System.out.println("Current pile: " + currentPlay.combos());
								break;
							}
						}
					}
				}
				else if(bombType == 4)
				{
					for(int i = 0; i < comp.totalCards().size() - 3; i++)
					{
						if(comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 2).getRank() && comp.totalCards().get(i).getRank() == comp.totalCards().get(i + 3).getRank())
						{
							if(i >= 1 && comp.totalCards().get(i).getRank() == comp.totalCards().get(i - 1).getRank() + 1)
							{
								bombCounter++;
								comp.addToCombo(comp.totalCards().get(i));
								comp.addToCombo(comp.totalCards().get(i + 1));
								comp.addToCombo(comp.totalCards().get(i + 2));
								comp.addToCombo(comp.totalCards().get(i + 3));
								i += 2;
							}
							else if(i < 1)
							{
								bombCounter++;
								comp.addToCombo(comp.totalCards().get(i));
								comp.addToCombo(comp.totalCards().get(i + 1));
								comp.addToCombo(comp.totalCards().get(i + 2));
								comp.addToCombo(comp.totalCards().get(i + 3));
								i += 2;
							}
						}
						else if(i >= 3 && i <= comp.totalCards().size() - 4)
						{
							if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 1).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 1).getRank())
							{
								if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 2).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 2).getRank())
								{
									if(comp.totalCards().get(i).getRank() != comp.totalCards().get(i + 3).getRank() && comp.totalCards().get(i).getRank() != comp.totalCards().get(i - 3).getRank())
									{
										bombCounter = 0;
										comp.resetCombo();
									}
								}
							}
						}
						if(bombCounter == bombLength)
						{
							if (comp.combos().get(comp.combos().size() - 1).overallRank() > currentPlay.combos().get(currentPlay.combos().size() - 1).overallRank()) 
							{
								for (int j = 0; j < comp.combos().size(); j++) 
								{
									for (int k = 0; k < comp.totalCards().size(); k++) 
									{
										if (comp.combos().get(j).equals(comp.totalCards().get(k))) 
										{
											comp.totalCards().remove(k);
										}
									}
								}
								played = true;
								currentPlay.resetCombo();
								comp.transfer(currentPlay);
								counter = 0;
								System.out.println("Computer " + totalHands.indexOf(comp) + " has played: " + comp.combos());
								System.out.println("Computer " + totalHands.indexOf(comp) + " currently has " + comp.totalCards().size() + " cards remaining.");
								System.out.println("Current pile: " + currentPlay.combos());
								break;
							}
						}
					}
				}
				if(!played)
				{
					counter++;
					System.out.println("Computer " + totalHands.indexOf(comp) + " has passed.");
				}
			}
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

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		
//		Deck d = new Deck();
//		d.shuffle();
//		Hand player = new Hand();
//		totalHands.add(player);
//		while (true) {
//			//String file = "";
//		    PrintStream ps = 
//		      new PrintStream(new BufferedOutputStream(new FileOutputStream(text, true)), true);
//		    System.setOut(ps);
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Welcome to Killer!");
//			System.out.println("How many players? (2-4)");
//			String string = scanner.nextLine();
//			if (string.equals("2")) {
//				Hand comp1 = new Hand();
//				totalHands.add(comp1);
//				for (int i = 0; i < 13; i++) {
//					player.insertCard(d.deal());
//					comp1.insertCard(d.deal());
//				}
//				break;
//			} 
//			else if (string.equals("3")) {
//				Hand comp1 = new Hand();
//				totalHands.add(comp1);
//				Hand comp2 = new Hand();
//				totalHands.add(comp2);
//				for (int i = 0; i < 13; i++) {
//					player.insertCard(d.deal());
//					comp1.insertCard(d.deal());
//					comp2.insertCard(d.deal());
//				}
//				break;
//			} 
//			
//			else if (string.equals("4")) {
//				Hand comp1 = new Hand();
//				totalHands.add(comp1);
//				Hand comp2 = new Hand();
//				totalHands.add(comp2);
//				Hand comp3 = new Hand();
//				totalHands.add(comp3);
//				for (int i = 0; i < 13; i++) {
//					player.insertCard(d.deal());
//					comp1.insertCard(d.deal());
//					comp2.insertCard(d.deal());
//					comp3.insertCard(d.deal());
//				}
//				break;
//			} 
//			else {
//				System.out.println("Retry");
//			}
//		}
//		
//		int index = totalHands.indexOf(firstTurn(totalHands));
//		while (isGameStillRunning()) 
//		{
//			if (index == 0) {
//				playerTurn(player);
//			} 
//			else {
//				compTurn(totalHands.get(index));
//			}
//			if (index == totalHands.size() - 1) {
//				index = -1;
//			}
//			index++;
//		}
//		if(index == 1) {
//			System.out.println("Congratulations! You are the winner!");
//		}
//		else if(index == 0){
//			System.out.println("Computer " + (totalHands.size() - 1) + " has won! You lost...");
//		}
//		else {
//			System.out.println("Computer " + (index - 1) + " has won! You lost...");
//		}
		
	
	public static void main(String[] args) throws IOException {
        Deck d = new Deck();
        d.shuffle();
        Hand player = new Hand();
        totalHands.add(player);

       ConsoleView consoleView = new ConsoleView();

        while (true) {
            System.out.println("Welcome to Killer!");
            System.out.println("How many players? (2-4)");
            String string = consoleView.getInput();
            if (string.equals("2")) {
                Hand comp1 = new Hand();
                totalHands.add(comp1);
                for (int i = 0; i < 13; i++) {
                    player.insertCard(d.deal());
                    comp1.insertCard(d.deal());
                }
                break;
            } else if (string.equals("3")) {
                Hand comp1 = new Hand();
                totalHands.add(comp1);
                Hand comp2 = new Hand();
                totalHands.add(comp2);
                for (int i = 0; i < 13; i++) {
                    player.insertCard(d.deal());
                    comp1.insertCard(d.deal());
                    comp2.insertCard(d.deal());
                }
                break;
            } else if (string.equals("4")) {
                Hand comp1 = new Hand();
                totalHands.add(comp1);
                Hand comp2 = new Hand();
                totalHands.add(comp2);
                Hand comp3 = new Hand();
                totalHands.add(comp3);
                for (int i = 0; i < 13; i++) {
                    player.insertCard(d.deal());
                    comp1.insertCard(d.deal());
                    comp2.insertCard(d.deal());
                    comp3.insertCard(d.deal());
                }
                break;
            } else {
                System.out.println("Retry");
            }
        }

        int index = totalHands.indexOf(firstTurn(totalHands));
        while (isGameStillRunning()) {
            if (index == 0) {
                playerTurn(player);
            } else {
                compTurn(totalHands.get(index));
            }
            if (index == totalHands.size() - 1) {
                index = -1;
            }
            index++;
        }
        if (index == 1) {
            System.out.println("Congratulations! You are the winner!");
        } else if (index == 0) {
            System.out.println("Computer " + (totalHands.size() - 1) + " has won! You lost...");
        } else {
            System.out.println("Computer " + (index - 1) + " has won! You lost...");
        }
    }
	
	
	
	
	
//		Console console = System.console();
//        if(console == null && !GraphicsEnvironment.isHeadless()){
//            String filename = Killer.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
//            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});
//        }else{
//            Killer.main(new String[0]);
//            System.out.println("Program has ended, please type 'exit' to close the console");
//        }
		
	}

