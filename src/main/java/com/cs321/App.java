package com.cs321;

import com.cs321.gui.DartDashGUI;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

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
            // javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
        // } catch (ClassNotFoundException ex) {
        //     java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // } catch (InstantiationException ex) {
        //     java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        // } catch (IllegalAccessException ex) {
        //     java.util.logging.Logger.getLogger(DartDashGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
