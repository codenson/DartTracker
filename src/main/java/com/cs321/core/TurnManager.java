package com.cs321.core;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * This class manages turns.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class TurnManager {
    
    /** The turn order of the players. */
    private Player[] turnOrder;

    /** The current turn index. */
    private int currentTurnIndex;

    /**
     * Create a new turn manager.
     * Please use TurnManagerBuilder to create a new turn manager.
     * 
     * @param turnOrder
     */
    private TurnManager(Player[] turnOrder) {
        this.turnOrder = turnOrder;
        currentTurnIndex = 0;
    }

    /**
     * Create a new turn manager from a list of teams with default priority score.
     * By default, the priority score is adjusted so that the first team in the list
     * has the highest priority score and the last team in the list has the lowest
     * priority score. Each player in a team has increasing priority score.
     * 
     * @param teams The list of teams.
     */
    public static TurnManager fromTeams(Team[] teams) {
        TurnManagerBuilder turnManagerBuilder = new TurnManagerBuilder();

        int basePriority = 1;
        int teamPriorityBoost = 0;

        for (Team team : teams) {
            int teamSum = 0;

            for (Player player : team.getPlayers()) {
                int playerPriority = basePriority + teamPriorityBoost;
                turnManagerBuilder.withPlayer(player, team, playerPriority);

                teamSum += playerPriority;
                basePriority++;
            }

            teamPriorityBoost += teamSum;
        }

        return turnManagerBuilder.build();
    }

    /**
     * A builder class for TurnManager.
     * 
     * @author James Luna, Hasnain Raza, Marouane Guerouji
     */
    public static class TurnManagerBuilder {

        /** A private class to store player and their priority score. */
        private class PlayerPriority {

            /** The player. */
            private Player player;

            /** The priority score. */
            private int priority;

            /**
             * Create a new player priority.
             * 
             * @param player The player.
             * @param priority The priority score.
             */
            public PlayerPriority(Player player, int priority) {
                this.player = player;
                this.priority = priority;
            }
        }

        /** A private class to store team and their priority score. */
        private class TeamPriority {

            /** The team. */
            private Team team;

            /** The priority score. */
            private int priority;

            /**
             * Create a new team priority.
             * 
             * @param team The team.
             * @param priority The priority score.
             */
            public TeamPriority(Team team, int priority) {
                this.team = team;
                this.priority = priority;
            }
        }

        /** A priority queue of players without considering team. */
        private PriorityQueue<PlayerPriority> playerPriorityQueue;

        /** A hashtable mapping teams to their counted priority. */
        private Hashtable<Team, Integer> teamPriorityScore;

        /** A hashtable mapping players to their team. */
        private Hashtable<Player, Team> playerTeam;

        /** A priority queue of teams built from their counted priority score. */
        private PriorityQueue<TeamPriority> teamPriorityQueue;

        /** A hashtable mapping team to their prioritized players list. */
        private Hashtable<Team, ArrayList<Player>> prioritizedTeamPlayer;

        /**
         * Create a new turn manager builder.
         */
        public TurnManagerBuilder() {
            playerPriorityQueue = new PriorityQueue<PlayerPriority>((p1, p2) -> Integer.compare(p1.priority, p2.priority));
            teamPriorityScore = new Hashtable<Team, Integer>();
            playerTeam = new Hashtable<Player, Team>();
            teamPriorityQueue = new PriorityQueue<TeamPriority>((t1, t2) -> Integer.compare(t1.priority, t2.priority));
            prioritizedTeamPlayer = new Hashtable<Team, ArrayList<Player>>();
        }

        /**
         * Add a player specifying their team to the turn manager builder with a priority score.
         * Lower priority score means higher priority.
         * 
         * @param player The player to add.
         * @param priority The priority score of the player.
         * @return The turn manager builder.
         */
        public TurnManagerBuilder withPlayer(Player player, Team team, int priority) {
            // Add each player to the player priority queue.
            playerPriorityQueue.add(new PlayerPriority(player, priority));

            // Count the priority score of each team by adding its player's priority.
            if (teamPriorityScore.containsKey(team)) {
                teamPriorityScore.put(team, teamPriorityScore.get(team) + priority);
            } else {
                teamPriorityScore.put(team, priority);
            }

            // Map each player to its team.
            playerTeam.put(player, team);

            return this;
        }

        /**
         * Build the turn manager.
         * 
         * @return The turn manager.
         */
        public TurnManager build() {
            // Build the team priority queue from the counted priority and the prioritized team player hashtable.
            for (Team team : teamPriorityScore.keySet()) {
                teamPriorityQueue.add(new TeamPriority(team, teamPriorityScore.get(team)));
                prioritizedTeamPlayer.put(team, new ArrayList<Player>());
            }

            // Populate the prioritized team player hashtable.
            while (!playerPriorityQueue.isEmpty()) {
                PlayerPriority playerPriority = playerPriorityQueue.poll();
                Player player = playerPriority.player;
                Team team = playerTeam.get(player);
                prioritizedTeamPlayer.get(team).add(player);
            }

            // Build the turn order.
            int maxTeamSize = prioritizedTeamPlayer.values().stream().mapToInt(ArrayList::size).max().getAsInt();
            int teamCount = teamPriorityQueue.size();
            int offset = 0;
            Player[] turnOrder = new Player[maxTeamSize * teamCount];

            while (!teamPriorityQueue.isEmpty()) {
                TeamPriority teamPriority = teamPriorityQueue.poll();
                Team team = teamPriority.team;
                ArrayList<Player> teamPlayers = prioritizedTeamPlayer.get(team);
                int teamSize = teamPlayers.size();

                // Add the players of the team to the turn order.
                // Wrap around the team players if the team size is smaller than the maximum team size.
                for (int i = 0; i < maxTeamSize; i++) {
                    turnOrder[offset + i * teamCount] = teamPlayers.get(i % teamSize);
                }

                offset++;
            }

            // Return the turn manager.
            return new TurnManager(turnOrder);
        }

    }

    /**
     * Get the current turn player.
     * 
     * @return The current turn player.
     */
    public Player getCurrentPlayer() {
        return turnOrder[currentTurnIndex];
    }

    /**
     * Updates state to the next turn.
     */
    public void nextTurn() {
        currentTurnIndex = (currentTurnIndex + 1) % turnOrder.length;
    }

}
