package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeamTest {
    
    /**
     * New Team created properly.
     */
    @Test
    public void newTeam() {
        String name = "Team 1";
        Player[] players = new Player[0];

        Team team = new Team(name, players);

        assertNotNull(team);
        assertNotNull(team.getId());
        assertEquals(name, team.getName());
        assertNotNull(team.getPlayers());
    }

}
