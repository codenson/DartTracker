package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundsManagerTest {
    
    /**
     * New RoundsManager created properly.
     */
    @Test
    public void newRoundsManager() {
        RoundsManager roundsManager = new RoundsManager();
        
        assertNotNull(roundsManager);
        assertNotNull(roundsManager.getRounds());
    }

    /**
     * getTeamScores works properly.
     */
    @Test
    public void getTeamScores() {
        String playername1 = "John Doe";
        String playername2 = "Jane Doe";
        String playername3 = "Joe Doe";
        String playername4 = "Jill Doe";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);
        Player player3 = new Player(playername3);
        Player player4 = new Player(playername4);

        String teamname1 = "Team 1";
        String teamname2 = "Team 2";
        Player[] players1 = new Player[] { player1, player2 };
        Player[] players2 = new Player[] { player3, player4 };
        Team team1 = new Team(teamname1, players1);
        Team team2 = new Team(teamname2, players2);

        RoundsManager roundsManager = new RoundsManager();
        Round round1 = new Round(player1);
        round1.addScore(12);
        round1.addScore(13);
        round1.addScore(14);
        Round round2 = new Round(player3);
        round2.addScore(9);
        round2.addScore(4);
        round2.addScore(12);
        Round round3 = new Round(player2);
        round3.addScore(20);
        round3.addScore(3);
        round3.addScore(3);
        Round round4 = new Round(player4);
        round4.addScore(10);
        round4.addScore(4);
        round4.addScore(2);
        roundsManager.addRound(round1);
        roundsManager.addRound(round2);
        roundsManager.addRound(round3);
        roundsManager.addRound(round4);
        
        int[] team1Scores = roundsManager.getTeamScores(team1);
        int[] team2Scores = roundsManager.getTeamScores(team2);

        assertNotNull(team1Scores);
        assertEquals(2, team1Scores.length);
        assertEquals(39, team1Scores[0]);
        assertEquals(26, team1Scores[1]);

        assertNotNull(team2Scores);
        assertEquals(2, team2Scores.length);
        assertEquals(25, team2Scores[0]);
        assertEquals(16, team2Scores[1]);
    }

    /**
     * getTeamTotalScore works properly.
     */
    @Test
    public void getTeamTotalScore() {
        String playername1 = "John Doe";
        String playername2 = "Jane Doe";
        String playername3 = "Joe Doe";
        String playername4 = "Jill Doe";
        Player player1 = new Player(playername1);
        Player player2 = new Player(playername2);
        Player player3 = new Player(playername3);
        Player player4 = new Player(playername4);

        String teamname1 = "Team 1";
        String teamname2 = "Team 2";
        Player[] players1 = new Player[] { player1, player2 };
        Player[] players2 = new Player[] { player3, player4 };
        Team team1 = new Team(teamname1, players1);
        Team team2 = new Team(teamname2, players2);

        RoundsManager roundsManager = new RoundsManager();
        Round round1 = new Round(player1);
        round1.addScore(12);
        round1.addScore(13);
        round1.addScore(14);
        Round round2 = new Round(player3);
        round2.addScore(9);
        round2.addScore(4);
        round2.addScore(12);
        Round round3 = new Round(player2);
        round3.addScore(20);
        round3.addScore(3);
        round3.addScore(3);
        Round round4 = new Round(player4);
        round4.addScore(10);
        round4.addScore(4);
        round4.addScore(2);
        roundsManager.addRound(round1);
        roundsManager.addRound(round2);
        roundsManager.addRound(round3);
        roundsManager.addRound(round4);
        
        int team1TotalScore = roundsManager.getTeamTotalScore(team1);
        int team2TotalScore = roundsManager.getTeamTotalScore(team2);

        assertEquals(65, team1TotalScore);
        assertEquals(41, team2TotalScore);
    }

}
