package com.cs321.core;

/**
 * This class manages the game.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class GameManager {
    
    /** The game configuration for this game. */
    private GameConfiguration gameConfiguration;

    /** The teams manager for this game. */
    private TeamsManager teamsManager;

    /** The turn manager for this game. */
    private TurnManager turnManager;

    /** The rounds manager for this game. */
    private RoundsManager roundsManager;

    /** The current round. */
    private Round currentRound;

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
     * Get the current round.
     * 
     * @return The current round.
     */
    public Round getCurrentRound() {
        return currentRound;
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

    /**
     * Begin a new round.
     */
    public void beginRound() {
        if (isGameFinished()) {
            throw new IllegalStateException("Cannot begin a new round while the game is finished.");
        }
        if (currentRound != null) {
            throw new IllegalStateException("Cannot begin a new round while the current round is still in progress.");
        }

        currentRound = new Round(turnManager.getCurrentPlayer());
        turnManager.nextTurn();
    }

    /**
     * Progress the current round.
     * 
     * @param score The next score for the current round.
     */
    public void progressRound(int score) {
        if (isGameFinished()) {
            throw new IllegalStateException("Cannot progress a round while the game is finished.");
        }
        if (currentRound == null) {
            throw new IllegalStateException("Cannot progress a round that has not been started.");
        }

        currentRound.addScore(score);
        if (currentRound.getTotalThrows() == gameConfiguration.getDartsPerRound()) {
            roundsManager.addRound(currentRound);
            currentRound = null;
        }
    }

    /**
     * Whether or not the current round is finished.
     * 
     * @return Whether or not the current round is finished.
     */
    public boolean isRoundFinished() {
        return currentRound == null;
    }

}
