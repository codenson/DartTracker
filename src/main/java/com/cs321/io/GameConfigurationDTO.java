package com.cs321.io;

/**
 * A data transfer object for the GameConfiguration class.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class GameConfigurationDTO {
    
    /** The unique ID of the gamemode. */
    public String id;

    /** The name of the gamemode. */
    public String name;
    
    /** The numbers of darts per round. */
    public int dartsPerRound;

    /** The maximum number of rounds per game, -1 for as many as necessary. */
    public int maximumRounds;

    /** The starting score for each team or player. */
    public int startingScore;

    /** The amount to penalize a player for shooting offboard. */
    public int offboardPenalty;

    /**
     * A list of 21 integers representing the score for each section of the board.
     * The last integer is the score for the bullseye.
     */
    public int[] scoreList;

    /**
     * A list of 3 floats representing the multiplier for the two rings.
     * The first float is the multiplier for the outer ring, the second is the
     * multiplier for the inner ring, and the third is the multiplier for the
     * bullseye ring.
     */
    public float[] multipliers;

    /** Whether or not the score has to match exactly to win. */
    public boolean exactZeroWin;

    /** Whether or not to count downwards towards zero. */
    public boolean subtractPoints;

}
