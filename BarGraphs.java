package q5;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

public class BarGraphs extends JPanel implements KeyListener {
    // Creating the variables for holding the positions of each bar
    int x1, x2, x3;
    int y1, y2, y3;
    int w1, w2, w3;
    int h1, h2, h3;

    // Declaring the panel to hold the text, the bars, and the textfields
    JPanel myPnl;

    // Creating 3 textfields for each bar
    JTextField myTf1, myTf2, myTf3;

    // Constructor: Making the BarGraphs
    public BarGraphs() {

        // Initialize Bar Position Values
        x1 = 10; x2 = 10; x3 = 10;
        y1 = 50; y2 = 100; y3 = 150;
        w1 = 0; w2 = 0; w3 = 0;
        h1 = 30; h2 = 30; h3 = 30;

        // Creating the panel
        myPnl = new JPanel();

        // Setting all the textfields to 0 initially
        myTf1 = new JTextField("0");
        myTf2 = new JTextField("0");
        myTf3 = new JTextField("0");

        // Setting the layout to null, to position components absolutely
        setLayout(null);

        // Setting the position of the 3 textfields
        myTf1.setBounds(420,50, 50,30);
        myTf2.setBounds(420,100, 50,30);
        myTf3.setBounds(420,150, 50,30);

        // Adding the textfields to the panel
        add(myTf1);
        add(myTf2);
        add(myTf3);

        // Adding Key Listeners to each the TextFields
        myTf1.addKeyListener(this);
        myTf2.addKeyListener(this);
        myTf3 .addKeyListener(this);
    }

    // Handles painting the rectangles within the panel
    public void paintComponent(Graphics g) {
        // Allows components to be painted partially
        super.paintComponent(g);
        // Adds a string to the panel at specific coordinates
        g.drawString("Keep numbers in [0,100]", 20,20);
        // Assigns the color, position, and dimensions to the 1st Red Rectangle
        g.setColor(Color.RED);
        g.fillRect(x1,y1,w1,h1);
        // Assigns the color, position, and dimensions to the 2nd Yellow Rectangle
        g.setColor(Color.YELLOW);
        g.fillRect(x2,y2,w2,h2);
        // Assigns the color, position, and dimensions to the 3rd Blue Rectangle
        g.setColor(Color.BLUE);
        g.fillRect(x3,y3,w3,h3);
    }

    public static void main(String[] args) {
        // Creating myFrame to hold the panel
        JFrame myFrame = new JFrame("Bar Graphs");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Define the size of myFrame
        myFrame.setSize(500,250);
        // Make the BarGraphs within myFrame
        myFrame.setContentPane(new BarGraphs());
        myFrame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Variables that hold the textfield values
        int v1, v2, v3;

        try {
            v1 = Integer.parseInt(myTf1.getText());
            v2 = Integer.parseInt(myTf2.getText());
            v3 = Integer.parseInt(myTf3.getText());
        } catch (NumberFormatException nfe) {
            v1 = 0;
            v2 = 0;
            v3 = 0;
        }
        // If v1 is in bounds update the 1st rectangle width
        if(v1 > 0 && v1 <= 100) {
            w1 = v1 * 4;
        }
        // If v2 is in bounds update the 2nd rectangle width
        if(v2 > 0 && v2 <= 100) {
            w2 = v2 * 4;
        }
        // If v3 is in bounds update the 3rd rectangle width
        if(v3 > 0 && v3 <= 100) {
            w3 = v3 * 4;
        }
        // Repaint the rectangles, when the textfields are updated
        repaint();
    }
}
