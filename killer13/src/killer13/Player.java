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
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Player extends JPanel {
		Screens entry = new Screens();
		Screens play = new Screens();
       Stack <Screens> screen; 
   
      
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		 //screen.pop().homeScreen();

		///g.drawImage
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player f = new Player();
		
	}
	 public Player () {		
 		screen = new Stack <Screens>();
 		screen.add(play);
 		screen.add(entry);
 		if (play.getPlay() == true) {
 			screen.pop();
 		}
 		if (screen.peek().equals(entry)) {
 			entry.homeScreen();
 		} else if (screen.peek().equals(play)) {
 			//play.playScreen();
 			
 		} else {
 			return;
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
	
	 
	
	//actions for buttons
	
}