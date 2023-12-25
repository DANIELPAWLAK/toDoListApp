import javax.swing.*;

//Main function that that calls the main frame by creating it and making it visible
public class toDoListApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }
}