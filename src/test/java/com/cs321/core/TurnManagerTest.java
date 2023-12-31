package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cs321.core.TurnManager.TurnManagerBuilder;

public class TurnManagerTest {
    
    /**
     * New TurnManager built properly with same sized teams.
     */
    @Test
    public void buildTurnManagerSameSizeTeams() {
        String playername1 = "p1";
        String playername2 = "p2";
        String playername3 = "p3";
        String playername4 = "p4";
        String playername5 = "p5";
        String playername6 = "p6";
        String playername7 = "p7";
        String playername8 = "p8";
        String playername9 = "p9";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);
        Player player3 = new Player(playername3);
        Player player4 = new Player(playername4);
        Player player5 = new Player(playername5);
        Player player6 = new Player(playername6);
        Player player7 = new Player(playername7);
        Player player8 = new Player(playername8);
        Player player9 = new Player(playername9);

        String teamname1 = "tA";
        String teamname2 = "tB";
        String teamname3 = "tC";
        Player[] players1 = new Player[] { player1, player2, player3 };
        Player[] players2 = new Player[] { player4, player5, player6 };
        Player[] players3 = new Player[] { player7, player8, player9 };
        Team team1 = new Team(teamname1, players1);
        Team team2 = new Team(teamname2, players2);
        Team team3 = new Team(teamname3, players3);

        int player1Priority = 11;
        int player2Priority = 15;
        int player3Priority = 4;
        int player4Priority = 18;
        int player5Priority = 6;
        int player6Priority = 5;
        int player7Priority = 17;
        int player8Priority = 13;
        int player9Priority = 1;

        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, player1Priority)
            .withPlayer(player2, team1, player2Priority)
            .withPlayer(player3, team1, player3Priority)
            .withPlayer(player4, team2, player4Priority)
            .withPlayer(player5, team2, player5Priority)
            .withPlayer(player6, team2, player6Priority)
            .withPlayer(player7, team3, player7Priority)
            .withPlayer(player8, team3, player8Priority)
            .withPlayer(player9, team3, player9Priority)
            .build();

        assertNotNull(turnManager);
        assertEquals(turnManager.getCurrentPlayer(), player6);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player3);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player9);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player5);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player1);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player8);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player4);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player2);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player7);

        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player6);
    }

    /**
     * New TurnManager built properly with different sized teams.
     */
    @Test
    public void buildTurnManagerDiffSizeTeams() {
        String playername1 = "p1";
        String playername2 = "p2";
        // String playername3 = "p3";
        String playername4 = "p4";
        String playername5 = "p5";
        String playername6 = "p6";
        String playername7 = "p7";
        String playername8 = "p8";
        String playername9 = "p9";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);
        // Player player3 = new Player(playername3);
        Player player4 = new Player(playername4);
        Player player5 = new Player(playername5);
        Player player6 = new Player(playername6);
        Player player7 = new Player(playername7);
        Player player8 = new Player(playername8);
        Player player9 = new Player(playername9);

        String teamname1 = "tA";
        String teamname2 = "tB";
        String teamname3 = "tC";
        // Player[] players1 = new Player[] { player1, player2, player3 };
        Player[] players1 = new Player[] { player1, player2 };
        Player[] players2 = new Player[] { player4, player5, player6 };
        Player[] players3 = new Player[] { player7, player8, player9 };
        Team team1 = new Team(teamname1, players1);
        Team team2 = new Team(teamname2, players2);
        Team team3 = new Team(teamname3, players3);

        int player1Priority = 11;
        int player2Priority = 15;
        // int player3Priority = 4;
        int player4Priority = 18;
        int player5Priority = 6;
        int player6Priority = 5;
        int player7Priority = 17;
        int player8Priority = 13;
        int player9Priority = 1;

        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, player1Priority)
            .withPlayer(player2, team1, player2Priority)
            // .withPlayer(player3, team1, player3Priority)
            .withPlayer(player4, team2, player4Priority)
            .withPlayer(player5, team2, player5Priority)
            .withPlayer(player6, team2, player6Priority)
            .withPlayer(player7, team3, player7Priority)
            .withPlayer(player8, team3, player8Priority)
            .withPlayer(player9, team3, player9Priority)
            .build();

        assertNotNull(turnManager);
        assertEquals(turnManager.getCurrentPlayer(), player1);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player6);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player9);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player2);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player5);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player8);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player1);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player4);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player7);

        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player1);
    }

    /**
     * Default TurnManager built properly with free for all teams.
     */
    @Test
    public void buildDefaultTurnManagerFreeForAll() {
        String playername1 = "p1";
        String playername2 = "p2";
        String playername3 = "p3";
        String playername4 = "p4";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);
        Player player3 = new Player(playername3);
        Player player4 = new Player(playername4);

        String teamname1 = "tA";
        String teamname2 = "tB";
        String teamname3 = "tC";
        String teamname4 = "tD";
        Player[] players1 = new Player[] { player1 };
        Player[] players2 = new Player[] { player2 };
        Player[] players3 = new Player[] { player3 };
        Player[] players4 = new Player[] { player4 };
        Team team1 = new Team(teamname1, players1);
        Team team2 = new Team(teamname2, players2);
        Team team3 = new Team(teamname3, players3);
        Team team4 = new Team(teamname4, players4);

        Team[] teams = new Team[] { team1, team2, team3, team4 };
        TurnManager turnManager = TurnManager.fromTeams(teams);
        
        assertNotNull(turnManager);
        assertEquals(turnManager.getCurrentPlayer(), player1);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player2);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player3);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player4);

        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player1);
    }

    /**
     * Default TurnManager built properly with same sized teams.
     */
    @Test
    public void buildDefaultTurnManagerSameSizeTeams() {
        String playername1 = "p1";
        String playername2 = "p2";
        String playername3 = "p3";
        String playername4 = "p4";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);
        Player player3 = new Player(playername3);
        Player player4 = new Player(playername4);

        String teamname1 = "tA";
        String teamname2 = "tB";
        Player[] players1 = new Player[] { player1, player2 };
        Player[] players2 = new Player[] { player3, player4 };
        Team team1 = new Team(teamname1, players1);
        Team team2 = new Team(teamname2, players2);

        Team[] teams = new Team[] { team1, team2 };
        TurnManager turnManager = TurnManager.fromTeams(teams);

        assertNotNull(turnManager);
        assertEquals(turnManager.getCurrentPlayer(), player1);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player3);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player2);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player4);

        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player1);
    }

    /**
     * Default TurnManager built properly with different sized teams.
     */
    @Test
    public void buildDefaultTurnManagerDiffSizeTeams() {
        String playername1 = "p1";
        String playername2 = "p2";
        String playername3 = "p3";
        String playername4 = "p4";
        String playername5 = "p5";
        String playername6 = "p6";
        String playername7 = "p7";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);
        Player player3 = new Player(playername3);
        Player player4 = new Player(playername4);
        Player player5 = new Player(playername5);
        Player player6 = new Player(playername6);
        Player player7 = new Player(playername7);

        String teamname1 = "tA";
        String teamname2 = "tB";
        String teamname3 = "tC";
        Player[] players1 = new Player[] { player1, player2, player3, player4 };
        Player[] players2 = new Player[] { player5, player6 };
        Player[] players3 = new Player[] { player7 };
        Team team1 = new Team(teamname1, players1);
        Team team2 = new Team(teamname2, players2);
        Team team3 = new Team(teamname3, players3);

        Team[] teams = new Team[] { team1, team2, team3 };
        TurnManager turnManager = TurnManager.fromTeams(teams);

        assertNotNull(turnManager);
        assertEquals(turnManager.getCurrentPlayer(), player1);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player5);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player7);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player2);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player6);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player7);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player3);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player5);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player7);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player4);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player6);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player7);

        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player1);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player5);
        turnManager.nextTurn();
        assertEquals(turnManager.getCurrentPlayer(), player7);
    }

}
