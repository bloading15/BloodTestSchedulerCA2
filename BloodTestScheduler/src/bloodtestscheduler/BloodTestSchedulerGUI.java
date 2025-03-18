/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bloodtestscheduler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author General
 */
public class BloodTestSchedulerGUI extends javax.swing.JFrame {
     private Scheduler scheduler;
    private NoShowTracker noShowTracker;
  

    /**
     * Creates new form BloodTestSchedulerGUI
     */
    public BloodTestSchedulerGUI() {
        initComponents();
        scheduler = new Scheduler();
        noShowTracker = new NoShowTracker();

        // Load patients from the file into the priority queue
        scheduler.getQueue().addAll(FileHandler.loadPatientsFromFile());
    
        // Initialize Priority ComboBox with proper values
        PriorityCMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Urgent", "Medium", "Low"}));
          this.pack();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        NameLBL = new javax.swing.JLabel();
        NameTF = new javax.swing.JTextField();
        PriorityLBL = new javax.swing.JLabel();
        PriorityCMB = new javax.swing.JComboBox<>();
        GPDetailsLBL = new javax.swing.JLabel();
        GPDetailsTF = new javax.swing.JTextField();
        AgeLBL = new javax.swing.JLabel();
        AgeTF = new javax.swing.JTextField();
        HospitalCHB = new javax.swing.JCheckBox();
        NextBTN = new javax.swing.JButton();
        AddBTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayAreaTA = new javax.swing.JTextArea();
        NoShowBTN = new javax.swing.JButton();
        HistoryBTN = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blood Test Scheduler");
        setPreferredSize(new java.awt.Dimension(400, 600));
        setSize(new java.awt.Dimension(400, 600));

        NameLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NameLBL.setText("Name:");

        PriorityLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PriorityLBL.setText("Priority:");

        PriorityCMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PriorityCMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriorityCMBActionPerformed(evt);
            }
        });

        GPDetailsLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GPDetailsLBL.setText("GP Details:");

        AgeLBL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AgeLBL.setText("Age:");

        HospitalCHB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HospitalCHB.setText("From Hospital");

        NextBTN.setBackground(new java.awt.Color(51, 255, 255));
        NextBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NextBTN.setText("Get Next");
        NextBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextBTNActionPerformed(evt);
            }
        });

        AddBTN.setBackground(new java.awt.Color(102, 255, 255));
        AddBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddBTN.setText("Add Person");
        AddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBTNActionPerformed(evt);
            }
        });

        DisplayAreaTA.setColumns(20);
        DisplayAreaTA.setRows(5);
        jScrollPane1.setViewportView(DisplayAreaTA);

        NoShowBTN.setBackground(new java.awt.Color(51, 255, 255));
        NoShowBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NoShowBTN.setText("No Show");
        NoShowBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoShowBTNActionPerformed(evt);
            }
        });

        HistoryBTN.setBackground(new java.awt.Color(51, 255, 255));
        HistoryBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HistoryBTN.setText("View History");
        HistoryBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PriorityLBL)
                    .addComponent(NameLBL)
                    .addComponent(GPDetailsLBL)
                    .addComponent(NextBTN)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(AgeLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoShowBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HistoryBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(HospitalCHB)
                        .addComponent(PriorityCMB, 0, 169, Short.MAX_VALUE)
                        .addComponent(NameTF)
                        .addComponent(GPDetailsTF)
                        .addComponent(AgeTF)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLBL)
                    .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PriorityLBL)
                    .addComponent(PriorityCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GPDetailsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GPDetailsLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgeLBL)
                    .addComponent(AgeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NextBTN)
                    .addComponent(HospitalCHB))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(AddBTN)
                        .addGap(18, 18, 18)
                        .addComponent(NoShowBTN)
                        .addGap(18, 18, 18)
                        .addComponent(HistoryBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
        // TODO add your handling code here:
         String name = NameTF.getText();
    String priority = (String) PriorityCMB.getSelectedItem();
    String gpDetails = GPDetailsTF.getText();
    int age = Integer.parseInt(AgeTF.getText());
    boolean fromHospital = HospitalCHB.isSelected();
    
    // Create and add the patient to the scheduler
    Person person = new Person(name, priority, gpDetails, age, fromHospital);
    scheduler.addPerson(person);
    
     // Automatically save to file
    FileHandler.savePatientsToFile(scheduler.getQueue());
    
    // Update the display area
    DisplayAreaTA.setText("Person added:\n" +
            "Name: " + name + "\n" +
            "Priority: " + priority + "\n" +
            "GP Details: " + gpDetails + "\n");
    }//GEN-LAST:event_AddBTNActionPerformed

    private void NextBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBTNActionPerformed
        // TODO add your handling code here
        Person next = scheduler.getNextPerson();
             if (next != null) {
                DisplayAreaTA.setText("Next Person:\n" +
                "Name: " + next.getName() + "\n" +
                "Priority: " + next.getPriority() + "\n" +
                "GP Details: " + next.getGPDetails() + "\n");
            } else {
                 DisplayAreaTA.setText("No more people in the queue.");
            }
    }//GEN-LAST:event_NextBTNActionPerformed

    private void PriorityCMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriorityCMBActionPerformed
        // TODO add your handling code here:
               
    }//GEN-LAST:event_PriorityCMBActionPerformed

    private void NoShowBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoShowBTNActionPerformed
        // TODO add your handling code here:
          Person noShow = scheduler.getNextPerson();
    if (noShow != null) {
        
        // Add the no-show patient to the tracker
        noShowTracker.addNoShow(noShow);
        
         // Automatically save to file
        FileHandler.savePatientsToFile(scheduler.getQueue());
        
        DisplayAreaTA.setText("Marked as No-Show:\n" +
                "Name: " + noShow.getName() + "\n" +
                "Priority: " + noShow.getPriority() + "\n" +
                "GP Details: " + noShow.getGPDetails() + "\n");
    } else {
        DisplayAreaTA.setText("No more people to mark as no-show.");
    }
        
    }//GEN-LAST:event_NoShowBTNActionPerformed

    private void HistoryBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryBTNActionPerformed
        // TODO add your handling code here:
        try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
        StringBuilder history = new StringBuilder("Patient History:\n");
        String line;
        while ((line = reader.readLine()) != null) {
            history.append(line).append("\n");
        }
        DisplayAreaTA.setText(history.toString());
    } catch (IOException e) {
        DisplayAreaTA.setText("Error reading patient history: " + e.getMessage());
    }
    }//GEN-LAST:event_HistoryBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BloodTestSchedulerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodTestSchedulerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodTestSchedulerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodTestSchedulerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BloodTestSchedulerGUI().setVisible(true);
                System.out.println("GUI Intitialized");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBTN;
    private javax.swing.JLabel AgeLBL;
    private javax.swing.JTextField AgeTF;
    private javax.swing.JTextArea DisplayAreaTA;
    private javax.swing.JLabel GPDetailsLBL;
    private javax.swing.JTextField GPDetailsTF;
    private javax.swing.JButton HistoryBTN;
    private javax.swing.JCheckBox HospitalCHB;
    private javax.swing.JLabel NameLBL;
    private javax.swing.JTextField NameTF;
    private javax.swing.JButton NextBTN;
    private javax.swing.JButton NoShowBTN;
    private javax.swing.JComboBox<String> PriorityCMB;
    private javax.swing.JLabel PriorityLBL;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
