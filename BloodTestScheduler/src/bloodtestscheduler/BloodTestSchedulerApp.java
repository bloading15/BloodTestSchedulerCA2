/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bloodtestscheduler;

/**
 *
 * @author General
 */
public class BloodTestSchedulerApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          // Initialize scheduler and no-show tracker
        Scheduler scheduler = new Scheduler();
        NoShowTracker noShowTracker = new NoShowTracker();

        // Add hardcoded patients
        scheduler.addPerson(new Person("Alice Johnson", "Urgent", "Dr. Smith", 45, false));
        scheduler.addPerson(new Person("Bob Brown", "Medium", "Dr. Taylor", 67, true));
        scheduler.addPerson(new Person("Catherine Davis", "Low", "Dr. Allen", 30, false));
        scheduler.addPerson(new Person("David Evans", "Urgent", "Dr. Clark", 50, true));
        scheduler.addPerson(new Person("Eleanor Foster", "Medium", "Dr. Young", 70, false));

        // Save hardcoded patients to file
        FileHandler.savePatientsToFile(scheduler.getQueue());

        // Launch the GUI
        java.awt.EventQueue.invokeLater(() -> {
            BloodTestSchedulerGUI gui = new BloodTestSchedulerGUI();
            gui.setVisible(true);
        });
    
    }
    
    
}
