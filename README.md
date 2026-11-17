# Java GUI Exercise - Pemrograman Berorientasi Objek (PBO)

A simple Java Swing desktop application that demonstrates the implementation of **5 essential GUI Components / Parts** in Java, along with GUI event listeners and event handling.

---

## 📋 5 GUI Components / Parts Implementation

This project implements the five required GUI elements within `Main.java` and `ButtonListener.java`.

### 1. Top-Level Container Class

- **Class:** `javax.swing.JFrame`
- **Description:** Top-level containers are the main windows where other GUI components are placed.
- **Code Implementation:**

  ```java
  JFrame frame = new JFrame("Swing Example");
  frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

  frame.setSize(500, 200);
  frame.setVisible(true);
  ```

  A second `JFrame` is also created to display an exit confirmation window when the user attempts to close the main application.

  ```java
  JFrame frame2 = new JFrame("Are you sure?");
  frame2.setSize(300, 200);
  frame2.setVisible(true);
  ```

---

### 2. Intermediate Container Class

- **Class:** `javax.swing.JPanel`
- **Description:** Intermediate containers are used to group and organize child components before being added to a top-level container.
- **Code Implementation:**

  ```java
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  JPanel panel4 = new JPanel();

  // Adding components to the main panels
  panel1.add(button1);
  panel1.add(label1);

  panel2.add(button2);
  panel2.add(label2);

  // Adding panels to the main frame
  frame.add(panel1);
  frame.add(panel2);
  ```

  The additional panels, `panel3` and `panel4`, are used to organize the exit confirmation label and buttons.

---

### 3. Atomic Component Class

- **Classes:** `javax.swing.JButton` and `javax.swing.JLabel`
- **Description:** Atomic components are basic user-interface elements that do not contain other GUI components. They are used to display information and receive user input.
- **Code Implementation:**

  ```java
  JButton button1 = new JButton("Top Button");
  JLabel label1 = new JLabel("This is the first one.");

  JButton button2 = new JButton("Bottom Button");
  JLabel label2 = new JLabel("This is the second one.");

  JButton yesButton = new JButton("Yes");
  JButton noButton = new JButton("No");

  JLabel label3 = new JLabel("Are you sure you want to exit?");
  ```

  The application uses buttons for the click counter, upgrade system, and exit confirmation.

---

### 4. Layout Classes (Minimum 2 Layout Classes)

Two distinct layout manager classes are implemented to organize GUI components:

- **Classes:** `java.awt.GridLayout` and `java.awt.FlowLayout`
- **Description:** Layout managers determine how components are positioned and arranged within containers.

**1. GridLayout**

- Main frame: Arranges two panels vertically using 2 rows and 1 column.
- Main panels: Arranges buttons and labels horizontally using 1 row and 2 columns.
- Confirmation frame: Arranges the confirmation label panel and button panel vertically.

```java
// Main frame layout
frame.setLayout(new GridLayout(2, 1));

// Main panel layouts
panel1.setLayout(new GridLayout(1, 2));
panel2.setLayout(new GridLayout(1, 2));

// Confirmation frame layout
frame2.setLayout(new GridLayout(2, 1));

// Confirmation button panel
panel4.setLayout(new GridLayout(1, 2));
```

**2. FlowLayout**

- Confirmation label panel: Centers the confirmation message horizontally.

```java
panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
panel3.add(label3);
```

---

### 5. Event Listener & Event Handling

- **Interfaces / Classes:** `java.awt.event.ActionListener` and `java.awt.event.WindowAdapter`
- **Description:** Event handling allows the application to respond to user interactions, such as button clicks and window-closing actions.

**1. Button Event Handling**

The application registers action listeners to the two main buttons. Each button calls a corresponding method from the `ButtonListener` class.

```java
ButtonListener clicker = new ButtonListener(label1, label2);

button1.addActionListener(e -> clicker.addClick());
button2.addActionListener(e -> clicker.upgrade());
```

**2. Click Counter Implementation**

The `addClick()` method increases the click counter based on the current click increment and updates the first label.

```java
public void addClick() {
    counter += increment;
    label1.setText("You have " + counter + " clicks.");
}
```

**3. Upgrade System Implementation**

The `upgrade()` method checks whether the player has enough clicks to purchase an upgrade. If successful, the click cost is deducted and the click increment increases.

```java
public void upgrade() {
    if (counter >= upgrade) {
        counter -= upgrade;
        upgrade *= (1 + (increment * 0.2));
        increment++;

        label2.setText("Upgraded and each click does "
            + increment + " You now need " + upgrade + " clicks.");

        label1.setText("You have " + counter + " clicks.");
    } else {
        label2.setText("Not enough clicks. Your click still does "
            + increment + " You need " + upgrade + " clicks.");
    }
}
```

**4. Window Event Handling**

The application uses `WindowAdapter` to intercept the main window's closing event and display a separate confirmation window.

```java
frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        // Display exit confirmation window
    }
});
```

The confirmation window provides two options:

- **Yes:** Exits the application using `System.exit(0)`.
- **No:** Closes the confirmation window using `frame2.dispose()`.
