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

}
