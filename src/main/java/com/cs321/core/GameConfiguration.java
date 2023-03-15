package com.cs321.core;

/**
 * This class represents the configurations for the game (or gamemode).
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class GameConfiguration {

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
     * A list of 2 floats representing the multiplier for the two rings.
     * The first float is the multiplier for the outer ring, the second is the
     * multiplier for the inner ring.
     */
    private float[] multipliers;

    /** Whether or not the score has to match exactly to win. */
    private boolean exactZeroWin;

    /** Whether or not to count downwards towards zero. */
    private boolean subtractPoints;

    /**
     * Get the name of the gamemode.
     * 
     * @return The name of the gamemode.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the gamemode.
     * 
     * @param name The name of the gamemode.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the number of darts per round.
     * 
     * @return The number of darts per round.
     */
    public int getDartsPerRound() {
        return dartsPerRound;
    }

    /**
     * Set the number of darts per round.
     * 
     * @param dartsPerRound The number of darts per round.
     */
    public void setDartsPerRound(int dartsPerRound) {
        this.dartsPerRound = dartsPerRound;
    }

    /**
     * Get the maximum number of rounds per game.
     * 
     * @return The maximum number of rounds per game.
     */
    public int getMaximumRounds() {
        return maximumRounds;
    }

    /**
     * Set the maximum number of rounds per game.
     * 
     * @param maximumRounds The maximum number of rounds per game.
     */
    public void setMaximumRounds(int maximumRounds) {
        this.maximumRounds = maximumRounds;
    }

    /**
     * Get the starting score for each team or player.
     * 
     * @return The starting score for each team or player.
     */
    public int getStartingScore() {
        return startingScore;
    }

    /**
     * Set the starting score for each team or player.
     * 
     * @param startingScore The starting score for each team or player.
     */
    public void setStartingScore(int startingScore) {
        this.startingScore = startingScore;
    }

    /**
     * Get the amount to penalize a player for shooting offboard.
     * 
     * @return The amount to penalize a player for shooting offboard.
     */
    public int getOffboardPenalty() {
        return offboardPenalty;
    }

    /**
     * Set the amount to penalize a player for shooting offboard.
     * 
     * @param offboardPenalty The amount to penalize a player for shooting offboard.
     */
    public void setOffboardPenalty(int offboardPenalty) {
        this.offboardPenalty = offboardPenalty;
    }

    /**
     * Get the score for each section of the board.
     * 
     * @return The score for each section of the board.
     */
    public int[] getScoreList() {
        int[] scoreListCopy = new int[scoreList.length];
        System.arraycopy(scoreList, 0, scoreListCopy, 0, scoreList.length);
        return scoreListCopy;
    }

    /**
     * Set the score for each section of the board.
     * 
     * @param scoreList The score for each section of the board.
     */
    public void setScoreList(int[] scoreList) {
        this.scoreList = new int[scoreList.length];
        System.arraycopy(scoreList, 0, this.scoreList, 0, scoreList.length);
    }

    /**
     * Get the multipliers for the two rings.
     * 
     * @return The multiplier for the two rings.
     */
    public float[] getMultipliers() {
        float[] multipliersCopy = new float[2];
        System.arraycopy(multipliers, 0, multipliersCopy, 0, 2);
        return multipliersCopy;
    }

    /**
     * Set the multipliers for the two rings.
     * 
     * @param multipliers The multiplier for the two rings.
     */
    public void setMultipliers(float[] multipliers) {
        this.multipliers = new float[2];
        System.arraycopy(multipliers, 0, this.multipliers, 0, 2);
    }

    /**
     * Get whether or not the score has to match exactly to win.
     * 
     * @return Whether or not the score has to match exactly to win.
     */
    public boolean isExactZeroWin() {
        return exactZeroWin;
    }

    /**
     * Set whether or not the score has to match exactly to win.
     * 
     * @param exactZeroWin Whether or not the score has to match exactly to win.
     */
    public void setExactZeroWin(boolean exactZeroWin) {
        this.exactZeroWin = exactZeroWin;
    }

    /**
     * Get whether or not to count downwards towards zero.
     * 
     * @return Whether or not to count downwards towards zero.
     */
    public boolean isSubtractPoints() {
        return subtractPoints;
    }

    /**
     * Set whether or not to count downwards towards zero.
     * 
     * @param subtractPoints Whether or not to count downwards towards zero.
     */
    public void setSubtractPoints(boolean subtractPoints) {
        this.subtractPoints = subtractPoints;
    }

    /**
     * Create a new GameConfiguration with default values.
     * Please use the builder class to create a new GameConfiguration.
     * 
     * @return A new GameConfiguration with default values.
     */
    private GameConfiguration() {
        this.name = "Default";
        this.dartsPerRound = 3;
        this.maximumRounds = -1;
        this.startingScore = 301;
        this.offboardPenalty = 0;
        this.scoreList = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 50};
        this.multipliers = new float[] {2.0f, 3.0f};
        this.exactZeroWin = true;
        this.subtractPoints = true;
    }

    /**
     * A builder class for GameConfiguration.
     * 
     * @author James Luna, Hasnain Raza, Marouane Guerouji
     */
    public static class GameConfigurationBuilder {

        /** The GameConfiguration instance that is being built */
        private GameConfiguration gameConfiguration;

        /**
         * Create a new GameConfigurationBuilder.
         * 
         * @return A new GameConfigurationBuilder.
         */
        public GameConfigurationBuilder() {
            gameConfiguration = new GameConfiguration();
        }

        /**
         * Set the name of the gamemode.
         * 
         * @param name The name of the gamemode.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withName(String name) {
            gameConfiguration.setName(name);
            return this;
        }

        /**
         * Set the number of darts per round.
         * 
         * @param dartsPerRound The number of darts per round.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withDartsPerRound(int dartsPerRound) {
            gameConfiguration.setDartsPerRound(dartsPerRound);
            return this;
        }

        /**
         * Set the maximum number of rounds per game.
         * 
         * @param maximumRounds The maximum number of rounds per game.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withMaximumRounds(int maximumRounds) {
            gameConfiguration.setMaximumRounds(maximumRounds);
            return this;
        }

        /**
         * Set the starting score for each team or player.
         * 
         * @param startingScore The starting score for each team or player.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withStartingScore(int startingScore) {
            gameConfiguration.setStartingScore(startingScore);
            return this;
        }

        /**
         * Set the amount to penalize a player for shooting offboard.
         * 
         * @param offboardPenalty The amount to penalize a player for shooting offboard.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withOffboardPenalty(int offboardPenalty) {
            gameConfiguration.setOffboardPenalty(offboardPenalty);
            return this;
        }

        /**
         * Set the score for each section of the board.
         * 
         * @param scoreList The score for each section of the board.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withScoreList(int[] scoreList) {
            gameConfiguration.setScoreList(scoreList);
            return this;
        }

        /**
         * Set the multipliers for the two rings.
         * 
         * @param multipliers The multiplier for the two rings.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withMultipliers(float[] multipliers) {
            gameConfiguration.setMultipliers(multipliers);
            return this;
        }

        /**
         * Set whether or not the score has to match exactly to win.
         * 
         * @param exactZeroWin Whether or not the score has to match exactly to win.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withExactZeroWin(boolean exactZeroWin) {
            gameConfiguration.setExactZeroWin(exactZeroWin);
            return this;
        }

        /**
         * Set whether or not to count downwards towards zero.
         * 
         * @param subtractPoints Whether or not to count downwards towards zero.
         * @return The GameConfigurationBuilder.
         */
        public GameConfigurationBuilder withSubtractPoints(boolean subtractPoints) {
            gameConfiguration.setSubtractPoints(subtractPoints);
            return this;
        }

        /**
         * Build the GameConfiguration.
         * 
         * @return The GameConfiguration.
         */
        public GameConfiguration build() {
            return gameConfiguration;
        }

    }

}
