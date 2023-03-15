package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameStatsTest {
    
    /**
     * New GameStats created properly.
     */
    @Test
    public void newGameStats() {
        int roundsPlayed = 5;
        int[] teamScores = {1, 2, 3, 4, 5};
        String gamemodeId = "random_uuid";
        boolean playerWon = true;

        GameStats gameStats = new GameStats(roundsPlayed, teamScores, gamemodeId, playerWon);

        assertNotNull(gameStats);
        assertEquals(roundsPlayed, gameStats.getRoundsPlayed());
        assertArrayEquals(teamScores, gameStats.getTeamScores());
        assertEquals(gamemodeId, gameStats.getGamemodeId());
        assertEquals(playerWon, gameStats.isPlayerWon());
    }

}
