package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTest {
    
    /**
     * New Round created properly.
     */
    @Test
    public void newRound() {
        Player player = new Player("John Doe");

        Round round = new Round(player);

        assertNotNull(round);
        assertNotNull(round.getId());
        assertEquals(player, round.getPlayer());
        assertNotNull(round.getScores());
    }

    /**
     * New score added properly.
     */
    @Test
    public void newScore() {
        Player player = new Player("John Doe");
        Round round = new Round(player);

        round.addScore(10);

        assertEquals(1, round.getScores().length);
        assertEquals(10, round.getScores()[0]);
    }

    /**
     * isPlayedBy for teams works properly.
     */
    @Test
    public void isPlayedByForTeams() {
        String playername1 = "John Doe";
        String playername2 = "Jane Doe";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);

        String teamname1 = "Team 1";
        String teamname2 = "Team 2";
        Player[] players1 = new Player[] { player1 };
        Player[] players2 = new Player[] { player2 };
        Team team1 = new Team(teamname1, players1);
        Team team2 = new Team(teamname2, players2);

        Round round = new Round(player1);

        assertTrue(round.isPlayedBy(team1));
        assertFalse(round.isPlayedBy(team2));
    }

}
