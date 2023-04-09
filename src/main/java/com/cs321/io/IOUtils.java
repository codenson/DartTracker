package com.cs321.io;

import java.io.File;
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
        Files.createDirectories(getDartDashPath());
        Files.createDirectories(getGameConfigurationsPath());

        if (loadGameConfiguration("Default") == null) {
            saveGameConfiguration(new GameConfiguration());
        }
    }

    /**
     * Saves the game configuration to a file.
     * 
     * @param gameConfiguration
     * @param file
     * @throws IOException
     */
    public static void saveGameConfiguration(GameConfiguration gameConfiguration, File file) throws IOException {
        GameConfigurationDTO gameConfigurationDTO = getGameConfigurationDTOFromGameConfiguration(gameConfiguration);
        objectMapper.writeValue(file, gameConfigurationDTO);
    }

    /**
     * Saves the game configuration to a path.
     * 
     * @param gameConfiguration
     * @param path
     * @throws IOException
     */
    public static void saveGameConfiguration(GameConfiguration gameConfiguration, Path path) throws IOException {
        saveGameConfiguration(gameConfiguration, path.toFile());
    }

    /**
     * Saves the game configuration to default location.
     * 
     * @param gameConfiguration The GameConfiguration to save.
     * @throws IOException If an error occurs while saving the gamemode.
     */
    public static void saveGameConfiguration(GameConfiguration gameConfiguration) throws IOException {
        Path gameConfigurationPath = getGameConfigurationPath(gameConfiguration);
        saveGameConfiguration(gameConfiguration, gameConfigurationPath);
    }

    /**
     * Load game configuration by name.
     * 
     * @return The GameConfiguration.
     * @throws IOException If an error occurs while loading the game configuration.
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
     * Load game configuration by file.
     * 
     * @return The GameConfiguration.
     * @throws IOException If an error occurs while loading the game configuration.
     */
    public static GameConfiguration loadGameConfiguration(File file) throws IOException {
        GameConfigurationDTO gameConfigurationDTO = objectMapper.readValue(file, GameConfigurationDTO.class);
        return getGameConfigurationFromGameConfigurationDTO(gameConfigurationDTO);
    }

    /**
     * Load game configuration by path.
     * 
     * @return The GameConfiguration.
     * @throws IOException If an error occurs while loading the game configuration.
     */
    public static GameConfiguration loadGameConfiguration(Path path) throws IOException {
        return loadGameConfiguration(path.toFile());
    }

    /**
     * Loads all the game configurations from the GameConfigurations directory.
     * 
     * @return An array of GameConfigurations.
     * @throws IOException If an error occurs while loading the game configurations.
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
     * Deletes the game configuration file.
     * 
     * @param gameConfiguration The GameConfiguration to delete.
     * @throws IOException If an error occurs while deleting the game configuration.
     */
    public static void deleteGameConfiguration(GameConfiguration gameConfiguration) throws IOException {
        Path gameConfigurationPath = getGameConfigurationPath(gameConfiguration);
        Files.deleteIfExists(gameConfigurationPath);
    }

    /**
     * Gets the game configuration save filename.
     * 
     * @param gameConfiguration The GameConfiguration to get the save filename for.
     * @return The game configuration save filename.
     */
    public static String getGameConfigurationSaveFilename(GameConfiguration gameConfiguration) {
        return gameConfiguration.getName() + "_" + gameConfiguration.getId() + ".json";
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
     * Gets the path to the game configuration file.
     * 
     * @param gameConfiguration The GameConfiguration to get the path for.
     * @return The path to the game configuration file.
     */
    private static Path getGameConfigurationPath(GameConfiguration gameConfiguration) {
        StringBuilder gameConfigurationPath = new StringBuilder(getGameConfigurationsPath().toString());
        gameConfigurationPath.append("\\");
        gameConfigurationPath.append(getGameConfigurationSaveFilename(gameConfiguration));
        return Paths.get(gameConfigurationPath.toString());
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

