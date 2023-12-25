import javax.swing.*;
import java.awt.*;

//Class that makes a panel that consists of the task description and buttons to mark as complete and delete the task
public class taskPanel extends JPanel {

    private JTextArea task;
    private JButton completedTask;
    private JButton deleteTask;
    private loadImages imgLoader = new loadImages();
    private int taskIndex; // Index is used to track position in list to make sure correct tasks are deleted

    // Constructor that takes user input string and index given
    taskPanel(String givenTask, int index){
        this.taskIndex = index;

        // Setting layout to border as three components are used side by side
        this.setLayout(new BorderLayout());
        this.setSize(500,50);
        // Uneditable text are that displays task description and wraps around allowing for longer text
        task = new JTextArea(givenTask);
        task.setEditable(false);
        task.setLineWrap(true);
        task.setWrapStyleWord(true);
        task.setBackground(Color.white);
        this.add(task,BorderLayout.CENTER);
        //Button used to let user mark task as complete
        completedTask = new JButton(imgLoader.loadScaledImage("src/assets/tickBox.PNG",50,50));
        completedTask.setSize(50,50);
        this.add(completedTask,BorderLayout.EAST);
        //Button used to delete a task
        deleteTask = new JButton(imgLoader.loadScaledImage("src/assets/trashCan.PNG",50,50));
        deleteTask.setSize(50,50);
        this.add(deleteTask,BorderLayout.WEST);
    }

    // Methods to return buttons that can be programmed in the main app
    public JButton getCompletedTask() { return completedTask; }
    public JButton getDeleteTask() { return deleteTask; }
    // Visually marks the task as complete by changing background to green and removing tick button
    public void markAsComplete(){
        task.setBackground(Color.green);
        this.remove(completedTask);
        this.setBackground(Color.green);
    }
    //Getters and setters for index
    public int getIndex() { return this.taskIndex; }
    public void setIndex(int newIndex){ this.taskIndex = newIndex; }

}
