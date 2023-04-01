/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cs321.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hasna
 */
public class DartDashGUI extends javax.swing.JFrame {

    /**
     * Creates new form DartDashGUI
     */
    public DartDashGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainDisplayPanel = new javax.swing.JPanel();
        MainMenuPanel = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        MainMenuTitlePanel = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        MainMenuTitleLabel = new javax.swing.JLabel();
        MainMenuTitleImageLabel = new javax.swing.JLabel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel2 = new javax.swing.JPanel();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        MainMenuButtonsPanel = new javax.swing.JPanel();
        MainMenuPlayGameButton = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        MainMenuViewPlayersButton = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        MainMenuViewGamemodesButton = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        MainMenuQuitButton = new javax.swing.JButton();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MainDisplayPanel.setLayout(new java.awt.CardLayout());

        MainMenuPanel.setLayout(new javax.swing.BoxLayout(MainMenuPanel, javax.swing.BoxLayout.Y_AXIS));
        MainMenuPanel.add(filler4);

        MainMenuTitlePanel.setLayout(new javax.swing.BoxLayout(MainMenuTitlePanel, javax.swing.BoxLayout.X_AXIS));
        MainMenuTitlePanel.add(filler2);

        MainMenuTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        MainMenuTitleLabel.setText("DartDash ");
        MainMenuTitlePanel.add(MainMenuTitleLabel);

        MainMenuTitleImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dartboard.png"))); // NOI18N
        MainMenuTitlePanel.add(MainMenuTitleImageLabel);
        MainMenuTitlePanel.add(filler3);

        MainMenuPanel.add(MainMenuTitlePanel);
        MainMenuPanel.add(filler1);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));
        jPanel2.add(filler9);

        MainMenuButtonsPanel.setLayout(new javax.swing.BoxLayout(MainMenuButtonsPanel, javax.swing.BoxLayout.Y_AXIS));

        MainMenuPlayGameButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        MainMenuPlayGameButton.setText("Play Game");
        MainMenuPlayGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuPlayGameButtonActionPerformed(evt);
            }
        });
        MainMenuButtonsPanel.add(MainMenuPlayGameButton);
        MainMenuButtonsPanel.add(filler6);

        MainMenuViewPlayersButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        MainMenuViewPlayersButton.setText("View Players");
        MainMenuViewPlayersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuViewPlayersButtonActionPerformed(evt);
            }
        });
        MainMenuButtonsPanel.add(MainMenuViewPlayersButton);
        MainMenuButtonsPanel.add(filler7);

        MainMenuViewGamemodesButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        MainMenuViewGamemodesButton.setText("View Gamemodes");
        MainMenuViewGamemodesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuViewGamemodesButtonActionPerformed(evt);
            }
        });
        MainMenuButtonsPanel.add(MainMenuViewGamemodesButton);
        MainMenuButtonsPanel.add(filler8);

        MainMenuQuitButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        MainMenuQuitButton.setText("Quit");
        MainMenuQuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuQuitButtonActionPerformed(evt);
            }
        });
        MainMenuButtonsPanel.add(MainMenuQuitButton);

        jPanel2.add(MainMenuButtonsPanel);
        jPanel2.add(filler10);

        MainMenuPanel.add(jPanel2);
        MainMenuPanel.add(filler5);

        MainDisplayPanel.add(MainMenuPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuPlayGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuPlayGameButtonActionPerformed
        // TODO add your handling code here:
        
       
    
      // this is supposed to open the PLAY frame (dart class) but it is not opening for some reason. 
    
            dart dartFrame = new dart();         
            dartFrame.setVisible(true); 
        
 
    }//GEN-LAST:event_MainMenuPlayGameButtonActionPerformed

    private void MainMenuQuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuQuitButtonActionPerformed
        // TODO add your handling code here:
        //exits the game. 
        System.exit(0);
    }//GEN-LAST:event_MainMenuQuitButtonActionPerformed

    private void MainMenuViewGamemodesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuViewGamemodesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MainMenuViewGamemodesButtonActionPerformed

    private void MainMenuViewPlayersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuViewPlayersButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MainMenuViewPlayersButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//     public static void main(String args[]) {
//         /* Set the Nimbus look and feel */
//         //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//         /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//          * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//          */
//         try {
// //            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
// //                if ("Nimbus".equals(info.getName())) {
// //                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
// //                    break;
// //                }
// //            }
            
//             javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            
//         } catch (ClassNotFoundException ex) {
//             java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (InstantiationException ex) {
//             java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (IllegalAccessException ex) {
//             java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//             java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//         }
//         //</editor-fold>

//         /* Create and display the form */
//         java.awt.EventQueue.invokeLater(new Runnable() {
//             public void run() {
//                 new DartDashGUI().setVisible(true);
//             }
//         });
//     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainDisplayPanel;
    private javax.swing.JPanel MainMenuButtonsPanel;
    private javax.swing.JPanel MainMenuPanel;
    private javax.swing.JButton MainMenuPlayGameButton;
    private javax.swing.JButton MainMenuQuitButton;
    private javax.swing.JLabel MainMenuTitleImageLabel;
    private javax.swing.JLabel MainMenuTitleLabel;
    private javax.swing.JPanel MainMenuTitlePanel;
    private javax.swing.JButton MainMenuViewGamemodesButton;
    private javax.swing.JButton MainMenuViewPlayersButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
