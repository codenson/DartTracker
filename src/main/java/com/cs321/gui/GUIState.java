package com.cs321.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;

import com.cs321.core.GameConfiguration;
import com.cs321.core.Player;

/**
 * Holds the state of the GUI
 * 
 * @author Hasnain Raza
 */
public class GUIState {

    /**
     * Enum for the names of the panels
     */
    public static enum PanelName {
        MainMenuPanel, ViewGamemodesPanel, CreateGamemodePanel, EditGamemodePanel,
        ViewPlayersPanel, Dart_2
    }
    
    // The content pane of the JFrame
    public Container contentPane;
    // The CardLayout of the content pane
    public CardLayout contentPaneCardLayout;

    // The list of game configurations
    public ArrayList<GameConfiguration> gameConfigurations;
    // The map of panels
    public HashMap<PanelName, UpdateableJPanel> panels;

    // The index of the game configuration to edit
    public int toEditGameConfigurationIndex;

    // The list of players
    public ArrayList<Player> players;

    /**
     * Creates a new GUIState
     */
    public GUIState() {
        gameConfigurations = new ArrayList<GameConfiguration>();
        panels = new HashMap<PanelName, UpdateableJPanel>();
        toEditGameConfigurationIndex = -1;
        players = new ArrayList<Player>();
    }

}
