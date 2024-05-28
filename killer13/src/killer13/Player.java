package killer13;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Player extends JPanel {
	Screens entry = new Screens();
	Screens play = new Screens();
    Stack <Screens> screen; 
//    Panel back = new Panel("H:\\git\\cardGame\\killer13\\images\\jackofspades.png");
    private Deck deck;
    private Hand h = new Hand();
//    private ArrayList<Card> playing = h.getCurr();
//    private ArrayList<Card> opp = h.getEnemy();
       public void paint(Graphics g) {
   		super.paintComponent(g);
   		Graphics2D g2 = (Graphics2D) g;
   		// back.paint(g);
//   		Card card = deck.drawCard();
//   		if(card != null) {
//   			g2.drawImage(card.getImage(), 10, 10, this);
//   		}	
   			
   			
   		
   		//screen.pop().homeScreen();

   		///g.drawImage
   		
   	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player player1 = new Player();
		
		
	}
	
	
	 public Player () {	
		deck = new Deck();
 		screen = new Stack <Screens>();
 		screen.add(play);
 		screen.add(entry);
		entry.homeScreen();
		if (play.getPlay() == true) {
 			screen.pop();
 		}
 		if (screen.peek().equals(play)) {
			System.exit(0);
 			System.out.println("kay");
 			
 		} else {
 			System.out.println("hey");
 		}
 		
	 }
	
        //add buttons to frame
        

        //fr.setUndecorated(true);
	
	protected ImageIcon createImageIcon(String path,
            String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	protected static ImageIcon createImageIcon(String path) {
	    java.net.URL imgURL = Player.class.getResource(path);
	   //error handling omitted for clarity...
	    return new ImageIcon(imgURL);
	}
	
    
    
}
	
	//actions for buttons
	
