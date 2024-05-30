package killer13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//public class ConsoleView extends JFrame {
//    private JTextArea console;
//    private JTextField inputField;
//    private BlockingQueue<String> inputQueue = new LinkedBlockingQueue<>();
//
//    public ConsoleView() {
//        this.setLocation(100, 100);
//        this.setSize(600, 400);
//        this.setLayout(new BorderLayout());
//        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        JLabel header = new JLabel("Killer");
//        this.add(header, BorderLayout.NORTH);
//
//        console = new JTextArea();
//        console.setEditable(false);
//        this.add(new JScrollPane(console), BorderLayout.CENTER);
//
//        inputField = new JTextField();
//
//        JButton enterButton = new JButton("Enter");
//        enterButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String input = inputField.getText();
//                inputQueue.offer(input);
//                inputField.setText(null);
//            }
//        });
//
//        this.getRootPane().setDefaultButton(enterButton);
//
//        JPanel inputFieldPanel = new JPanel();
//        GroupLayout layout = new GroupLayout(inputFieldPanel);
//        inputFieldPanel.setLayout(layout);
//        layout.setAutoCreateContainerGaps(true);
//        layout.setHorizontalGroup(layout.createSequentialGroup()
//                .addComponent(inputField)
//                .addComponent(enterButton)
//        );
//        layout.setVerticalGroup(layout.createParallelGroup(Alignment.BASELINE)
//                .addComponent(inputField)
//                .addComponent(enterButton)
//        );
//        this.add(inputFieldPanel, BorderLayout.SOUTH);
//
//        System.setOut(new PrintStream(new OutputStream() {
//            @Override
//            public void write(int c) {
//                console.append(String.valueOf((char) c));
//            }
//        }));
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//    }
//
//    public String getInput() {
//        try {
//            return inputQueue.take();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void startGame() {
//        new Thread(() -> {
//            Killer.main(new String[0]);
//        }).start();
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                ConsoleView consoleView = new ConsoleView();
//                consoleView.startGame();
//            }
//        });
//    }




public class ConsoleView extends JFrame {
    private JTextArea console;
    private JTextField inputField;
    private BlockingQueue<String> inputQueue = new LinkedBlockingQueue<>();

    public ConsoleView() {
        this.setLocation(100, 100);
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());

        JLabel header = new JLabel("Killer");
        this.add(header, BorderLayout.NORTH);

        console = new JTextArea();
        console.setEditable(false);
        this.add(new JScrollPane(console), BorderLayout.CENTER);

        inputField = new JTextField();

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                	
                    String input = inputField.getText();
                    inputQueue.offer(input);
                    inputField.setText(""); // Clearing text field
                
                });
            
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
                console.append(String.valueOf((char) c));
            }
        }));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getInput() {
        try {
        	BufferedWriter writer = new BufferedWriter(new FileWriter("plays.txt"));
            writer.write(inputQueue.peek());
            writer.close();            
            return inputQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void startGame() {
        new Thread(() -> {
            Killer.main(new String[0]);
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConsoleView consoleView = new ConsoleView();
                consoleView.startGame();
            }
        });
    }
}

