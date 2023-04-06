/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cs321.gui;

import java.awt.CardLayout;

import com.cs321.core.GameConfiguration;
import com.cs321.gui.GUIState.PanelName;

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
        
        GUIState state = new GUIState();
        state.contentPane = getContentPane();
        state.contentPaneCardLayout = (CardLayout)getContentPane().getLayout();
        state.gameConfigurations.add(new GameConfiguration());

        state.panels.put(PanelName.MainMenuPanel, new MainMenuPanel(state));
        state.panels.put(PanelName.ViewGamemodesPanel, new ViewGamemodesPanel(state));
        state.panels.put(PanelName.CreateGamemodePanel, new CreateGamemodePanel(state));

        state.contentPane.add(state.panels.get(PanelName.MainMenuPanel), PanelName.MainMenuPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.ViewGamemodesPanel), PanelName.ViewGamemodesPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.CreateGamemodePanel), PanelName.CreateGamemodePanel.toString());
        state.contentPane.add(new dart().getContentPane(), PanelName.Dart.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
