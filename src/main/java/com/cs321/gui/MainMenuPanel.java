/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import com.cs321.core.GameConfiguration;
import com.cs321.core.GameManager;
import com.cs321.gui.GUIState.PanelName;
import java.util.ArrayList;

/**
 *
 * @author Hasna
 */
public class MainMenuPanel extends UpdateableJPanel {

    // The global GUI state
    private GUIState state;

    /**
     * Creates new form MainMenuPanel
     */
    public MainMenuPanel(GUIState state) {
        initComponents();
        
        this.state = state;
        state.contentPane.add("main", this);
       // state.contentPaneCardLayout.show(state.contentPane.getParent(), TOOL_TIP_TEXT_KEY);
    }
    
    /**
     * Updates the components to reflect the current state
     */
    @Override
    public void updateComponents() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        HeaderPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TitleLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        BodyPanel = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        MenuPanel = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        PlayGameButton = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        ViewPlayersButton = new javax.swing.JButton();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        ViewGamemodesButton = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        QuitButton = new javax.swing.JButton();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setMinimumSize(new java.awt.Dimension(1, 1));
        setPreferredSize(new java.awt.Dimension(1, 1));
        setLayout(new java.awt.GridBagLayout());

        HeaderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setLayout(new javax.swing.BoxLayout(HeaderPanel, javax.swing.BoxLayout.X_AXIS));
        HeaderPanel.add(filler1);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TitleLabel.setText("Dart Dash");
        HeaderPanel.add(TitleLabel);
        HeaderPanel.add(filler2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(HeaderPanel, gridBagConstraints);

        BodyPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        BodyPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        BodyPanel.setLayout(new javax.swing.BoxLayout(BodyPanel, javax.swing.BoxLayout.X_AXIS));
        BodyPanel.add(filler3);

        MenuPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        MenuPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        MenuPanel.setLayout(new javax.swing.BoxLayout(MenuPanel, javax.swing.BoxLayout.Y_AXIS));
        MenuPanel.add(filler5);

        PlayGameButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PlayGameButton.setText("Play Game");
        PlayGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayGameButtonActionPerformed(evt);
            }
        });
        MenuPanel.add(PlayGameButton);
        MenuPanel.add(filler6);

        ViewPlayersButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ViewPlayersButton.setText("View Players");
        ViewPlayersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewPlayersButtonActionPerformed(evt);
            }
        });
        MenuPanel.add(ViewPlayersButton);
        MenuPanel.add(filler7);

        ViewGamemodesButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ViewGamemodesButton.setText("View Gamemodes");
        ViewGamemodesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewGamemodesButtonActionPerformed(evt);
            }
        });
        MenuPanel.add(ViewGamemodesButton);
        MenuPanel.add(filler8);

        QuitButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        QuitButton.setText("Quit");
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });
        MenuPanel.add(QuitButton);
        MenuPanel.add(filler9);

        BodyPanel.add(MenuPanel);
        BodyPanel.add(filler4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 3.0;
        add(BodyPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QuitButtonActionPerformed

    private void ViewGamemodesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewGamemodesButtonActionPerformed
        state.panels.get(PanelName.ViewGamemodesPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.ViewGamemodesPanel.toString());
    }//GEN-LAST:event_ViewGamemodesButtonActionPerformed

    private void PlayGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayGameButtonActionPerformed
        state.panels.get(PanelName.ChooseGametypePanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.ChooseGametypePanel.toString());  
      
       
    }//GEN-LAST:event_PlayGameButtonActionPerformed

    private void ViewPlayersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewPlayersButtonActionPerformed
        state.panels.get(PanelName.ViewPlayersPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.ViewPlayersPanel.toString());
    }//GEN-LAST:event_ViewPlayersButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton PlayGameButton;
    private javax.swing.JButton QuitButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JButton ViewGamemodesButton;
    private javax.swing.JButton ViewPlayersButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    // End of variables declaration//GEN-END:variables
}

