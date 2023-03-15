package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cs321.core.GameConfiguration.GameConfigurationBuilder;

public class GameConfigurationTest {
    
    /**
     * GameConfigurationBuilder should be able to build a default GameConfiguration.
     */
    @Test
    public void buildDefaultGameConfiguration() {
        GameConfiguration config = new GameConfigurationBuilder().build();

        int[] defaultScoreList = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 50};
        float[] defaultMultiplers = new float[] {2.0f, 3.0f};

        assertEquals("Default", config.getName());
        assertEquals(3, config.getDartsPerRound());
        assertEquals(-1, config.getMaximumRounds());
        assertEquals(301, config.getStartingScore());
        assertEquals(0, config.getOffboardPenalty());
        assertArrayEquals(defaultScoreList, config.getScoreList());
        assertArrayEquals(defaultMultiplers, config.getMultipliers(), 0.001f);
        assertTrue(config.isExactZeroWin());
        assertTrue(config.isSubtractPoints());
    }

    /**
     * GameConfigurationBuilder should be able to build a custom GameConfiguration.
     */
    @Test
    public void buildCustomGameConfiguration() {
        GameConfiguration config = new GameConfigurationBuilder()
            .withName("CustomMode1")
            .withDartsPerRound(4)
            .withMaximumRounds(20)
            .withStartingScore(451)
            .withOffboardPenalty(100)
            .withScoreList(new int[] {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 100})
            .withMultipliers(new float[] {3.0f, 5.0f})
            .withExactZeroWin(true)
            .withSubtractPoints(true)
            .build();

        int[] customScoreList = new int[] {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 100};
        float[] customMultiplers = new float[] {3.0f, 5.0f};

        assertEquals("CustomMode1", config.getName());
        assertEquals(4, config.getDartsPerRound());
        assertEquals(20, config.getMaximumRounds());
        assertEquals(451, config.getStartingScore());
        assertEquals(100, config.getOffboardPenalty());
        assertArrayEquals(customScoreList, config.getScoreList());
        assertArrayEquals(customMultiplers, config.getMultipliers(), 0.001f);
        assertTrue(config.isExactZeroWin());
        assertTrue(config.isSubtractPoints());
    }

}
