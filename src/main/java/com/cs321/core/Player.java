package com.cs321.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * This class represents a player.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class Player {
    
    /** The ID of this player. */
    private String id;

    /** The name of this player. */
    private String name;

    /** The gamestats of the player from previous games. */
    private ArrayList<GameStats> gameStats;

    /**
     * Get the ID of this player.
     * 
     * @return The ID of this player.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of this player.
     * 
     * @param id The ID of this player.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of this player.
     * 
     * @return The name of this player.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this player.
     * 
     * @param name The name of this player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the gamestats of the player from previous games.
     * 
     * @return The gamestats of the player from previous games.
     */
    public GameStats[] getGameStats() {
        GameStats[] gameStatsCopy = new GameStats[gameStats.size()];
        gameStats.toArray(gameStatsCopy);
        return gameStatsCopy;
    }

    /**
     * Set the gamestats of the player from previous games.
     * 
     * @param gameStats The gamestats of the player from previous games.
     */
    public void setGameStats(GameStats[] gameStats) {
        this.gameStats = new ArrayList<GameStats>(Arrays.asList(gameStats));
    }

    /**
     * Add a new gamestats to this player.
     * 
     * @param gameStats The gamestats to add.
     */
    public void addGameStats(GameStats gameStats) {
        this.gameStats.add(gameStats);
    }

    /**
     * Create a new player with the given ID, name, and GameStats.
     * 
     * @param id The ID of this player.
     * @param name The name of this player.
     * @param gameStats The gamestats of the player from previous games.
     */
    public Player(String id, String name, GameStats[] gameStats) {
        setId(id);
        setName(name);
        setGameStats(gameStats);
    }

    /**
     * Create a new player with the given name.
     * 
     * @param name The name of this player.
     */
    public Player(String name) {
        this(UUID.randomUUID().toString(), name, new GameStats[0]);
    }

    /**
     * Get the number of games this player has played.
     * 
     * @return The number of games this player has played.
     */
    public int getGamesPlayed() {
        return gameStats.size();
    }

    /**
     * Get the number of games this player has played.
     * 
     * @return The number of games this player has played.
     */
    public int getWins() {
        return (int) gameStats.stream().filter(gs -> gs.isPlayerWon()).count();
    }

    /**
     * Get the number of games this player has lost.
     * 
     * @return The number of games this player has lost.
     */
    public int getLosses() {
        return (int) gameStats.stream().filter(gs -> !gs.isPlayerWon()).count();
    }

    /**
     * Get the win rate of this player.
     * 
     * @return The win rate of this player.
     */
    public float getWinRate() {
        return (float) getWins() / getGamesPlayed();
    }

    /**
     * Get the win/loss ratio of this player.
     * 
     * @return The win/loss ratio of this player.
     */
    public float getWinLossRatio() {
        return (float) getWins() / getLosses();
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
        Player other = (Player) obj;
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
