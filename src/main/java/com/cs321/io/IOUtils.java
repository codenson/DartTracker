package com.cs321.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import com.cs321.core.GameConfiguration;
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
        Files.createDirectories(Paths.get(getDartDashPath()));
        Files.createDirectories(Paths.get(getGameConfigurationsPath()));

        if (loadGameConfiguration("Default") == null) {
            saveGameConfiguration(new GameConfiguration());
        }
    }

    /**
     * Saves the game configuration to a file.
     * 
     * @param gameConfiguration The GameConfiguration to save.
     * @throws IOException If an error occurs while saving the gamemode.
     */
    public static void saveGameConfiguration(GameConfiguration gameConfiguration) throws IOException {
        String gamemodePath = getGameConfigurationPath(gameConfiguration.getId(), gameConfiguration.getName());
        GameConfigurationDTO gameConfigurationDTO = getGameConfigurationDTOFromGameConfiguration(gameConfiguration);
        objectMapper.writeValue(Paths.get(gamemodePath).toFile(), gameConfigurationDTO);
    }

    /**
     * Load game configuration by name.
     * 
     * @return The GameConfiguration.
     * @throws IOException If an error occurs while loading the game configuration.
     */
    public static GameConfiguration loadGameConfiguration(String name) throws IOException {
        GameConfiguration gameConfiguration = null;

        Optional<Path> result = Files.list(Paths.get(getGameConfigurationsPath())).filter(path -> 
            path.getFileName().toString().startsWith(name)).findFirst();

        if (result.isPresent()) {
            GameConfigurationDTO gameConfigurationDTO = objectMapper.readValue(result.get().toFile(), GameConfigurationDTO.class);
            gameConfiguration = getGameConfigurationFromGameConfigurationDTO(gameConfigurationDTO);
        }

        return gameConfiguration;
    }

    /**
     * Loads all the game configurations from the GameConfigurations directory.
     * 
     * @return An array of GameConfigurations.
     * @throws IOException If an error occurs while loading the game configurations.
     */
    public static GameConfiguration[] loadAllGameConfigurations() throws IOException {
        ArrayList<GameConfiguration> gameConfigurations = new ArrayList<>();

        Files.list(Paths.get(getGameConfigurationsPath())).forEach(path -> {
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
     * Gets the path to the DartDash directory.
     * 
     * @return The path to the DartDash directory.
     */
    private static String getDartDashPath() {
        StringBuilder dartDashPath = new StringBuilder(System.getProperty("user.home"));
        dartDashPath.append("\\Saved Games\\DartDash");
        return dartDashPath.toString();
    }

    /**
     * Gets the path to the GameConfigurations directory.
     * 
     * @return The path to the GameConfigurations directory.
     */
    private static String getGameConfigurationsPath() {
        StringBuilder gamemodesPath = new StringBuilder(getDartDashPath());
        gamemodesPath.append("\\GameConfigurations");
        return gamemodesPath.toString();
    }

    /**
     * Gets the path to the game configuration file.
     * 
     * @param id The ID of the game configuration.
     * @param name The name of the game configuration.
     * @return The path to the game configuration file.
     */
    private static String getGameConfigurationPath(String id, String name) {
        StringBuilder gamemodePath = new StringBuilder(getGameConfigurationsPath());
        gamemodePath.append("\\");
        gamemodePath.append(name);
        gamemodePath.append("_");
        gamemodePath.append(id);
        gamemodePath.append(".json");
        return gamemodePath.toString();
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

}

