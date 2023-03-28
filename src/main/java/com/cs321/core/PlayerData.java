/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cs321.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.*;
///////////////////////////////STILL NEEDS TO BE TESTED ///////////////////////////////////////////////

/**
 * class to read and write player's info into and from a file. STILL NEEDS TO BE
 * TESTED
 *
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 */
public class PlayerData<A> {

    /**
     * ArrayList of gameStat from the file.
     */
    private ArrayList<A> gameStatList = new ArrayList<A>();

    /**
     * Player's id.
     */
    private String id = "";

    /**
     * Player's name.
     */
    private String name = "";

    /**
     * method to return player's Id.
     *
     * @return ID.
     */
    protected String getPlayerId() {
        return id;
    }

    /**
     * Method to return player's name.
     *
     * @return player's name.
     */
    protected String getPlayerName() {
        return name;
    }

    /**
     *a list of player's gamestat from file. 
     * @return a list of game stats as a list. 
     */
    protected ArrayList<A> gameStat() {
        return gameStatList;
    }

    /**
     *method to parse a file and get player's Id and Name and his gamestats. 
     * @param filePath filename path. 
     */
    public void getPlayerData(String filePath) {

        try {
            //FileWriter file = new FileWriter(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            int count = 0;

            while (line != null) {
                //System.out.println(lines);
                // read next line
                if (count == 0) {
                    id = line;

                }
                if (count == 1) {
                    name = line;
                }

                if (count > 1) {
                    gameStatList.add((A) line);
                }
                line = reader.readLine();
                count++;
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");

        }

    }

    /**
     *Method to write player's stats into a file. 
     * @param filePath file name to write data into. 
     * @param id player's Id to be written into the file. 
     * @param name player's name to be written into the file. 
     * @param gameStat player's gameStats to be written into the file. 
     */
    public void writePlayerData(String filePath, String id, String name, ArrayList<A> gameStat) {
        /// this method might need to check if the file exists and id the player's id and name match the ones in the method's arguments. 
        try {
            FileWriter file = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            bufferedWriter.write(id);
            bufferedWriter.write(name);
            for (A s : gameStat) {
                bufferedWriter.write((String) s);

            }
            file.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }

    }

}
