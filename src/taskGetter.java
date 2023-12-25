import javax.swing.*;
import java.awt.*;

// Class that has text field and button that reads user input and sends it upon button press
public class taskGetter extends JPanel {
    private JTextField textBar;
    private JButton addButton;

    // Constructor that sets size and adds two components side by side
    taskGetter(){
        this.setLayout(new BorderLayout());
        this.setSize(500,50);

        textBar = new JTextField();
        textBar.setSize(400,50);
        this.add(textBar,BorderLayout.CENTER);

        addButton = new JButton("Add Task");
        addButton.setSize(100,50);
        this.add(addButton,BorderLayout.EAST);

    }

    // Returns button that can be added to an action listener
    public JButton getAddButton(){ return addButton; }
    // Sends whatever string is in the text field currently
    public String getUserString(){ return textBar.getText(); }
    // Clears the text field so user doesn't have to
    public void clearText(){ textBar.setText(""); }
}
