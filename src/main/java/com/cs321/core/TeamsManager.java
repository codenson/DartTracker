package com.cs321.core;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class manages teams.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class TeamsManager {
    
    /** The teams. */
    private ArrayList<Team> teams;

    /**
     * Get the teams.
     * 
     * @return The teams.
     */
    public Team[] getTeams() {
        Team[] teamsCopy = new Team[teams.size()];
        teams.toArray(teamsCopy);
        return teamsCopy;
    }

    /**
     * Set the teams.
     * 
     * @param teams The teams.
     */
    public void setTeams(Team[] teams) {
        this.teams = new ArrayList<Team>(Arrays.asList(teams));
    }

    /**
     * Create a new teams manager.
     * 
     * @param teams The teams.
     */
    public TeamsManager(Team[] teams) {
        setTeams(teams);
    }

    /**
     * Get the given player's team.
     * 
     * @param player The player.
     * @return The player's team.
     */
    public Team getPlayerTeam(Player player) {
        for (Team team : teams) {
            if (team.hasPlayer(player)) {
                return team;
            }
        }
        
        return null;
    }

}
