package killer13;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ConsoleView extends JFrame {
	//JFrame ps = new JFrame();
	public ConsoleView() {
		this.setLocation(100,100);
		this.setSize(600,400);
		this.setLayout(new BorderLayout());
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel header = new JLabel("Killer");
		this.add(header, BorderLayout.NORTH);
		
		final JTextArea console = new JTextArea();
		console.setEditable(false);
		this.add(new JScrollPane(console), BorderLayout.CENTER);
		
		final JTextField inputField = new JTextField();
		
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(inputField.getText());
				inputField.setText(null);
			}
		});
		
		this.getRootPane().setDefaultButton(enterButton);
	
		JPanel inputFieldPanel = new JPanel();
		GroupLayout layout = new GroupLayout(inputFieldPanel);
		inputFieldPanel.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(inputField)
				.addComponent(enterButton)
		);
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(inputField)
				.addComponent(enterButton)
		);
		this.add(inputFieldPanel, BorderLayout.SOUTH);
		System.setOut(new PrintStream(new OutputStream() {
			
			@Override
			public void write(int c) {
				
				console.setText(console.getText() + String.valueOf((char) c));
			}
			

		}));
	}
	public void playScren() {
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//new ConsoleView().setVisible(true);
			}
		});
	}
	
	
}
