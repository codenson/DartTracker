package com.cs321.core;

import com.cs321.gui.Dart_2;
import com.cs321.gui.GUIState;

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
    Dart_2 dartGui ; 
    private GUIState state;
    
    
  
  

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
        
        this.teamsManager = teamsManager;
        this.turnManager= turnManager;
        this.gameConfiguration = gameConfiguration;
        
        //dartGui = new Dart_2(state); 
       
       // setGameGui();//inner method call
        
        
         //
    }
//      private void playGame(){
//          dartGui.setGameConfigGui(gameConfiguration);
//       
//    
//    
//    
//    }
//      /**
//       * Method to initialize and update Dart_2 GUI.
//       */
//      private void setGameGui(){
//          String currentTeam = teamsManager.getPlayerTeam(turnManager.getCurrentPlayer()).getName(); 
//          
//          dartGui.teamAName.setText("");//sets team A name on GUI. 
//          dartGui.teamBName.setText("");//sets team b name on GUI. 
//          dartGui.roundValueBox.setText("");///sets round number on GUI. 
//          dartGui.playerNameBoxValue.setText(turnManager.getCurrentPlayer().getName());//sets current player,s name on GUI. 
//          dartGui.playingTeamBoxValue.setText(currentTeam);// sets current playing team on GUI.
//          dartGui.throwBoxValue.setText("");// initialize how many throws in a game.
//
//          
//         
//         teamsManager.getPlayerTeam(turnManager.getCurrentPlayer()).getName(); 
//          
//      
//      }
//      
      
      

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
     * Progress the current round by adding the score to the current round. The round is finished if
     * the number of throws is equal to the number of darts per round. If the score is overshot, the
     * round is added to the rounds manager if exact zero win is not enabled.
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
        
        if (isThrowsDone()) {
            throw new IllegalStateException("Cannot progress a round that has already been finished.");
        }

        currentRound.addScore(score);
    }

    /**
     * Finish the current round. If the score is overshot, the round is added to the rounds manager
     * if exact zero win is not enabled. If the round is not finished, add offboard penalty scores for
     * the remaining throws.
     */
    public void finishRound() {
        if (isGameFinished()) {
            throw new IllegalStateException("Cannot finish a round while the game is finished.");
        }
        if (currentRound == null) {
            throw new IllegalStateException("Cannot finish a round that has not been started.");
        }

        // If the round is not finished, add offboard penalty scores for the remaining throws.
        if (!isThrowsDone()) {
            for (int count = currentRound.getTotalThrows(); count < gameConfiguration.getDartsPerRound(); count++) {
                progressRound(gameConfiguration.getOffboardPenalty());
            }
        }

        int teamTotalScore = roundsManager.getTeamTotalScore(getCurrentTeam()) + currentRound.getTotalScore();
        boolean scoreOvershot = teamTotalScore > gameConfiguration.getStartingScore();

        if (!scoreOvershot || !gameConfiguration.isExactZeroWin()) {
            roundsManager.addRound(currentRound);
        }
        currentRound = null;
    }

    /**
     * Progress the current round by adding the score to the current round. The round is finished if
     * the number of throws is equal to the number of darts per round. If the score is overshot, the
     * round is added to the rounds manager if exact zero win is not enabled.
     * 
     * Uses normalized coordinates to determine the score.
     * 
     * @param nx The normalized x coordinate.
     * @param ny The normalized y coordinate.
     */
    public void progressRound(float nx, float ny) {
        int totalScore = DartboardUtils.getTotalScore(nx, ny, gameConfiguration);
        progressRound(totalScore);
    }

    /**
     * Whether or not the current round is finished.
     * 
     * @return Whether or not the current round is finished.
     */
    public boolean isRoundFinished() {
        return currentRound == null;
    }

    /**
     * Whether or not the throws are done.
     * 
     * @return Whether or not the throws are done.
     */
    public boolean isThrowsDone() {
        if (currentRound == null) {
            throw new IllegalStateException("Cannot check if throws are done when there is no current round.");
        }

        return currentRound.getTotalThrows() == gameConfiguration.getDartsPerRound();
    }

    /**
     * Get the current player.
     * 
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        if (currentRound == null) {
            throw new IllegalStateException("Cannot get the current player when there is no current round.");
        }

        return currentRound.getPlayer();
    }

    /**
     * Get the current team.
     * 
     * @return The current team.
     */
    public Team getCurrentTeam() {
        if (currentRound == null) {
            throw new IllegalStateException("Cannot get the current team when there is no current round.");
        }

        return teamsManager.getPlayerTeam(getCurrentPlayer());
    }

    /**
     * Get the next player.
     * 
     * @return The next player.
     */
    public Player getNextPlayer() {
        return turnManager.getCurrentPlayer();
    }

    /**
     * Get the next team.
     * 
     * @return The next team.
     */
    public Team getNextTeam() {
        return teamsManager.getPlayerTeam(getNextPlayer());
    }

    /**
     * Get the winner team of the game.
     * 
     * @return The winner team of the game.
     */
    public Team getWinnerTeam() {
        if (!isGameFinished()) {
            throw new IllegalStateException("Cannot get the winner team when the game is not finished.");
        }

        if (gameConfiguration.getMaximumRounds() > 0) {
            // If there is a maximum number of rounds, the team with the highest score wins.
            Team winnerTeam = null;
            int winnerTeamScore = 0;

            for (Team team : teamsManager.getTeams()) {
                int teamScore = roundsManager.getTeamTotalScore(team);
                if (teamScore > winnerTeamScore) {
                    winnerTeam = team;
                    winnerTeamScore = teamScore;
                }
            }

            return winnerTeam;
        } else {
            // If there is no maximum number of rounds, the team which reached the starting score first wins.
            for (Team team : teamsManager.getTeams()) {
                int teamScore = roundsManager.getTeamTotalScore(team);
                if (teamScore >= gameConfiguration.getStartingScore()) {
                    return team;
                }
            }
        }

        // This should never happen, its just here to make the compiler happy.
        return null;
    }
    /**
     * testing. 
     * @param args 
     */
   

}
