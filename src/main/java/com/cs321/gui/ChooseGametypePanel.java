/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.cs321.core.Player;
import com.cs321.gui.GUIState.PanelName;

/**
 *
 * @author Hasna
 */
public class ChooseGametypePanel extends UpdateableJPanel {

    private static enum Tab {
        FreeForAll, Teams
    }

    private GUIState state;

    private Tab currentTab = Tab.FreeForAll;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<ArrayList<Player>> teams = new ArrayList<>();

    /**
     * Creates new form ChooseGametypePanel
     */
    public ChooseGametypePanel(GUIState state) {
        initComponents();

        this.state = state;
    }

    /**
     * Updates the components to reflect the current state
     */
    @Override
    public void updateComponents() {
        regenerateFreeForAllPanel();
        regenerateTeamsPanel();
    }

    /**
     * Regenerates the Free For All panel
     */
    private void regenerateFreeForAllPanel() {
        FreeForAllBodyPanel.removeAll();

        // If there are less than 2 players, add 2 buttons
        if (players.size() < 2) {
            FreeForAllBodyPanel.add(generateFreeForAllButton(0));
            FreeForAllBodyPanel.add(new JLabel("vs"));
            FreeForAllBodyPanel.add(generateFreeForAllButton(1));
        // Otherwise, add a button for each player and one more
        } else {
            for (int playerIndex = 0; playerIndex < players.size(); playerIndex++) {
                FreeForAllBodyPanel.add(generateFreeForAllButton(playerIndex));
                FreeForAllBodyPanel.add(new JLabel("vs"));
            }
            FreeForAllBodyPanel.add(generateFreeForAllButton(players.size()));
        }

        FreeForAllBodyPanel.revalidate();
        FreeForAllBodyPanel.repaint();
    }

    /**
     * Generates a button for the Free For All panel
     * 
     * @param playerIndex The index of the player to get the name from
     * @return The button
     */
    private JButton generateFreeForAllButton(int playerIndex) {
        JButton button = new JButton("Add Player");
        if (players.size() > playerIndex) {
            button.setText(players.get(playerIndex).getName());
        }
        button.addActionListener(generateFreeForAllActionListener(playerIndex));
        return button;
    }

    /**
     * Generates an action listener for the Free For All panel
     * 
     * @param playerIndex The index of the player to edit
     * @return The action listener
     */
    private ActionListener generateFreeForAllActionListener(final int playerIndex) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String playerName = JOptionPane.showInputDialog("Enter player name");
                if (playerName.isEmpty()) {
                    if (players.size() > playerIndex) {
                        players.remove(playerIndex);
                    }
                } else {
                    if (players.size() > playerIndex) {
                        players.set(playerIndex, new Player(playerName));
                    } else {
                        players.add(new Player(playerName));
                    }
                }
                regenerateFreeForAllPanel();
            }

        };
    }

    /**
     * Regenerates the Teams panel
     */
    private void regenerateTeamsPanel() {
        TeamsBodyPanel.removeAll();

        // If there are less than 2 teams, add 2 team buttons
        if (teams.size() < 2) {
            addTeamButtons(0);
            TeamsBodyPanel.add(generateTeamVsLabel());
            addTeamButtons(1);
        // Otherwise, add team buttons for each team and one more
        } else {
            for (int teamIndex = 0; teamIndex < teams.size(); teamIndex++) {
                addTeamButtons(teamIndex);
                TeamsBodyPanel.add(generateTeamVsLabel());
            }
            addTeamButtons(teams.size());
        }

        TeamsBodyPanel.revalidate();
        TeamsBodyPanel.repaint();
    }

    /**
     * Generates and adds buttons for the Teams panel
     * 
     * @param teamIndex The index of the team to generate buttons for
     */
    private void addTeamButtons(int teamIndex) {
        // If the team doesn't exist, add 2 buttons
        if (teams.size() <= teamIndex) {
            TeamsBodyPanel.add(generateTeamButton(teams.size(), 0));
            TeamsBodyPanel.add(new JLabel("and"));
            TeamsBodyPanel.add(generateTeamButton(teams.size(), 1));
        // Otherwise, follow the same logic as the Free For All panel
        } else {
            ArrayList<Player> team = teams.get(teamIndex);

            // If the team has less than 2 players, add 2 buttons
            if (team.size() < 2) {
                TeamsBodyPanel.add(generateTeamButton(teamIndex, 0));
                TeamsBodyPanel.add(new JLabel("and"));
                TeamsBodyPanel.add(generateTeamButton(teamIndex, 1));
            // Otherwise, add a button for each player and one more
            } else {
                for (int playerIndex = 0; playerIndex < team.size(); playerIndex++) {
                    TeamsBodyPanel.add(generateTeamButton(teamIndex, playerIndex));
                    TeamsBodyPanel.add(new JLabel("and"));
                }
                TeamsBodyPanel.add(generateTeamButton(teamIndex, team.size()));
            }
        }
    }

    /**
     * Generates a button for the Teams panel
     * 
     * @param teamIndex The index of the team to generate buttons for
     * @param playerIndex The index of the player to get the name from
     * @return The button
     */
    private JButton generateTeamButton(int teamIndex, int playerIndex) {
        JButton button = new JButton("Add Player");
        button.addActionListener(generateTeamActionListener(teamIndex, playerIndex));

        // If the team exists ...
        if (teams.size() > teamIndex) {
            ArrayList<Player> team = teams.get(teamIndex);

            // ... and the player exists, set the button text to the player's name
            if (team.size() > playerIndex) {
                button.setText(team.get(playerIndex).getName());
            }
        }

        return button;
    }

    /**
     * Generates an action listener for the Teams panel
     * 
     * @param teamIndex The index of the team to edit
     * @param playerIndex The index of the player to edit
     * @return The action listener
     */
    private ActionListener generateTeamActionListener(final int teamIndex, final int playerIndex) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String playerName = JOptionPane.showInputDialog("Enter player name");
                // If the player name is empty ...
                if (playerName.isEmpty()) {
                    // ... and the team exists ...
                    if (teams.size() > teamIndex) {
                        ArrayList<Player> team = teams.get(teamIndex);
                        // ... and the player exists, remove the player
                        if (team.size() > playerIndex) {
                            team.remove(playerIndex);
                        }
                        // If the team becomes empty, remove the team
                        if (team.isEmpty()) {
                            teams.remove(teamIndex);
                        }
                    }
                } else {
                    // If the team exists ...
                    if (teams.size() > teamIndex) {
                        ArrayList<Player> team = teams.get(teamIndex);
                        // ... and the player exists, set the player's name
                        if (team.size() > playerIndex) {
                            team.set(playerIndex, new Player(playerName));
                        // ... and the player doesn't exist, add the player
                        } else {
                            team.add(new Player(playerName));
                        }
                    // If the team doesn't exist, add the team
                    } else {
                        ArrayList<Player> team = new ArrayList<>();
                        team.add(new Player(playerName));
                        teams.add(team);
                    }
                }
                regenerateTeamsPanel();
            }

        };
    }

    /**
     * Generates a label for the Teams panel
     * 
     * @return The label
     */
    private JLabel generateTeamVsLabel() {
        JLabel label = new JLabel("vs");
        label.setFont(getFont().deriveFont(Font.BOLD, 24));
        return label;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        HeaderPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TitleLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        BodyPanel = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        GametypesTabbedPanel = new javax.swing.JTabbedPane();
        FreeForAllTabPanel = new javax.swing.JPanel();
        FreeForAllPanel = new javax.swing.JPanel();
        FreeForAllHeaderPanel = new javax.swing.JPanel();
        FreeForAllTipLabel = new javax.swing.JLabel();
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        FreeForAllBodyPanel = new javax.swing.JPanel();
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        FreeForAllFooterPanel = new javax.swing.JPanel();
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        FreeForAllClearButton = new javax.swing.JToggleButton();
        TeamsTabPanel = new javax.swing.JPanel();
        TeamsPanel = new javax.swing.JPanel();
        TeamsHeaderPanel = new javax.swing.JPanel();
        TeamsTipLabel = new javax.swing.JLabel();
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        TeamsBodyPanel = new javax.swing.JPanel();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        TeamsFooterPanel = new javax.swing.JPanel();
        filler25 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TeamsClearButton = new javax.swing.JToggleButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        FooterPanel = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        QuitToMainMenuButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        NextButton = new javax.swing.JButton();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));

        setMinimumSize(new java.awt.Dimension(1, 1));
        setPreferredSize(new java.awt.Dimension(1, 1));
        setLayout(new java.awt.GridBagLayout());

        HeaderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setLayout(new javax.swing.BoxLayout(HeaderPanel, javax.swing.BoxLayout.X_AXIS));
        HeaderPanel.add(filler1);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TitleLabel.setText("Choose Gametype");
        HeaderPanel.add(TitleLabel);
        HeaderPanel.add(filler2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(HeaderPanel, gridBagConstraints);

        BodyPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        BodyPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        BodyPanel.setLayout(new javax.swing.BoxLayout(BodyPanel, javax.swing.BoxLayout.X_AXIS));
        BodyPanel.add(filler5);

        GametypesTabbedPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        GametypesTabbedPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        GametypesTabbedPanel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GametypesTabbedPanelStateChanged(evt);
            }
        });

        FreeForAllTabPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        FreeForAllTabPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        FreeForAllTabPanel.setLayout(new java.awt.GridBagLayout());

        FreeForAllPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        FreeForAllPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        FreeForAllPanel.setLayout(new javax.swing.BoxLayout(FreeForAllPanel, javax.swing.BoxLayout.Y_AXIS));

        FreeForAllHeaderPanel.setPreferredSize(new java.awt.Dimension(37, 16));
        FreeForAllHeaderPanel.setLayout(new javax.swing.BoxLayout(FreeForAllHeaderPanel, javax.swing.BoxLayout.X_AXIS));

        FreeForAllTipLabel.setText("Choosing players will add more players");
        FreeForAllHeaderPanel.add(FreeForAllTipLabel);
        FreeForAllHeaderPanel.add(filler13);

        FreeForAllPanel.add(FreeForAllHeaderPanel);
        FreeForAllPanel.add(filler20);
        FreeForAllPanel.add(FreeForAllBodyPanel);
        FreeForAllPanel.add(filler21);

        FreeForAllFooterPanel.setPreferredSize(new java.awt.Dimension(37, 16));
        FreeForAllFooterPanel.setLayout(new javax.swing.BoxLayout(FreeForAllFooterPanel, javax.swing.BoxLayout.X_AXIS));
        FreeForAllFooterPanel.add(filler22);

        FreeForAllClearButton.setText("Clear");
        FreeForAllClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FreeForAllClearButtonActionPerformed(evt);
            }
        });
        FreeForAllFooterPanel.add(FreeForAllClearButton);

        FreeForAllPanel.add(FreeForAllFooterPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        FreeForAllTabPanel.add(FreeForAllPanel, gridBagConstraints);

        GametypesTabbedPanel.addTab("Free For All", FreeForAllTabPanel);

        TeamsTabPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        TeamsTabPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        TeamsTabPanel.setLayout(new java.awt.GridBagLayout());

        TeamsPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        TeamsPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        TeamsPanel.setLayout(new javax.swing.BoxLayout(TeamsPanel, javax.swing.BoxLayout.Y_AXIS));

        TeamsHeaderPanel.setPreferredSize(new java.awt.Dimension(37, 16));
        TeamsHeaderPanel.setLayout(new javax.swing.BoxLayout(TeamsHeaderPanel, javax.swing.BoxLayout.X_AXIS));

        TeamsTipLabel.setText("Choosing teams and players will add more teams and players");
        TeamsHeaderPanel.add(TeamsTipLabel);
        TeamsHeaderPanel.add(filler19);

        TeamsPanel.add(TeamsHeaderPanel);
        TeamsPanel.add(filler23);
        TeamsPanel.add(TeamsBodyPanel);
        TeamsPanel.add(filler24);

        TeamsFooterPanel.setPreferredSize(new java.awt.Dimension(37, 16));
        TeamsFooterPanel.setLayout(new javax.swing.BoxLayout(TeamsFooterPanel, javax.swing.BoxLayout.X_AXIS));
        TeamsFooterPanel.add(filler25);

        TeamsClearButton.setText("Clear");
        TeamsClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeamsClearButtonActionPerformed(evt);
            }
        });
        TeamsFooterPanel.add(TeamsClearButton);

        TeamsPanel.add(TeamsFooterPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 8, 8);
        TeamsTabPanel.add(TeamsPanel, gridBagConstraints);

        GametypesTabbedPanel.addTab("Teams", TeamsTabPanel);

        BodyPanel.add(GametypesTabbedPanel);
        BodyPanel.add(filler6);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 3.0;
        add(BodyPanel, gridBagConstraints);

        FooterPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        FooterPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        FooterPanel.setLayout(new javax.swing.BoxLayout(FooterPanel, javax.swing.BoxLayout.X_AXIS));
        FooterPanel.add(filler3);

        QuitToMainMenuButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        QuitToMainMenuButton.setText("Quit to Main Menu");
        QuitToMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitToMainMenuButtonActionPerformed(evt);
            }
        });
        FooterPanel.add(QuitToMainMenuButton);
        FooterPanel.add(filler4);

        NextButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });
        FooterPanel.add(NextButton);
        FooterPanel.add(filler9);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(FooterPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void QuitToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitToMainMenuButtonActionPerformed
        state.panels.get(PanelName.MainMenuPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.MainMenuPanel.toString());
        
    }//GEN-LAST:event_QuitToMainMenuButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        state.panels.get(PanelName.Dart_2).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.Dart_2.toString());
    }//GEN-LAST:event_NextButtonActionPerformed

    private void FreeForAllClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreeForAllClearButtonActionPerformed
        players.clear();
        updateComponents();
    }//GEN-LAST:event_FreeForAllClearButtonActionPerformed

    private void GametypesTabbedPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GametypesTabbedPanelStateChanged
        int index = GametypesTabbedPanel.getSelectedIndex();
        switch (index) {
            case 0:
                if (currentTab != Tab.FreeForAll) {
                    players.clear();
                }
                currentTab = Tab.FreeForAll;
                break;
            case 1:
                if (currentTab != Tab.Teams) {
                    teams.clear();
                }
                currentTab = Tab.Teams;
                break;
        }
        updateComponents();
    }//GEN-LAST:event_GametypesTabbedPanelStateChanged

    private void TeamsClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamsClearButtonActionPerformed
        teams.clear();
        updateComponents();
    }//GEN-LAST:event_TeamsClearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel FreeForAllBodyPanel;
    private javax.swing.JToggleButton FreeForAllClearButton;
    private javax.swing.JPanel FreeForAllFooterPanel;
    private javax.swing.JPanel FreeForAllHeaderPanel;
    private javax.swing.JPanel FreeForAllPanel;
    private javax.swing.JPanel FreeForAllTabPanel;
    private javax.swing.JLabel FreeForAllTipLabel;
    private javax.swing.JTabbedPane GametypesTabbedPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton QuitToMainMenuButton;
    private javax.swing.JPanel TeamsBodyPanel;
    private javax.swing.JToggleButton TeamsClearButton;
    private javax.swing.JPanel TeamsFooterPanel;
    private javax.swing.JPanel TeamsHeaderPanel;
    private javax.swing.JPanel TeamsPanel;
    private javax.swing.JPanel TeamsTabPanel;
    private javax.swing.JLabel TeamsTipLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler23;
    private javax.swing.Box.Filler filler24;
    private javax.swing.Box.Filler filler25;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler9;
    // End of variables declaration//GEN-END:variables
}
