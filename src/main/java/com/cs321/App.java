package com.cs321;

import java.util.Scanner;

import com.cs321.gui.DartDashGUI;

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
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DartDashGUI().setVisible(true);
            }
        });
    }
}
