package com.cs321.core;

/**
 * This class manages the game.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class GameManager {
    
    /** The game configuration for this game. */
    GameConfiguration gameConfiguration;

    /** The teams manager for this game. */
    TeamsManager teamsManager;

    /** The turn manager for this game. */
    TurnManager turnManager;

    /** The rounds manager for this game. */
    RoundsManager roundsManager;

    /**
     * Get the game configuration for this game.
     * 
     * @return The game configuration for this game.
     */
    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }

    /**
     * Set the game configuration for this game.
     * 
     * @param gameConfiguration The game configuration for this game.
     */
    public void setGameConfiguration(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }

    /**
     * Get the teams manager for this game.
     * 
     * @return The teams manager for this game.
     */
    public TeamsManager getTeamsManager() {
        return teamsManager;
    }

    /**
     * Set the teams manager for this game.
     * 
     * @param teamsManager The teams manager for this game.
     */
    public void setTeamsManager(TeamsManager teamsManager) {
        this.teamsManager = teamsManager;
    }

    /**
     * Get the turn manager for this game.
     * 
     * @return The turn manager for this game.
     */
    public TurnManager getTurnManager() {
        return turnManager;
    }

    /**
     * Set the turn manager for this game.
     * 
     * @param turnManager The turn manager for this game.
     */
    public void setTurnManager(TurnManager turnManager) {
        this.turnManager = turnManager;
    }

    /**
     * Get the rounds manager for this game.
     * 
     * @return The rounds manager for this game.
     */
    public RoundsManager getRoundsManager() {
        return roundsManager;
    }

    /**
     * Set the rounds manager for this game.
     * 
     * @param roundsManager The rounds manager for this game.
     */
    public void setRoundsManager(RoundsManager roundsManager) {
        this.roundsManager = roundsManager;
    }

    /**
     * Create a new game manager.
     * 
     * @param gameConfiguration The game configuration for this game.
     * @param teamsManager The teams manager for this game.
     * @param turnManager The turn manager for this game.
     * @param roundsManager The rounds manager for this game.
     */
    public GameManager(GameConfiguration gameConfiguration, TeamsManager teamsManager,
        TurnManager turnManager, RoundsManager roundsManager) {
        setGameConfiguration(gameConfiguration);
        setTeamsManager(teamsManager);
        setTurnManager(turnManager);
        setRoundsManager(roundsManager);
    }

    /**
     * Whether the game is finished or not. A game can be finished in a few ways:
     * 
     * 1. The maximum number of rounds are played if configured so.
     * 2. A team has reached the maximum number of points.
     * 
     * @return Whether the game is finished or not.
     */
    public boolean isGameFinished() {
        // If the maximum number of rounds are played, the game is finished.
        if (gameConfiguration.getMaximumRounds() == roundsManager.getTotalRounds()) {
            return true;
        }

        // If a team has reached the maximum number of points, the game is finished.
        for (Team team : teamsManager.getTeams()) {
            int teamScore = roundsManager.getTeamTotalScore(team);
            if (teamScore >= gameConfiguration.getStartingScore()) {
                return true;
            }
        }

        return false;
    }

}
