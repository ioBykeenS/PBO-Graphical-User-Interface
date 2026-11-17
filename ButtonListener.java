import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ButtonListener {
    public int counter = 0;
    public int increment = 1;
    public double upgrade = 100;
    private JLabel label1;
    private JLabel label2;

    public ButtonListener(JLabel label1, JLabel label2) {
        this.label1 = label1;
        this.label2 = label2;
    }

    public void addClick() {
        counter += increment;
        label1.setText("You have " + counter + " clicks.");
    }

    public void upgrade() {
        if (counter >= upgrade) {
            counter -= upgrade;
            upgrade *= (1 + (increment * 0.2));
            increment++;

            label2.setText("Upgraded and each click does " + increment + " You now need " + upgrade + " clicks.");
            label1.setText("You have " + counter + " clicks.");
        } else {
            label2.setText("Not enough clicks. Your click still does " + increment + " You need " + upgrade + " clicks.");
        }
    }
}