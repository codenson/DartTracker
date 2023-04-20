/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import com.cs321.core.GameManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.cs321.core.Player;
import com.cs321.gui.GUIState.Gametype;
import com.cs321.gui.GUIState.PanelName;

/**
 *
 * @author Hasna
 */
public class ChooseGametypePanel extends UpdateableJPanel {

    // The global GUI state
    private GUIState state;

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
        GametypesTabbedPanel.setSelectedIndex(state.chosenGametype.ordinal());
        regenerateFreeForAllPanel();
        regenerateTeamsPanel();
        if (state.chooseGametypeGameConfiguration != null) {
            FreeForAllGameConfigurationButton.setText(state.chooseGametypeGameConfiguration.getName());
            TeamsGameConfigurationButton.setText(state.chooseGametypeGameConfiguration.getName());
        } else {
            FreeForAllGameConfigurationButton.setText("Choose...");
            TeamsGameConfigurationButton.setText("Choose...");
        }
        PlayButton.setEnabled(state.canGenerateGameManager());
    }

    /**
     * Regenerates the Free For All panel
     */
    private void regenerateFreeForAllPanel() {
        FreeForAllBodyPanel.removeAll();

        // If there are less than 2 players, add 2 buttons
        if (state.chooseGametypePlayers.size() < 2) {
            FreeForAllBodyPanel.add(generateFreeForAllButton(0));
            FreeForAllBodyPanel.add(new JLabel("vs"));
            FreeForAllBodyPanel.add(generateFreeForAllButton(1));
        // Otherwise, add a button for each player and one more
        } else {
            for (int playerIndex = 0; playerIndex < state.chooseGametypePlayers.size(); playerIndex++) {
                FreeForAllBodyPanel.add(generateFreeForAllButton(playerIndex));
                FreeForAllBodyPanel.add(new JLabel("vs"));
            }
            FreeForAllBodyPanel.add(generateFreeForAllButton(state.chooseGametypePlayers.size()));
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
        if (state.chooseGametypePlayers.size() > playerIndex) {
            button.setText(state.chooseGametypePlayers.get(playerIndex).getName());
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
                state.chooseTeamIndex = -1;
                state.choosePlayerIndex = playerIndex;
                state.panels.get(PanelName.ChoosePlayersPanel).updateComponents();
                state.contentPaneCardLayout.show(state.contentPane, PanelName.ChoosePlayersPanel.toString());
            }

        };
    }

    /**
     * Regenerates the Teams panel
     */
    private void regenerateTeamsPanel() {
        TeamsBodyPanel.removeAll();

        // If there are less than 2 teams, add 2 team buttons
        if (state.chooseGametypeTeams.size() < 2) {
            addTeamButtons(0);
            TeamsBodyPanel.add(generateTeamVsLabel());
            addTeamButtons(1);
        // Otherwise, add team buttons for each team and one more
        } else {
            for (int teamIndex = 0; teamIndex < state.chooseGametypeTeams.size(); teamIndex++) {
                addTeamButtons(teamIndex);
                TeamsBodyPanel.add(generateTeamVsLabel());
            }
            addTeamButtons(state.chooseGametypeTeams.size());
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
        if (state.chooseGametypeTeams.size() <= teamIndex) {
            TeamsBodyPanel.add(generateTeamButton(state.chooseGametypeTeams.size(), 0));
            TeamsBodyPanel.add(new JLabel("and"));
            TeamsBodyPanel.add(generateTeamButton(state.chooseGametypeTeams.size(), 1));
        // Otherwise, follow the same logic as the Free For All panel
        } else {
            ArrayList<Player> team = state.chooseGametypeTeams.get(teamIndex);

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
        if (state.chooseGametypeTeams.size() > teamIndex) {
            ArrayList<Player> team = state.chooseGametypeTeams.get(teamIndex);

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
                state.chooseTeamIndex = teamIndex;
                state.choosePlayerIndex = playerIndex;
                state.panels.get(PanelName.ChoosePlayersPanel).updateComponents();
                state.contentPaneCardLayout.show(state.contentPane, PanelName.ChoosePlayersPanel.toString());
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
        FreeForAllGameConfigurationLabel = new javax.swing.JLabel();
        FreeForAllGameConfigurationButton = new javax.swing.JButton();
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
        TeamsGameConfigurationLabel = new javax.swing.JLabel();
        TeamsGameConfigurationButton = new javax.swing.JButton();
        filler25 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TeamsClearButton = new javax.swing.JToggleButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        FooterPanel = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        QuitToMainMenuButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        PlayButton = new javax.swing.JButton();
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

        FreeForAllHeaderPanel.setMinimumSize(new java.awt.Dimension(37, 16));
        FreeForAllHeaderPanel.setPreferredSize(new java.awt.Dimension(37, 16));
        FreeForAllHeaderPanel.setLayout(new javax.swing.BoxLayout(FreeForAllHeaderPanel, javax.swing.BoxLayout.X_AXIS));

        FreeForAllTipLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        FreeForAllTipLabel.setText("Choosing players will add more players / Turns are determined by player order");
        FreeForAllHeaderPanel.add(FreeForAllTipLabel);
        FreeForAllHeaderPanel.add(filler13);

        FreeForAllPanel.add(FreeForAllHeaderPanel);
        FreeForAllPanel.add(filler20);
        FreeForAllPanel.add(FreeForAllBodyPanel);
        FreeForAllPanel.add(filler21);

        FreeForAllFooterPanel.setMinimumSize(new java.awt.Dimension(37, 16));
        FreeForAllFooterPanel.setPreferredSize(new java.awt.Dimension(37, 16));
        FreeForAllFooterPanel.setLayout(new javax.swing.BoxLayout(FreeForAllFooterPanel, javax.swing.BoxLayout.X_AXIS));

        FreeForAllGameConfigurationLabel.setText("Gamemode:    ");
        FreeForAllFooterPanel.add(FreeForAllGameConfigurationLabel);

        FreeForAllGameConfigurationButton.setText("Choose...");
        FreeForAllGameConfigurationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FreeForAllGameConfigurationButtonActionPerformed(evt);
            }
        });
        FreeForAllFooterPanel.add(FreeForAllGameConfigurationButton);
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

        TeamsTipLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        TeamsTipLabel.setText("Choosing teams and players will add more teams and players / Turns are determined by team and player order");
        TeamsHeaderPanel.add(TeamsTipLabel);
        TeamsHeaderPanel.add(filler19);

        TeamsPanel.add(TeamsHeaderPanel);
        TeamsPanel.add(filler23);
        TeamsPanel.add(TeamsBodyPanel);
        TeamsPanel.add(filler24);

        TeamsFooterPanel.setPreferredSize(new java.awt.Dimension(37, 16));
        TeamsFooterPanel.setLayout(new javax.swing.BoxLayout(TeamsFooterPanel, javax.swing.BoxLayout.X_AXIS));

        TeamsGameConfigurationLabel.setText("Gamemode:    ");
        TeamsFooterPanel.add(TeamsGameConfigurationLabel);

        TeamsGameConfigurationButton.setText("Choose...");
        TeamsGameConfigurationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeamsGameConfigurationButtonActionPerformed(evt);
            }
        });
        TeamsFooterPanel.add(TeamsGameConfigurationButton);
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

        PlayButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        PlayButton.setText("Play");
        PlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });
        FooterPanel.add(PlayButton);
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
        state.clearChooseGametypeChoices();
        state.panels.get(PanelName.MainMenuPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.MainMenuPanel.toString());
    }//GEN-LAST:event_QuitToMainMenuButtonActionPerformed

    private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButtonActionPerformed
        state.gameManager = state.generateGameManager();
        state.clearChooseGametypeChoices();
        state.panels.get(PanelName.PlayPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.PlayPanel.toString());
    }//GEN-LAST:event_PlayButtonActionPerformed

    private void FreeForAllClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreeForAllClearButtonActionPerformed
        state.clearChooseGametypeChoices();
        updateComponents();
    }//GEN-LAST:event_FreeForAllClearButtonActionPerformed

    private void GametypesTabbedPanelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GametypesTabbedPanelStateChanged
        // Weird bug where this is called during initialization before state is set
        if (state == null) {
            return;
        }

        int index = GametypesTabbedPanel.getSelectedIndex();
        switch (index) {
            case 0:
                if (state.chosenGametype != Gametype.FreeForAll) {
                    state.clearChooseGametypeChoices();
                }
                state.chosenGametype = Gametype.FreeForAll;
                break;
            case 1:
                if (state.chosenGametype != Gametype.Teams) {
                    state.clearChooseGametypeChoices();
                }
                state.chosenGametype = Gametype.Teams;
                break;
        }
        updateComponents();
    }//GEN-LAST:event_GametypesTabbedPanelStateChanged

    private void TeamsClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamsClearButtonActionPerformed
        state.clearChooseGametypeChoices();
        updateComponents();
    }//GEN-LAST:event_TeamsClearButtonActionPerformed

    private void FreeForAllGameConfigurationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreeForAllGameConfigurationButtonActionPerformed
        state.panels.get(PanelName.ChooseGameConfigurationPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.ChooseGameConfigurationPanel.toString());
    }//GEN-LAST:event_FreeForAllGameConfigurationButtonActionPerformed

    private void TeamsGameConfigurationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamsGameConfigurationButtonActionPerformed
        state.panels.get(PanelName.ChooseGameConfigurationPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.ChooseGameConfigurationPanel.toString());
    }//GEN-LAST:event_TeamsGameConfigurationButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel FreeForAllBodyPanel;
    private javax.swing.JToggleButton FreeForAllClearButton;
    private javax.swing.JPanel FreeForAllFooterPanel;
    private javax.swing.JButton FreeForAllGameConfigurationButton;
    private javax.swing.JLabel FreeForAllGameConfigurationLabel;
    private javax.swing.JPanel FreeForAllHeaderPanel;
    private javax.swing.JPanel FreeForAllPanel;
    private javax.swing.JPanel FreeForAllTabPanel;
    private javax.swing.JLabel FreeForAllTipLabel;
    private javax.swing.JTabbedPane GametypesTabbedPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JButton PlayButton;
    private javax.swing.JButton QuitToMainMenuButton;
    private javax.swing.JPanel TeamsBodyPanel;
    private javax.swing.JToggleButton TeamsClearButton;
    private javax.swing.JPanel TeamsFooterPanel;
    private javax.swing.JButton TeamsGameConfigurationButton;
    private javax.swing.JLabel TeamsGameConfigurationLabel;
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
