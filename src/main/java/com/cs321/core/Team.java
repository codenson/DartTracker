package com.cs321.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * This class represents a team.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class Team {
    
    /** The ID of this team. */
    private String id;

    /** The name of this team. */
    private String name;

    /** The players on this team. */
    private ArrayList<Player> players;

    /**
     * Get the ID of this team.
     * 
     * @return The ID of this team.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of this team.
     * 
     * @param id The ID of this team.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of this team.
     * 
     * @return The name of this team.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this team.
     * 
     * @param name The name of this team.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the players on this team.
     * 
     * @return The players on this team.
     */
    public Player[] getPlayers() {
        Player[] playersCopy = new Player[players.size()];
        players.toArray(playersCopy);
        return playersCopy;
    }

    /**
     * Set the players on this team.
     * 
     * @param players The players on this team.
     */
    public void setPlayers(Player[] players) {
        this.players = new ArrayList<Player>(Arrays.asList(players));
    }

    /**
     * Create a new team.
     * 
     * @param name The name of the team.
     * @param players The players on the team.
     */
    public Team(String name, Player[] players) {
        setId(UUID.randomUUID().toString());
        setName(name);
        setPlayers(players);
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
        Team other = (Team) obj;
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
