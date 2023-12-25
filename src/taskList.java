import javax.swing.*;
import java.awt.*;

// Class that represents the list that can store up to 10 taskPanels
public class taskList extends JPanel {
    // Constructor that sets size and uses grid layout to easily add and remove panels using index
    taskList(){
        this.setLayout(new GridLayout(10,1));
        this.setSize(500,500);
    }
    // Procedure that removes task based on index and updates the index of tasks after the one deleted
    public void deleteTask(int index){
        this.remove(index);
        Component[] allTasks = this.getComponents(); // Array of all tasks present
        for (int i = index; i < (this.getComponents()).length; i++){ // Loops through tasks after deleted one
            if (allTasks[i] instanceof taskPanel){
                ((taskPanel)allTasks[i]).setIndex(i); // Updates index
            }

        }
        revalidate(); // Makes sure changes are real time and updates frame
    }

}
