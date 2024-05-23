package killer13;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Screens extends JPanel implements ActionListener{

	
	 public JFrame fr;
	 public JPanel jp;
	 private boolean playing;
	 public Screens() {
		 fr = new JFrame("killer");
		 jp = new JPanel(new BorderLayout());
	 }
	public void homeScreen() {
		try {
			JButton rules = new JButton();
			JButton play = new JButton(); 
			JButton exit = new JButton();
			JButton title = new JButton ();
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
    		Image ex = exits.getImage();
    		Image newExit = ex.getScaledInstance( 150, 75,  java.awt.Image.SCALE_SMOOTH ) ;
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
            fr.setLayout(null);
            jp.setLayout(null);
            title.setBounds(595, 195, 800, 400);
            rules.setBounds(625, 480, 175, 250);
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
        	System.out.println("not working");
            er.printStackTrace();
        }
	}
	public void playScreen() {
		//try {
//			JButton pass = new JButton();
//			JButton play = new JButton(); 
//        	fr.setSize(617, 360);
//    		fr.setResizable(true);
//    		
//    		//ImageIcon pass = new ImageIcon("passcombo.png");
//    	
//    		//resizing pass button
//    		ImageIcon passcombo = new ImageIcon("passcombo.png");
//    		Image pa = passcombo.getImage();
//    		Image newPass = pa.getScaledInstance( 150, 75,  java.awt.Image.SCALE_SMOOTH ) ;
//    		passcombo = new ImageIcon(newPass);
//    		
//    		
//    		//resizing exit button
//    		ImageIcon playC = new ImageIcon("playcombo.png");
//    		Image pl = playC.getImage();
//    		Image newPL = pl.getScaledInstance( 150, 75,  java.awt.Image.SCALE_SMOOTH ) ;
//    		playC = new ImageIcon(newPL);
//    		
//    		
////        	ImageIcon titly = new ImageIcon("title.png");
////        	Image t = titly.getImage();
////    		//Image newTitle = t.getScaledInstance( 600, 300,  java.awt.Image.SCALE_SMOOTH ) ;
////
////        	titly = new ImageIcon (t);
////        	
////        	
////        	title = new JButton (titly);
////            title.setContentAreaFilled(false);
////            title.setRolloverEnabled(false);
////            title.setBorderPainted(false);
////            title.setFocusPainted(false);
////            title.setPreferredSize(new Dimension (550, 300));
////            title.setHorizontalAlignment(SwingConstants.CENTER);
////            title.setVerticalAlignment(SwingConstants.CENTER);
//       
//    		fr.setContentPane(jp);
//            fr.setLayout(new FlowLayout());
//            fr.pack();
//           
//            //pass
//            pass = new JButton(passcombo);
//            pass.setContentAreaFilled(false);
//            pass.setRolloverEnabled(false);
//            pass.setBorderPainted(false);
//            pass.setFocusPainted(false);
//            pass.setPreferredSize(new Dimension (150, 75));
//            pass.setHorizontalAlignment(SwingConstants.LEFT);
//            pass.setVerticalAlignment(SwingConstants.CENTER);
//            pass.setActionCommand("rules");
//
//            //play
//            play = new JButton (playC);
//            play.setPreferredSize(new Dimension (150, 75));
//            play.setContentAreaFilled(false);
//            play.setRolloverEnabled(false);
//            play.setBorderPainted(false);
//            play.setFocusPainted(false);
//            play.setHorizontalAlignment(SwingConstants.CENTER);
//            play.setVerticalAlignment(SwingConstants.CENTER );
//            play.setActionCommand("play");
//            
//            
//            
//        	ImageIcon backy = new ImageIcon(ImageIO.read(new File("table.jpg")));
//        	Image b = backy.getImage();
//        	Image newB = b.getScaledInstance( 1000, 800, java.awt.Image.SCALE_DEFAULT ) ;
//        	backy = new ImageIcon (newB);
//        	JLabel back = new JLabel(backy);
//        	
//            //back.setSize(1000, 800);
//        	fr.setContentPane(back);
//        	fr.getContentPane().add(pass);
//            fr.getContentPane().add(play);
//            fr.setLayout(null);
//            jp.setLayout(null);
//            pass.setBounds(625, 480, 175, 250);
//            play.setBounds(750, 400, 400, 400);
//            fr.setLocationRelativeTo(null);
//            fr.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            play.addActionListener(this);
//        	pass.addActionListener(this);
//    		fr.setVisible(true);
//    		
    		ConsoleView a = new ConsoleView();
//    		a.playScren();
//    		
    		
    		
            
//        } catch (IOException er) {
//        	System.out.println("not working");
//            er.printStackTrace();
//        }
	}
	public void actionPerformed(ActionEvent e) {
		//repaint(g);
		// TODO Auto-generated method stub
		if ("rules".equals(e.getActionCommand())) {
			//JOPTIONPANE?
			String ru = "The goal of the game is get rid of the cards in your hand. Each person starts with 13 cards, max 4 players.\r\n"
					+ "\r\n"
					+ "The order of priority for the card suits (from lowest to highest) are spades < clubs < diamonds < hearts. Meanwhile, the order of priority for the values (from lowest to highest) is 3, 4, 5, ….. ,jack, queen, king, ace, 2. So the lowest card possible is the 3 of spades and the highest card possible is the 2 of hearts.\r\n"
					+ "\r\n"
					+ "There are multiple combos available when it comes to placing cards. 2 cards of the same value is called a “double”. 3 is “triple”, 4 is “quadruple”. A “straight” is when the combo placed are values in consecutive order (minimum 3 cards), such as 5, 6, 7. A “double straight” would be something like 5, 5, 6, 6, 7, 7.\r\n It is possible to play a straight with more than 3 cards. The suits don’t matter (unless you need to put a combo higher than the previous  person), you just need the values to be in ascending order."
					+ "\r\n"
					+ "Whoever has the 3 of spades would start the game first, and they have to start with placing the 3 of spades down (with any combo if they have). Then the next person would try to top that combo with an ending value/suit higher than the previous person."
					+ "\r\n"
					+ "For example, the person starting has the 3 of spades and the 3 of diamonds, so they put down a double 3. The next person either has to top that play with the ending card of the double being the 3 of hearts, or just play a double that’s higher than a 3.\r\n If person that has the turn doesn’t have a double at all (or chooses not to play a double) then they pass. If everyone passes, the last person who puts down the cards get’s to decide the combo for the next round."
					+ "\r\n"
					+ "Let’s say that a person starts the round with a straight of 10, jack, queen, king (of clubs). Since the straight has 4 cards, the next person has to play a straight of 4 as well, with the ending card being higher than the king of clubs."
					+ "\r\n"
					+ "Any combo ending with the 2 of hearts would be considered a “bomb.” No one can top the 2 of hearts, so everyone has to pass, and the person who played the 2 of hearts starts the next round.\r\n"
					+ "\r\n"
					+ "Even when a person has emptied their hand, go ahead and play for 2nd, 3rd, 4th place!";
			JOptionPane.showMessageDialog(null, ru, "RULES!", JOptionPane.INFORMATION_MESSAGE );
		} else if ("play".equals(e.getActionCommand())) {
			playing = true;
			playScreen();
			
		} else if ("exit".equals(e.getActionCommand())) {
			System.exit(0);
		}else {
			
		}
	}
	 public boolean getPlay() {
			return playing;
		}
		public void setPlay(boolean playing) {
			this.playing = playing;
		}
	public void updateScreen() {
		
	}
	public void draw() {
	
	}
}
