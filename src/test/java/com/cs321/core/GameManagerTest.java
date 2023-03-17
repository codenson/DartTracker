package com.cs321.core;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cs321.core.GameConfiguration.GameConfigurationBuilder;
import com.cs321.core.TurnManager.TurnManagerBuilder;

public class GameManagerTest {
    
    /**
     * New GameManager created properly.
     */
    @Test
    public void newGameManager() {
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

        GameConfiguration gameConfiguration = new GameConfiguration();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);
        
        assertNotNull(gameManager);
        assertNotNull(gameManager.getGameConfiguration());
        assertNotNull(gameManager.getTeamsManager());
        assertNotNull(gameManager.getTurnManager());
        assertNotNull(gameManager.getRoundsManager());
    }

    /**
     * isGameFinished returns false when game is not finished.
     */
    @Test
    public void isGameFinishedReturnsFalse() {
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

        GameConfiguration gameConfiguration = new GameConfiguration();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);
        
        assertFalse(gameManager.isGameFinished());
    }

    /**
     * isGameFinished returns true when maximum rounds are set and are finished.
     */
    @Test
    public void isGameFinishedReturnsTrueWithMaxRounds() {
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

        GameConfiguration gameConfiguration = new GameConfigurationBuilder()
            .withMaximumRounds(4)
            .build();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
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

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);
        
        assertTrue(gameManager.isGameFinished());
    }

    /**
     * isGameFinished returns true when a team has reached the maximum score.
     */
    @Test
    public void isGameFinishedReturnsTrueWithMaxScore() {
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

        GameConfiguration gameConfiguration = new GameConfigurationBuilder()
            .withStartingScore(100)
            .build();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();
        Round round1 = new Round(player1);
        round1.addScore(100);
        roundsManager.addRound(round1);

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);
        
        assertTrue(gameManager.isGameFinished());
    }

    /**
     * beginRound starts a new round and properly progresses the turn.
     */
    @Test
    public void beginRoundProperlyProgressTurn() {
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

        GameConfiguration gameConfiguration = new GameConfigurationBuilder()
            .withStartingScore(100)
            .build();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);

        assertEquals(turnManager.getCurrentPlayer(), player4);
        gameManager.beginRound();
        assertNotNull(gameManager.getCurrentRound());
        assertEquals(turnManager.getCurrentPlayer(), player2);
    }

    /**
     * beginRound throws an exception when there is already a round in progress.
     */
    @Test(expected = IllegalStateException.class)
    public void beginRoundThrowsIfAlreadyRound() {
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

        GameConfiguration gameConfiguration = new GameConfiguration();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);

        gameManager.beginRound();
        gameManager.beginRound();
    }

    /**
     * beginRound throws an exception when the game is finished.
     */
    @Test(expected = IllegalStateException.class)
    public void beginRoundThrowsIfGameFinished() {
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

        GameConfiguration gameConfiguration = new GameConfigurationBuilder()
            .withStartingScore(100)
            .build();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();
        Round round1 = new Round(player1);
        round1.addScore(100);
        roundsManager.addRound(round1);

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);

        gameManager.beginRound();
    }

    /**
     * progressRound properly adds the score.
     */
    @Test
    public void progressRoundAddsScore() {
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

        GameConfiguration gameConfiguration = new GameConfiguration();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);

        gameManager.beginRound();
        gameManager.progressRound(10);
        assertEquals(gameManager.getCurrentRound().getScores()[0], 10);
    }

    /**
     * progressRound finishes the round after enough throws.
     */
    @Test
    public void progressRoundFinishesRound() {
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

        GameConfiguration gameConfiguration = new GameConfigurationBuilder()
            .withDartsPerRound(3)
            .build();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);

        gameManager.beginRound();
        gameManager.progressRound(1);
        gameManager.progressRound(2);
        gameManager.progressRound(3);
        assertTrue(gameManager.getCurrentRound() == null);
    }

    /**
     * progressRound throws an exception if no round is in progress.
     */
    @Test(expected = IllegalStateException.class)
    public void progressRoundThrowsIfNoRound() {
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

        GameConfiguration gameConfiguration = new GameConfiguration();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);

        gameManager.progressRound(1);
    }

    /**
     * progressRound throws an exception if the round is already finished.
     */
    @Test(expected = IllegalStateException.class)
    public void progressRoundThrowsIfRoundFinished() {
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

        GameConfiguration gameConfiguration = new GameConfigurationBuilder()
            .withDartsPerRound(3)
            .build();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);

        gameManager.beginRound();
        gameManager.progressRound(1);
        gameManager.progressRound(2);
        gameManager.progressRound(3);
        gameManager.progressRound(4);
    }

    /**
     * progressRound throws an exception if the game is already finished.
     */
    @Test(expected = IllegalStateException.class)
    public void progressRoundThrowsIfGameFinished() {
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

        GameConfiguration gameConfiguration = new GameConfigurationBuilder()
            .withStartingScore(100)
            .build();
        TeamsManager teamsManager = new TeamsManager(new Team[] { team1, team2 });
        TurnManager turnManager = new TurnManagerBuilder()
            .withPlayer(player1, team1, 2)
            .withPlayer(player2, team1, 4)
            .withPlayer(player3, team2, 6)
            .withPlayer(player4, team2, 8)
            .build();
        RoundsManager roundsManager = new RoundsManager();
        Round round1 = new Round(player1);
        round1.addScore(100);
        roundsManager.addRound(round1);

        GameManager gameManager = new GameManager(gameConfiguration, teamsManager,
            turnManager, roundsManager);

        gameManager.progressRound(1);
    }

}
