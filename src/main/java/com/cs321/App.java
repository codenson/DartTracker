package com.cs321;

import java.util.Scanner;

/**
 * @author James Luna, Hasnain Raza, Marouane Guerouji
 * @version 0.1
 * Main Menu Handler for Dart Tracker. Redirects to other menus.
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int option=-1;
        do
        {
            System.out.println("Hello Welcome To The Dart Tracker App!!\n\nPlease Type the Corresponding Number For The Menu Options\n");
            System.out.println("(1) Play A Game\n(2) View Player Statistics\n(3) Quit");
            System.out.print("-->  ");//Makes it look more like a CLI.
            if(!scanner.hasNextInt())//checks for misinputs that are not ints.
            {
                //The underscores serve as a buffer between the menu and the error message.
                System.out.println("\nPlease Enter A Number\n_______________________________________\n");
                scanner.next();
                continue;
            }
            option=scanner.nextInt();
            if(option<1||option>3)//Check for numbers that are not menu options.
            {
                System.out.println("\nPlease Enter A Valid Number\n_______________________________________\n");
                continue;
            }
            else if(option==1)
            {
                //TODO: Insert code to move to Game Menus
                System.out.print("Play Game Is Not Implemented Yet\n_______________________________________\n");
            }
            else if(option==2)
            {
                //TODO: Insert code to move to Statistic Menus
                System.out.print("Player Statistics Is Not Implemented Yet\n_______________________________________\n");
            }
            else break;//end if option was 3

        }
        while(option!=3);
    }
}
