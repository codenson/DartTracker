package com.cs321.core;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class manages the rounds of the game.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class RoundsManager {

    /** The rounds of the game. */
    private ArrayList<Round> rounds;

    /**
     * Get the rounds of the game.
     * 
     * @return The rounds of the game.
     */
    public Round[] getRounds() {
        Round[] roundsCopy = new Round[rounds.size()];
        rounds.toArray(roundsCopy);
        return roundsCopy;
    }

    /**
     * Set the rounds of the game.
     * 
     * @param rounds The rounds of the game.
     */
    public void setRounds(Round[] rounds) {
        this.rounds = new ArrayList<Round>(Arrays.asList(rounds));
    }

    /**
     * Create a new rounds manager.
     */
    public RoundsManager() {
        rounds = new ArrayList<Round>();
    }

    /**
     * Add a new round to the game.
     * 
     * @param round The round to add.
     */
    public void addRound(Round round) {
        rounds.add(round);
    }

    /**
     * Get total number of rounds.
     * 
     * @return The total number of rounds.
     */
    public int getTotalRounds() {
        return rounds.size();
    }

    /**
     * Get the rounds of a team.
     * 
     * @param team The team to get the rounds of.
     * @return The rounds of the team.
     */
    public Round[] getRoundsOfTeam(Team team) {
        return rounds.stream().filter(round -> round.isPlayedBy(team)).toArray(Round[]::new);
    }

    /**
     * Get team scores.
     * 
     * @param team The team to get the scores of.
     * @return The scores of the team.
     */
    public int[] getTeamScores(Team team) {
        return Arrays.stream(getRoundsOfTeam(team)).mapToInt(round -> round.getTotalScore()).toArray();
    }

    /**
     * Get the total score of a team.
     * 
     * @param team The team to get the total score of.
     * @return The total score of the team.
     */
    public int getTeamTotalScore(Team team) {
        return Arrays.stream(getTeamScores(team)).sum();
    }

    /**
     * Gets the total rounds played by the player.
     * 
     * @param player The player to get the total rounds played by.
     * @return The total rounds played by the player.
     */
    public int getPlayerRoundsPlayed(Player player) {
        return (int) Arrays.stream(getRounds()).filter(round -> round.getPlayer() == player).count();
    }

}
