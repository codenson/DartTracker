package com.cs321.core;

/**
 * This class represents the statistics of a game from the perspective of a
 * specific player.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class GameStats {
    
    /** Number of rounds played in this game. */
    private int roundsPlayed;

    /** Score by the player's team for each round they played. */
    private int[] teamScores;

    /** The ID of the gamemode used for this game. */
    private String gamemodeId;

    /** Whether or not the player won this game. */
    private boolean playerWon;

    /**
     * Get the number of rounds played in this game.
     * 
     * @return The number of rounds played in this game.
     */
    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    /**
     * Set the number of rounds played in this game.
     * 
     * @param roundsPlayed The number of rounds played in this game.
     */
    public void setRoundsPlayed(int roundsPlayed) {
        this.roundsPlayed = roundsPlayed;
    }

    /**
     * Get the score by the player's team for each round they played.
     * 
     * @return The score by the player's team for each round they played.
     */
    public int[] getTeamScores() {
        int[] teamScoresCopy = new int[teamScores.length];
        System.arraycopy(teamScores, 0, teamScoresCopy, 0, teamScores.length);
        return teamScoresCopy;
    }

    /**
     * Set the score by the player's team for each round they played.
     * 
     * @param teamScores The score by the player's team for each round they
     * played.
     */
    public void setTeamScores(int[] teamScores) {
        this.teamScores = new int[teamScores.length];
        System.arraycopy(teamScores, 0, this.teamScores, 0, teamScores.length);
    }

    /**
     * Get the ID of the gamemode used for this game.
     * 
     * @return The ID of the gamemode used for this game.
     */
    public String getGamemodeId() {
        return gamemodeId;
    }

    /**
     * Set the ID of the gamemode used for this game.
     * 
     * @param gamemodeId The ID of the gamemode used for this game.
     */
    public void setGamemodeId(String gamemodeId) {
        this.gamemodeId = gamemodeId;
    }

    /**
     * Get whether or not the player won this game.
     * 
     * @return Whether or not the player won this game.
     */
    public boolean isPlayerWon() {
        return playerWon;
    }

    /**
     * Set whether or not the player won this game.
     * 
     * @param playerWon Whether or not the player won this game.
     */
    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }

    /**
     * Create a new GameStats object.
     * 
     * @param roundsPlayed The number of rounds played in this game.
     * @param teamScores The score by the player's team for each round they
     * played.
     * @param gamemodeId The ID of the gamemode used for this game.
     * @param playerWon Whether or not the player won this game.
     */
    public GameStats(int roundsPlayed, int[] teamScores, String gamemodeId,
            boolean playerWon) {
        setRoundsPlayed(roundsPlayed);
        setTeamScores(teamScores);
        setGamemodeId(gamemodeId);
        setPlayerWon(playerWon);
    }

}
