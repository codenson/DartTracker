package com.cs321.core;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents a round.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class Round {
    
    /** The ID of this round. */
    private String id;

    /** The player who is played this round. */
    private Player player;

    /** The scores of this round. */
    private ArrayList<Integer> scores;

    /**
     * Get the ID of this round.
     * 
     * @return The ID of this round.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of this round.
     * 
     * @param id The ID of this round.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the player who is played this round.
     * 
     * @return The player who is played this round.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Set the player who is played this round.
     * 
     * @param player The player who is played this round.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Get the scores of this round.
     * 
     * @return The scores of this round.
     */
    public int[] getScores() {
        return scores.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Set the scores of this round.
     * 
     * @param scores The scores of this round.
     */
    public void setScores(int[] scores) {
        this.scores = new ArrayList<Integer>();
        for (int score : scores) {
            this.scores.add(score);
        }
    }

    /**
     * Add a score to this round.
     * 
     * @param score The score to add.
     */
    public void addScore(int score) {
        this.scores.add(score);
    }

    /**
     * Get the total score of this round.
     * 
     * @return The total score of this round.
     */
    public int getTotalScore() {
        return scores.stream().mapToInt(i -> i).sum();
    }

    /**
     * Create a new round.
     * 
     * @param player The player who is played this round.
     */
    public Round(Player player) {
        setId(UUID.randomUUID().toString());
        setPlayer(player);
        setScores(new int[0]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Round other = (Round) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
