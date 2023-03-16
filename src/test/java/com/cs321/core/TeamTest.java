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

    /**
     * hasPlayer works properly.
     */
    @Test
    public void hasPlayer() {
        String playername1 = "John Doe";
        String playername2 = "Jane Doe";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);

        String teamname = "Team 1";
        Player[] players = new Player[] { player1 };
        Team team = new Team(teamname, players);

        assertTrue(team.hasPlayer(player1));
        assertFalse(team.hasPlayer(player2));
    }

}
