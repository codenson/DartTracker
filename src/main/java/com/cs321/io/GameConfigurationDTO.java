package com.cs321.io;

/**
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class GameConfigurationDTO {
    
    /** The unique ID of the gamemode. */
    private String id;

    /** The name of the gamemode. */
    private String name;
    
    /** The numbers of darts per round. */
    private int dartsPerRound;

    /** The maximum number of rounds per game, -1 for as many as necessary. */
    private int maximumRounds;

    /** The starting score for each team or player. */
    private int startingScore;

    /** The amount to penalize a player for shooting offboard. */
    private int offboardPenalty;

    /**
     * A list of 21 integers representing the score for each section of the board.
     * The last integer is the score for the bullseye.
     */
    private int[] scoreList;

    /**
     * A list of 3 floats representing the multiplier for the two rings.
     * The first float is the multiplier for the outer ring, the second is the
     * multiplier for the inner ring, and the third is the multiplier for the
     * bullseye ring.
     */
    private float[] multipliers;

    /** Whether or not the score has to match exactly to win. */
    private boolean exactZeroWin;

    /** Whether or not to count downwards towards zero. */
    private boolean subtractPoints;

}
