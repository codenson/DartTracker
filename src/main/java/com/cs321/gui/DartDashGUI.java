/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cs321.gui;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.cs321.core.GameConfiguration;
import com.cs321.core.Player;
import com.cs321.gui.GUIState.PanelName;
import com.cs321.io.IOUtils;

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

        state.panels.put(PanelName.MainMenuPanel, new MainMenuPanel(state));
        state.panels.put(PanelName.ViewGamemodesPanel, new ViewGamemodesPanel(state));
        state.panels.put(PanelName.CreateGamemodePanel, new CreateGamemodePanel(state));
        state.panels.put(PanelName.EditGamemodePanel, new EditGamemodePanel(state));
        state.panels.put(PanelName.ViewPlayersPanel, new ViewPlayersPanel(state));
        state.panels.put(PanelName.ChooseGametypePanel, new ChooseGametypePanel(state));
        state.panels.put(PanelName.ChoosePlayersPanel, new ChoosePlayersPanel(state));
        state.panels.put(PanelName.ChooseGameConfigurationPanel, new ChooseGamemodePanel(state));
        state.panels.put(PanelName.PlayPanel, new PlayPanel(state));
        state.panels.put(PanelName.GameSummaryPanel, new GameSummaryPanel(state));
        state.panels.put(PanelName.Dart_2, new Dart_2(state));

        state.contentPane.add(state.panels.get(PanelName.MainMenuPanel), PanelName.MainMenuPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.ViewGamemodesPanel), PanelName.ViewGamemodesPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.CreateGamemodePanel), PanelName.CreateGamemodePanel.toString());
        state.contentPane.add(state.panels.get(PanelName.EditGamemodePanel), PanelName.EditGamemodePanel.toString());
        state.contentPane.add(state.panels.get(PanelName.ViewPlayersPanel), PanelName.ViewPlayersPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.ChooseGametypePanel), PanelName.ChooseGametypePanel.toString());
        state.contentPane.add(state.panels.get(PanelName.ChoosePlayersPanel), PanelName.ChoosePlayersPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.ChooseGameConfigurationPanel), PanelName.ChooseGameConfigurationPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.PlayPanel), PanelName.PlayPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.GameSummaryPanel), PanelName.GameSummaryPanel.toString());
        state.contentPane.add(state.panels.get(PanelName.Dart_2),PanelName.Dart_2.toString());

        if (initIOUtils()) {
            if (!loadGameConfigurations(state)) {
                state.gameConfigurations.add(new GameConfiguration());
            }
            loadPlayers(state);
        }
    }

    /**
     * Initializes the IOUtils.
     * 
     * @return true if the IOUtils was initialized successfully, false otherwise
     */
    private boolean initIOUtils() {
        try {
            IOUtils.init();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error initializing save folders and files: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Loads all the game configurations.
     * 
     * @param state the GUIState
     * @return true if the game configurations were loaded successfully, false otherwise
     */
    private boolean loadGameConfigurations(GUIState state) {
        try {
            for (GameConfiguration gameConfiguration : IOUtils.loadAllGameConfigurations()) {
                state.gameConfigurations.add(gameConfiguration);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading gamemodes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Loads all the players.
     * 
     * @param state the GUIState
     * @return true if the players were loaded successfully, false otherwise
     */
    private boolean loadPlayers(GUIState state) {
        try {
            for (Player player : IOUtils.loadAllPlayers()) {
                state.players.add(player);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading players: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
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
