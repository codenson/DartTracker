package com.cs321.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Handles IO Utilities.
 */
public class IOUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String getGamemodePath(String gamemodeName)
    {
        StringBuilder gamePath = new StringBuilder(System.getProperty("user.home"));
        gamePath.append("\\Saved Games\\DartDash\\Gamemodes");
        gamePath.append(gamemodeName);
        return gamePath.toString();
    }
    
    public static void init() {
        String userHomeDir = System.getProperty("user.home");
        try 
        {
            Files.createDirectories(Paths.get(userHomeDir + "\\Saved Games\\DartDash\\Gamemodes"));
        }
        catch (IOException e) {
            System.exit(0);
        }
    }
    public static GameConfigurationDTO mapConfiguration(String gamemodeName)
    {
        
            // GameConfigurationDTO gameConfiguration = objectMapper.readValue(getGamemodePath(gamemodeName),GameConfigurationDTO.class);
        
        return null;
    }
    
}

