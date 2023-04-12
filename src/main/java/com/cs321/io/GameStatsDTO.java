package com.cs321.io;

/**
 * A data transfer object for the GameStats class.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class GameStatsDTO {
    
    /** Number of rounds played in this game. */
    public int roundsPlayed;

    /** Score by the player's team for each round they played. */
    public int[] teamScores;

    /** The ID of the gamemode used for this game. */
    public String gamemodeId;

    /** Whether or not the player won this game. */
    public boolean playerWon;

}
