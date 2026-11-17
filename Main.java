import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Example");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JButton button1 = new JButton("Top Button");
        JLabel label1 = new JLabel("This is the first one.");

        JButton button2 = new JButton("Bottom Button");
        JLabel label2 = new JLabel("This is the second one.");

        frame.setLayout(new GridLayout(2, 1));
        
        panel1.setLayout(new GridLayout(1, 2));
        panel2.setLayout(new GridLayout(1, 2));

        panel1.add(button1);
        panel1.add(label1);

        panel2.add(button2);
        panel2.add(label2);

        frame.add(panel1);
        frame.add(panel2);

        ButtonListener clicker = new ButtonListener(label1, label2);

        button1.addActionListener(e -> clicker.addClick());
        button2.addActionListener(e -> clicker.upgrade());
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

            JFrame frame2 = new JFrame("Are you sure?");
            JLabel label3 = new JLabel("Are you sure you want to exit?");
            JPanel panel3 = new JPanel();

            JButton yesButton = new JButton("Yes");
            JButton noButton = new JButton("No");

            frame2.setLayout(new GridLayout(2, 1));
            frame2.add(label3);

            panel3.setLayout(new GridLayout(1, 2));
            panel3.add(yesButton);
            yesButton.addActionListener(event -> System.exit(0));

            panel3.add(noButton);
            noButton.addActionListener(event -> frame2.dispose());
            
            frame2.add(panel3);

            frame2.setSize(300, 200);
            frame2.setVisible(true);

            frame2.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent windowEvent) {
                    frame2.dispose();
                }
            });

            }
        });

        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}