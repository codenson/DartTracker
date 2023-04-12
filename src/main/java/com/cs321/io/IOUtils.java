package com.cs321.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import com.cs321.core.GameConfiguration;
import com.cs321.core.GameStats;
import com.cs321.core.Player;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles IO Utilities.
 * 
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class IOUtils {

    // ObjectMapper for JSON serialization and deserialization
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Initializes the DartDash directory and the GameConfigurations directory.
     * Also saves the default game configuration.
     */
    public static void init() throws IOException {
        Files.createDirectories(getDartDashPath());
        Files.createDirectories(getGameConfigurationsPath());
        Files.createDirectories(getPlayersPath());

        if (loadGameConfiguration("Default") == null) {
            saveGameConfiguration(new GameConfiguration());
        }
    }

    /**
     * Saves the GameConfiguration to a file.
     * 
     * @param gameConfiguration The GameConfiguration to save.
     * @param file The file to save the GameConfiguration to.
     * @throws IOException If an error occurs while saving the GameConfiguration.
     */
    public static void saveGameConfiguration(GameConfiguration gameConfiguration, File file) throws IOException {
        GameConfigurationDTO gameConfigurationDTO = getGameConfigurationDTOFromGameConfiguration(gameConfiguration);
        objectMapper.writeValue(file, gameConfigurationDTO);
    }
    /**
     * Saves the Player to a file.
     * 
     * @param player The Player to save.
     * @param file The file to save the Player to.
     * @throws IOException If an error occurs while saving the Player.
     */
    public static void savePlayer(Player player, File file) throws IOException {
        PlayerDTO playerDTO = getPlayerDTOFromPlayer(player);
        objectMapper.writeValue(file, playerDTO);
    }

    /**
     * Saves the GameConfiguration to a path.
     * 
     * @param gameConfiguration The GameConfiguration to save.
     * @param path The path to save the GameConfiguration to.
     * @throws IOException If an error occurs while saving the GameConfiguration.
     */
    public static void saveGameConfiguration(GameConfiguration gameConfiguration, Path path) throws IOException {
        saveGameConfiguration(gameConfiguration, path.toFile());
    }
    
    /**
     * Saves the Player to a path.
     * 
     * @param player The Player to save.
     * @param path The path to save the Player to.
     * @throws IOException If an error occurs while saving the Player.
     */
    public static void savePlayer(Player player, Path path) throws IOException {
        savePlayer(player, path.toFile());
    }

    /**
     * Saves the GameConfiguration to default location.
     * 
     * @param gameConfiguration The GameConfiguration to save.
     * @throws IOException If an error occurs while saving the GameConfiguration.
     */
    public static void saveGameConfiguration(GameConfiguration gameConfiguration) throws IOException {
        Path gameConfigurationPath = getGameConfigurationPath(gameConfiguration);
        saveGameConfiguration(gameConfiguration, gameConfigurationPath);
    }

    /**
     * Saves the Player to default location.
     * 
     * @param player The Player to save.
     * @throws IOException If an error occurs while saving the Player.
     */
    public static void savePlayer(Player player) throws IOException {
        Path playerPath = getPlayerPath(player);
        savePlayer(player, playerPath);
    }

    /**
     * Load GameConfiguration by name.
     * 
     * @param name The name of the GameConfiguration to load.
     * @return The GameConfiguration.
     * @throws IOException If an error occurs while loading the GameConfiguration.
     */
    public static GameConfiguration loadGameConfiguration(String name) throws IOException {
        GameConfiguration gameConfiguration = null;

        Optional<Path> result = Files.list(getGameConfigurationsPath()).filter(path -> 
            path.getFileName().toString().startsWith(name)).findFirst();

        if (result.isPresent()) {
            GameConfigurationDTO gameConfigurationDTO = objectMapper.readValue(result.get().toFile(), GameConfigurationDTO.class);
            gameConfiguration = getGameConfigurationFromGameConfigurationDTO(gameConfigurationDTO);
        }

        return gameConfiguration;
    }

    /**
     * Load Player by name.
     * 
     * @param name The name of the Player to load.
     * @return The Player.
     * @throws IOException If an error occurs while loading the Player.
     */
    public static Player loadPlayer(String name) throws IOException {
        Player player = null;

        Optional<Path> result = Files.list(getPlayersPath()).filter(path -> 
            path.getFileName().toString().startsWith(name)).findFirst();

        if (result.isPresent()) {
            PlayerDTO playerDTO = objectMapper.readValue(result.get().toFile(), PlayerDTO.class);
            player = getPlayerFromPlayerDTO(playerDTO);
        }

        return player;
    }

    /**
     * Load GameConfiguration by file.
     * 
     * @param file The file to load the GameConfiguration from.
     * @return The GameConfiguration.
     * @throws IOException If an error occurs while loading the GameConfiguration.
     */
    public static GameConfiguration loadGameConfiguration(File file) throws IOException {
        GameConfigurationDTO gameConfigurationDTO = objectMapper.readValue(file, GameConfigurationDTO.class);
        return getGameConfigurationFromGameConfigurationDTO(gameConfigurationDTO);
    }

    /**
     * Load player by file.
     * 
     * @param file The file to load the Player from.
     * @return The Player.
     * @throws IOException If an error occurs while loading the Player.
     */
    public static Player loadPlayer(File file) throws IOException {
        PlayerDTO playerDTO = objectMapper.readValue(file, PlayerDTO.class);
        return getPlayerFromPlayerDTO(playerDTO);
    }

    /**
     * Load game configuration by path.
     * 
     * @param path The path to load the GameConfiguration from.
     * @return The GameConfiguration.
     * @throws IOException If an error occurs while loading the game configuration.
     */
    public static GameConfiguration loadGameConfiguration(Path path) throws IOException {
        return loadGameConfiguration(path.toFile());
    }

    /**
     * Load player by path.
     * 
     * @param path The path to load the Player from.
     * @return The Player.
     * @throws IOException If an error occurs while loading the Player.
     */
    public static Player loadPlayer(Path path) throws IOException {
        return loadPlayer(path.toFile());
    }

    /**
     * Loads all the GameConfigurations from the GameConfigurations directory.
     * 
     * @return An array of GameConfigurations.
     * @throws IOException If an error occurs while loading the GameConfigurations.
     */
    public static GameConfiguration[] loadAllGameConfigurations() throws IOException {
        ArrayList<GameConfiguration> gameConfigurations = new ArrayList<>();

        Files.list(getGameConfigurationsPath()).forEach(path -> {
            try {
                GameConfigurationDTO gameConfigurationDTO = objectMapper.readValue(path.toFile(), GameConfigurationDTO.class);
                gameConfigurations.add(getGameConfigurationFromGameConfigurationDTO(gameConfigurationDTO));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return gameConfigurations.toArray(new GameConfiguration[gameConfigurations.size()]);
    }

    /**
     * Loads all the Players from the Players directory.
     * 
     * @return An array of Player.
     * @throws IOException If an error occurs while loading the Players.
     */
    public static Player[] loadAllPlayers() throws IOException {
        ArrayList<Player> players = new ArrayList<>();

        Files.list(getPlayersPath()).forEach(path -> {
            try {
                PlayerDTO playerDTO = objectMapper.readValue(path.toFile(), PlayerDTO.class);
                players.add(getPlayerFromPlayerDTO(playerDTO));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return players.toArray(new Player[players.size()]);
    }

    /**
     * Deletes the GameConfigurations file.
     * 
     * @param gameConfiguration The GameConfiguration to delete.
     * @throws IOException If an error occurs while deleting the GameConfigurations.
     */
    public static void deleteGameConfiguration(GameConfiguration gameConfiguration) throws IOException {
        Path gameConfigurationPath = getGameConfigurationPath(gameConfiguration);
        Files.deleteIfExists(gameConfigurationPath);
    }

    /**
     * Deletes the Player file.
     * 
     * @param player The Player to delete.
     * @throws IOException If an error occurs while deleting the Player.
     */
    public static void deletePlayer(Player player) throws IOException {
        Path playerPath = getPlayerPath(player);
        Files.deleteIfExists(playerPath);
    }

    /**
     * Gets the GameConfigurations save filename.
     * 
     * @param gameConfiguration The GameConfiguration to get the save filename for.
     * @return The GameConfiguration save filename.
     */
    public static String getGameConfigurationSaveFilename(GameConfiguration gameConfiguration) {
        return gameConfiguration.getName() + "_" + gameConfiguration.getId() + ".json";
    }


    /**
     * Gets the Player save filename.
     * 
     * @param player The Player to get the save filename for.
     * @return The Player save filename.
     */
    public static String getPlayerSaveFilename(Player player) {
        return player.getName() + "_" + player.getId() + ".json";
    }

    /**
     * Gets the path to the DartDash directory.
     * 
     * @return The path to the DartDash directory.
     */
    private static Path getDartDashPath() {
        StringBuilder dartDashPath = new StringBuilder(System.getProperty("user.home"));
        dartDashPath.append("\\Saved Games\\DartDash");
        return Paths.get(dartDashPath.toString());
    }

    /**
     * Gets the path to the GameConfigurations directory.
     * 
     * @return The path to the GameConfigurations directory.
     */
    private static Path getGameConfigurationsPath() {
        StringBuilder gameConfigurationsPath = new StringBuilder(getDartDashPath().toString());
        gameConfigurationsPath.append("\\GameConfigurations");
        return Paths.get(gameConfigurationsPath.toString());
    }

    /**
     * Gets the path to the Players directory.
     * 
     * @return The path to the Players directory.
     */
    private static Path getPlayersPath() {
        StringBuilder gameConfigurationsPath = new StringBuilder(getDartDashPath().toString());
        gameConfigurationsPath.append("\\Players");
        return Paths.get(gameConfigurationsPath.toString());
    }

    /**
     * Gets the path to the GameConfigurations file.
     * 
     * @param gameConfiguration The GameConfiguration to get the path for.
     * @return The path to the GameConfigurations file.
     */
    private static Path getGameConfigurationPath(GameConfiguration gameConfiguration) {
        StringBuilder gameConfigurationPath = new StringBuilder(getGameConfigurationsPath().toString());
        gameConfigurationPath.append("\\");
        gameConfigurationPath.append(getGameConfigurationSaveFilename(gameConfiguration));
        return Paths.get(gameConfigurationPath.toString());
    }

    /**
     * Gets the path to the Player file.
     * 
     * @param player The Player to get the path for.
     * @return The path to the Player file.
     */
    private static Path getPlayerPath(Player player) {
        StringBuilder playerPath = new StringBuilder(getPlayersPath().toString());
        playerPath.append("\\");
        playerPath.append(getPlayerSaveFilename(player));
        return Paths.get(playerPath.toString());
    }

    /**
     * Converts a GameConfiguration to a GameConfigurationDTO.
     * 
     * @param gameConfiguration The GameConfiguration to convert.
     * @return The GameConfigurationDTO.
     */
    private static GameConfigurationDTO getGameConfigurationDTOFromGameConfiguration(GameConfiguration gameConfiguration) {
        GameConfigurationDTO gameConfigurationDTO = new GameConfigurationDTO();
        gameConfigurationDTO.id = gameConfiguration.getId();
        gameConfigurationDTO.name = gameConfiguration.getName();
        gameConfigurationDTO.dartsPerRound = gameConfiguration.getDartsPerRound();
        gameConfigurationDTO.maximumRounds = gameConfiguration.getMaximumRounds();
        gameConfigurationDTO.startingScore = gameConfiguration.getStartingScore();
        gameConfigurationDTO.offboardPenalty = gameConfiguration.getOffboardPenalty();
        gameConfigurationDTO.scoreList = gameConfiguration.getScoreList();
        gameConfigurationDTO.multipliers = gameConfiguration.getMultipliers();
        gameConfigurationDTO.exactZeroWin = gameConfiguration.isExactZeroWin();
        gameConfigurationDTO.subtractPoints = gameConfiguration.isSubtractPoints();
        return gameConfigurationDTO;
    }

    /**
     * Converts a GameConfigurationDTO to a GameConfiguration.
     * 
     * @param gameConfigurationDTO The GameConfigurationDTO to convert.
     * @return The GameConfiguration.
     */
    private static GameConfiguration getGameConfigurationFromGameConfigurationDTO(GameConfigurationDTO gameConfigurationDTO) {
        GameConfiguration gameConfiguration = new GameConfiguration();
        gameConfiguration.setId(gameConfigurationDTO.id);
        gameConfiguration.setName(gameConfigurationDTO.name);
        gameConfiguration.setDartsPerRound(gameConfigurationDTO.dartsPerRound);
        gameConfiguration.setMaximumRounds(gameConfigurationDTO.maximumRounds);
        gameConfiguration.setStartingScore(gameConfigurationDTO.startingScore);
        gameConfiguration.setOffboardPenalty(gameConfigurationDTO.offboardPenalty);
        gameConfiguration.setScoreList(gameConfigurationDTO.scoreList);
        gameConfiguration.setMultipliers(gameConfigurationDTO.multipliers);
        gameConfiguration.setExactZeroWin(gameConfigurationDTO.exactZeroWin);
        gameConfiguration.setSubtractPoints(gameConfigurationDTO.subtractPoints);
        return gameConfiguration;
    }

    /**
     * Converts a Player to a PlayerDTO.
     * 
     * @param player The Player to convert.
     * @return The PlayerDTO.
     */
    private static PlayerDTO getPlayerDTOFromPlayer(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.id = player.getId();
        playerDTO.name = player.getName();

        GameStats[] gameStats = player.getGameStats();
        GameStatsDTO[] gameStatsDTO = new GameStatsDTO[gameStats.length];
        for (int index = 0; index < gameStats.length; index++) {
            gameStatsDTO[index] = getGameStatsDTOFromGameStats(gameStats[index]);
        }
        playerDTO.gameStats = gameStatsDTO;

        return playerDTO;
    }

    /**
     * Converts a PlayerDTO to a Player.
     * 
     * @param playerDTO The PlayerDTO to convert.
     * @return The Player.
     */
    private static Player getPlayerFromPlayerDTO(PlayerDTO playerDTO) {
        GameStatsDTO[] gameStatsDTO = playerDTO.gameStats;
        GameStats[] gameStats = new GameStats[gameStatsDTO.length];
        for (int index = 0; index < gameStatsDTO.length; index++) {
            gameStats[index] = getGameStatsFromGameStatsDTO(gameStatsDTO[index]);
        }

        return new Player(playerDTO.id, playerDTO.name, gameStats);
    }

    /**
     * Converts a GameStats to a GameStatsDTO.
     * 
     * @param gameStats The GameStats to convert.
     * @return The GameStatsDTO.
     */
    private static GameStatsDTO getGameStatsDTOFromGameStats(GameStats gameStats) {
        GameStatsDTO gameStatsDTO = new GameStatsDTO();
        gameStatsDTO.roundsPlayed = gameStats.getRoundsPlayed();
        gameStatsDTO.teamScores = gameStats.getTeamScores();
        gameStatsDTO.gamemodeId = gameStats.getGamemodeId();
        gameStatsDTO.playerWon = gameStats.isPlayerWon();

        return gameStatsDTO;
    }

    /**
     * Converts a GameStatsDTO to a GameStats.
     * 
     * @param gameStatsDTO The GameStatsDTO to convert.
     * @return The GameStats.
     */
    private static GameStats getGameStatsFromGameStatsDTO(GameStatsDTO gameStatsDTO) {
        return new GameStats(gameStatsDTO.roundsPlayed, gameStatsDTO.teamScores, gameStatsDTO.gamemodeId, gameStatsDTO.playerWon);
    }
    
}

