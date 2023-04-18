package com.cs321.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.cs321.core.GameConfiguration;
import com.cs321.core.GameManager;
import com.cs321.core.Player;
import com.cs321.core.RoundsManager;
import com.cs321.core.Team;
import com.cs321.core.TeamsManager;
import com.cs321.core.TurnManager;
import com.cs321.core.TurnManager.TurnManagerBuilder;

/**
 * Holds the state of the GUI
 * 
 * @author Hasnain Raza
 */
public class GUIState {

    // Enum for the panel names
    public static enum PanelName {
        MainMenuPanel, ViewGamemodesPanel, CreateGamemodePanel, EditGamemodePanel,
        ViewPlayersPanel, ChooseGametypePanel, ChoosePlayersPanel, ChooseGameConfigurationPanel,
        Dart_2
    }
    // The content pane of the JFrame
    public Container contentPane;
    // The CardLayout of the content pane
    public CardLayout contentPaneCardLayout;
    // The map of panels
    public HashMap<PanelName, UpdateableJPanel> panels = new HashMap<>();



    // The list of game configurations
    public ArrayList<GameConfiguration> gameConfigurations = new ArrayList<>();
    // The index of the game configuration to edit
    public int toEditGameConfigurationIndex = -1;



    // The list of players
    public ArrayList<Player> players = new ArrayList<>();



    // Enum for the gametype
    public static enum Gametype {
        FreeForAll, Teams
    }
    // The chosen gametype
    public Gametype chosenGametype = Gametype.FreeForAll;
    // The list of players chosen for the game
    public ArrayList<Player> chooseGametypePlayers = new ArrayList<>();
    // The list of teams and players within chosen for the game
    public ArrayList<ArrayList<Player>> chooseGametypeTeams = new ArrayList<>();
    // The index of the player to edit
    public int choosePlayerIndex = -1;
    // The index of the team to edit
    public int chooseTeamIndex = -1;
    // The remove sentinel for choosing players
    public Player removeChosenPlayerSentinel = new Player("REMOVE_PLAYER_SENTINEL");
    // The game configuration to use for the game
    public GameConfiguration chooseGametypeGameConfiguration = null;
    /**
     * Gets the list of players to choose from
     * 
     * @return the list of players to choose from
     */
    public Player[] getPlayersToChoose() {
        HashSet<Player> chosenPlayers = new HashSet<>();
        chosenPlayers.addAll(chooseGametypePlayers);
        for (ArrayList<Player> team : chooseGametypeTeams) {
            chosenPlayers.addAll(team);
        }

        ArrayList<Player> playersToChoose = new ArrayList<>();
        for (Player player : players) {
            if (!chosenPlayers.contains(player)) {
                playersToChoose.add(player);
            }
        }

        return playersToChoose.toArray(new Player[playersToChoose.size()]);
    }
    /**
     * Adds the chosen player to the appropriate list based on the chosen gametype
     * 
     * @param player the chosen player, can be the remove sentinel
     */
    public void addChosenPlayer(Player player) {
        if (chosenGametype == Gametype.FreeForAll) {
            if (player == removeChosenPlayerSentinel) {
                if (chooseGametypePlayers.size() > choosePlayerIndex) {
                    chooseGametypePlayers.remove(choosePlayerIndex);
                }
            } else {
                if (chooseGametypePlayers.size() > choosePlayerIndex) {
                    chooseGametypePlayers.set(choosePlayerIndex, player);
                } else {
                    chooseGametypePlayers.add(player);
                }
            }
        } else if (chosenGametype == Gametype.Teams) {
            // If the player name is empty ...
            if (player == removeChosenPlayerSentinel) {
                // ... and the team exists ...
                if (chooseGametypeTeams.size() > chooseTeamIndex) {
                    ArrayList<Player> team = chooseGametypeTeams.get(chooseTeamIndex);
                    // ... and the player exists, remove the player
                    if (team.size() > choosePlayerIndex) {
                        team.remove(choosePlayerIndex);
                    }
                    // If the team becomes empty, remove the team
                    if (team.isEmpty()) {
                        chooseGametypeTeams.remove(chooseTeamIndex);
                    }
                }
            } else {
                // If the team exists ...
                if (chooseGametypeTeams.size() > chooseTeamIndex) {
                    ArrayList<Player> team = chooseGametypeTeams.get(chooseTeamIndex);
                    // ... and the player exists, set the player's name
                    if (team.size() > choosePlayerIndex) {
                        team.set(choosePlayerIndex, player);
                    // ... and the player doesn't exist, add the player
                    } else {
                        team.add(player);
                    }
                // If the team doesn't exist, add the team
                } else {
                    ArrayList<Player> team = new ArrayList<>();
                    team.add(player);
                    chooseGametypeTeams.add(team);
                }
            }
        }
    }
    /**
     * Clears the chosen Players and GameConfiguration
     */
    public void clearChooseGametypeChoices() {
        chooseGametypePlayers.clear();
        chooseGametypeTeams.clear();
        chooseGametypeGameConfiguration = null;
    }
    /**
     * Checks if the chosen players and game configuration can be used to generate a GameManager
     * 
     * @return true if the chosen players and game configuration can be used to generate a GameManager
     */
    public boolean canGenerateGameManager() {
        if (chooseGametypeGameConfiguration == null) {
            return false;
        }

        if (chosenGametype == Gametype.FreeForAll) {
            return chooseGametypePlayers.size() >= 2;
        } else if (chosenGametype == Gametype.Teams) {
            return chooseGametypeTeams.size() >= 2;
        }

        return false;
    }
    /**
     * Generate a GameManager from the chosen players and game configuration.
     * 
     * @return the generated GameManager
     */
    public GameManager generateGameManager() {
        // Generate the GameConfiguration
        GameConfiguration gameConfiguration = chooseGametypeGameConfiguration;

        // Generate the TeamsManager
        ArrayList<Team> teams = new ArrayList<>();
        if (chosenGametype == Gametype.FreeForAll) {
            for (Player player : chooseGametypePlayers) {
                teams.add(new Team(player.getName(), new Player[] { player }));
            }
        } else if (chosenGametype == Gametype.Teams) {
            for (int teamIndex = 0; teamIndex < chooseGametypeTeams.size(); teamIndex++) {
                String teamName = "Team " + (teamIndex + 1);
                Player[] teamPlayers = chooseGametypeTeams.get(teamIndex).toArray(new Player[0]);
                teams.add(new Team(teamName, teamPlayers));
            }
        }
        TeamsManager teamsManager = new TeamsManager(teams.toArray(new Team[0]));

        // Generate the TurnManager
        Team[] teamsArray = teams.toArray(new Team[0]);
        TurnManager turnManager = TurnManager.fromTeams(teamsArray);

        // Generate the RoundsManager
        RoundsManager roundsManager = new RoundsManager();

        // Generate the GameManager
        return new GameManager(gameConfiguration, teamsManager,
        turnManager, roundsManager);
    }
    


    // The GameManager to use for the game
    GameManager gameManager = null;

}
