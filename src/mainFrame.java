import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Main frame class that combines all over components
public class mainFrame extends JFrame {

    private taskList list;
    private taskGetter userInput;
    private JButton newTask;
    private int indexTracker; // Tracks index that should be used for new tasks

    // Constructor that adds title to top of frame and adds functionality by called addButtons();
    mainFrame(){
        indexTracker = 0; // Set to 0 on startup

        this.setSize(500,700);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program ends upon closure of frame
        // Adding header onto frame
        JLabel title = new JLabel("To Do List");
        title.setSize(500,100);
        title.setFont(new Font("New Courier",Font.BOLD,40));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title,BorderLayout.NORTH);
        // Adds list frame onto itself
        list = new taskList();
        this.add(list,BorderLayout.CENTER);
        // Adds footer used for user input and grabs its button used to add task
        userInput = new taskGetter();
        newTask = userInput.getAddButton();
        this.add(userInput,BorderLayout.SOUTH);

        addButtons();
    }

    // Changes index depending on given positive/negative number
    private void updateAmount(int change){ this.indexTracker += change; }

    // Usually all button getters in other classes to add functionality using action listeners using add task button as the origin
    private void addButtons(){
        // Listener for add task button that starts everything
        newTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Grabs whatever is in text field and checks whether its empty string or not by removing white spaces
                String temp = userInput.getUserString();
                if(temp.replaceAll("\\s", "").length() <= 0){
                    return;
                }
                userInput.clearText(); // Clears text field for next task input
                // Checks whether limit has been hit for tasks present and creates a popup to let user know
                if (indexTracker == 10 ){
                    JOptionPane.showMessageDialog(null, "Task limit please delete other tasks to make space");
                    return;
                }
                // If valid input and space available task is added using indexTracker to list which is updated
                taskPanel task = new taskPanel(temp, indexTracker);
                updateAmount(1); // Add one to tracker for next task
                list.add(task);
                revalidate();
                // Adding functionality for complete button on just added task that calls function to colour it as green
                task.getCompletedTask().addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        task.markAsComplete();
                        repaint();
                    }
                });
                // Doing same but for delete button that calls list function to delete it and updates indexTracker
                task.getDeleteTask().addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        list.deleteTask(task.getIndex());
                        updateAmount(-1);
                        repaint();
                    }
                });
            }
        });
    }
}
