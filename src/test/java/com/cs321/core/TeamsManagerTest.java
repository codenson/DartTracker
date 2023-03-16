package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeamsManagerTest {
    
    /**
     * New TeamsManager created properly.
     */
    @Test
    public void newTeamsManager() {
        Team[] teams = new Team[0];

        TeamsManager teamsManager = new TeamsManager(teams);

        assertNotNull(teamsManager);
        assertNotNull(teamsManager.getTeams());
    }

}
