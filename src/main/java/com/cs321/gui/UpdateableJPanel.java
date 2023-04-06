package com.cs321.gui;

import javax.swing.JPanel;

public class UpdateableJPanel extends JPanel {
    
    /**
     * Override this method to update the components of the panel
     */
    public void updateComponents() {
        invalidate();
        repaint();
    }

}
