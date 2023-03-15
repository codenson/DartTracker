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

    /**
     * Players should have unique ids.
     */
    @Test
    public void playerIdsUnique() {
        Player player1 = new Player("John Doe");
        Player player2 = new Player("Jane Doe");

        assertNotEquals(player1.getId(), player2.getId());
    }

    /**
     * Player should be equal based on id.
     */
    @Test
    public void playerEquals() {
        String id = "random_uuid";
        Player player1 = new Player(id, "John Doe", new GameStats[0]);
        Player player2 = new Player(id, "Jane Doe", new GameStats[0]);

        assertEquals(player1, player2);
    }

}
