package com.cs321.io;

import java.util.ArrayList;

/**
 * A data transfer object for the Player class.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class PlayerDTO {

    /** The ID of this player. */
    public String id;
    /** The name of this player. */
    public String name;
    /** The gamestats of the player from previous games. */
    public GameStatsDTO[] gameStats;
}
