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


public class Player extends JPanel implements ActionListener{
		JFrame fr = new JFrame("killer");
		JPanel jp = new JPanel(new BorderLayout());
        JButton rules = new JButton();
        JButton play = new JButton(); 
        JButton exit = new JButton();
        JButton title = new JButton ();
        Stack <Screens> screen = new Stack <>();
        
	public void paint(Graphics g) {
		super.paintComponent(g);
		///g.drawImage
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player f = new Player();
		

	}
	public Player () {		
		try {
        	fr.setSize(617, 360);
    		fr.setResizable(true);
    		
    		ImageIcon rule = new ImageIcon("rules.png");
    	
    		//resizing play button
    		ImageIcon plays = new ImageIcon("play.png");
    		Image p = plays.getImage();
    		Image newPlay = p.getScaledInstance( 150, 75,  java.awt.Image.SCALE_SMOOTH ) ;
    		plays = new ImageIcon(newPlay);
    		
    		
    		//resizing exit button
    		ImageIcon exits = new ImageIcon("exit.png");
    		Image e = exits.getImage();
    		Image newExit = e.getScaledInstance( 150, 75,  java.awt.Image.SCALE_SMOOTH ) ;
    		exits = new ImageIcon(newExit);
    		
    		
        	ImageIcon titly = new ImageIcon("title.png");
        	Image t = titly.getImage();
    		//Image newTitle = t.getScaledInstance( 600, 300,  java.awt.Image.SCALE_SMOOTH ) ;

        	titly = new ImageIcon (t);
        	
        	
        	title = new JButton (titly);
            title.setContentAreaFilled(false);
            title.setRolloverEnabled(false);
            title.setBorderPainted(false);
            title.setFocusPainted(false);
            title.setPreferredSize(new Dimension (550, 300));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            title.setVerticalAlignment(SwingConstants.CENTER);
       
    		fr.setContentPane(jp);
            fr.setLayout(new FlowLayout());
            fr.pack();
           
            //rules
            rules = new JButton(rule);
            rules.setContentAreaFilled(false);
            rules.setRolloverEnabled(false);
            rules.setBorderPainted(false);
            rules.setFocusPainted(false);
            rules.setPreferredSize(new Dimension (150, 75));
            rules.setHorizontalAlignment(SwingConstants.LEFT);
            rules.setVerticalAlignment(SwingConstants.CENTER);
            rules.setActionCommand("rules");

            //play
            play = new JButton (plays);
            play.setPreferredSize(new Dimension (150, 75));
            play.setContentAreaFilled(false);
            play.setRolloverEnabled(false);
            play.setBorderPainted(false);
            play.setFocusPainted(false);
            play.setHorizontalAlignment(SwingConstants.CENTER);
            play.setVerticalAlignment(SwingConstants.CENTER );
            play.setActionCommand("play");
            
            
            
            
            //exit
            exit = new JButton (exits);
            exit.setContentAreaFilled(false);
            exit.setRolloverEnabled(false);
            exit.setBorderPainted(false);
            exit.setFocusPainted(false);
            exit.setPreferredSize(new Dimension (150, 75));
            exit.setHorizontalAlignment(SwingConstants.RIGHT);
            exit.setVerticalAlignment(SwingConstants.CENTER);
            exit.setActionCommand("exit");
            
        	ImageIcon backy = new ImageIcon(ImageIO.read(new File("fronty.PNG")));
        	Image b = backy.getImage();
        	Image newB = b.getScaledInstance( 1000, 800, java.awt.Image.SCALE_DEFAULT ) ;
        	backy = new ImageIcon (newB);
        	JLabel back = new JLabel(backy);
        	
            //back.setSize(1000, 800);
        	fr.setContentPane(back);
            fr.getContentPane().add(title);
        	fr.getContentPane().add(rules);
            fr.getContentPane().add(play);
            fr.getContentPane().add(exit);
            this.setLayout(null);
            jp.setLayout(null);
            title.setBounds(595, 195, 800, 400);
            rules.setBounds(600, 400, 400, 400);
            play.setBounds(750, 400, 400, 400);
            exit.setBounds(950, 400, 400, 400);
            fr.setLocationRelativeTo(null);
            fr.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            play.addActionListener(this);
        	exit.addActionListener(this);
        	rules.addActionListener(this);
    		fr.setVisible(true);
            
        } catch (IOException er) {
            er.printStackTrace();
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
	
	 
	public void actionPerformed(ActionEvent e) {
		//repaint(g);
		// TODO Auto-generated method stub
		if ("rules".equals(e.getActionCommand())) {
			//JOPTIONPANE?
		} else if ("play".equals(e.getActionCommand())) {
			// call play screen
		} else if ("exit".equals(e.getActionCommand())) {
			System.exit(0);
		}else {
			
		}
	}
	//actions for buttons
	
}