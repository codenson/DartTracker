package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
    
    /**
     * New Player created properly.
     */
    @Test
    public void newPlayer() {
        String id = "random_uuid";
        String name = "John Doe";
        GameStats[] gameStats = new GameStats[0];

        Player player = new Player(id, name, gameStats);

        assertNotNull(player);
        assertEquals(id, player.getId());
        assertEquals(name, player.getName());
        assertNotNull(player.getGameStats());
    }

    /**
     * New Player created properly with only name.
     */
    @Test
    public void newPlayerWithName() {
        String name = "John Doe";

        Player player = new Player(name);

        assertNotNull(player);
        assertNotNull(player.getId());
        assertEquals(name, player.getName());
        assertNotNull(player.getGameStats());
    }

}
