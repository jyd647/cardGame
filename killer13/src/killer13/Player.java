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
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
public class Player extends JPanel implements ActionListener{
	private int width = Background.getWidth();
	private int height = Background.getHeight();
	Background enter = new Background();
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		///g.drawImage
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player f = new Player();
	}
	public Player () {
		JFrame fr = new JFrame("killer");
		
		
		fr.setSize(617, 360);
		fr.setResizable(true);
		
		ImageIcon image1 = new ImageIcon("table.jpg");
        fr.add(new JLabel(image1));
        fr.pack();        
        JButton rules = new JButton("RULES"); 
        //rules.setPreferredSize(new Dimension (5, 5));
        rules.setHorizontalAlignment(SwingConstants.LEFT);
        JButton play = new JButton("PLAY"); 
        play.setPreferredSize(new Dimension (5, 5));
        play.setHorizontalAlignment(SwingConstants.CENTER);
        JButton exit = new JButton("EXIT"); 
        exit.setPreferredSize(new Dimension (5, 5));
        exit.setHorizontalAlignment(SwingConstants.RIGHT);
        fr.getContentPane().add(rules);
        fr.getContentPane().add(play);
        //fr.getContentPane().add(exit);
        fr.setLocationRelativeTo(null);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //fr.setUndecorated(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
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
	//setting up buttons for home screen
//	ImageIcon rulesButton = createImageIcon("table.jpg", "help");
//	ImageIcon playButton = createImageIcon("table.jpg", "me");
//	ImageIcon exitButton = createImageIcon("table.jpg", "pls");
//	{
//	
//	JButton b1 = new JButton("?", rulesButton);
//	b1.setVerticalTextPosition(AbstractButton.CENTER);
//	b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
//	b1.setMnemonic(KeyEvent.VK_D); //what does this mean
//	b1.setActionCommand("rules"); // the command it follows
//	b1.setVisible(true);
//	
//	//play button
//	JButton b2 = new JButton("PLAY", playButton);
//	b2.setVerticalTextPosition(AbstractButton.BOTTOM);
//	b2.setHorizontalTextPosition(AbstractButton.CENTER);
//	b2.setMnemonic(KeyEvent.VK_M);
//	b2.setVisible(true);
//	
//	//exit button
//	JButton b3 = new JButton("EXIT", exitButton);
//	//Use the default text position of CENTER, TRAILING (RIGHT).
//	b3.setMnemonic(KeyEvent.VK_E);
//	b3.setActionCommand("exit");
//	b3.setEnabled(false);
//	b3.setVisible(true);
//	//Listen for actions on buttons 1 and 3.
//	b1.addActionListener(this);
//	b3.addActionListener(this);
//	

	//}

	@Override
	public void actionPerformed(ActionEvent e) {
		//repaint(g);
		// TODO Auto-generated method stub
		if ("rules".equals(e.getActionCommand())) {
		} else if ("play".equals(e.getActionCommand())) {
	
		} else {
		
		}
}
}