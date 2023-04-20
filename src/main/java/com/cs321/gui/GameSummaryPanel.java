/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cs321.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Panel;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cs321.core.Team;
import com.cs321.gui.GUIState.PanelName;

/**
 *
 * @author Hasna
 */
public class GameSummaryPanel extends UpdateableJPanel {

    // The global GUI state
    private GUIState state;

    /**
     * Creates new form GameSummaryPanel
     */
    public GameSummaryPanel(GUIState state) {
        initComponents();

        this.state = state;
    }

    /**
     * Updates the components to reflect the current state
     */
    @Override
    public void updateComponents() {
        SummaryListPanel.removeAll();

        Team[] teams = state.gameManager.getTeamsManager().getTeams();
        Arrays.sort(teams, (Team team1, Team team2) ->
            Integer.compare(
                state.gameManager.getRoundsManager().getTeamTotalScore(team2),
                state.gameManager.getRoundsManager().getTeamTotalScore(team1)
            )
        );

        for (Team team : teams) {
            boolean isWinner = state.gameManager.getWinnerTeam() == team;

            if (state.chosenGametype == GUIState.Gametype.FreeForAll) {
                SummaryListPanel.add(generateFreeForAllSummaryPanel(team, isWinner));
            } else if (state.chosenGametype == GUIState.Gametype.Teams) {
                SummaryListPanel.add(generateTeamsSummaryPanel(team, isWinner));
            }
        }
    }

    /**
     * Generates a summary panel for a team in a free-for-all game
     * 
     * @param team The team to generate the summary panel for
     * @return The summary panel
     */
    private JPanel generateFreeForAllSummaryPanel(Team team, boolean winner) {
        GridBagConstraints gridBagConstraints = null;
        JPanel summaryPanel = new JPanel();
        summaryPanel.setMinimumSize(new java.awt.Dimension(148, 60));
        summaryPanel.setPreferredSize(new java.awt.Dimension(148, 60));
        summaryPanel.setLayout(new java.awt.GridBagLayout());

        JLabel playerNameLabel = new JLabel();
        playerNameLabel.setText("Player's Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 4);
        summaryPanel.add(playerNameLabel, gridBagConstraints);

        JLabel currentPlayerNameLabel = new JLabel();
        currentPlayerNameLabel.setText(team.getPlayers()[0].getName());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 0, 8);
        summaryPanel.add(currentPlayerNameLabel, gridBagConstraints);

        JLabel playerScoreLabel = new JLabel();
        playerScoreLabel.setText("Player's Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 4);
        summaryPanel.add(playerScoreLabel, gridBagConstraints);

        JLabel currentPlayerScoreLabel = new JLabel();
        currentPlayerScoreLabel.setText(Integer.toString(state.gameManager.getRoundsManager().getTeamTotalScore(team)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 8, 8);
        summaryPanel.add(currentPlayerScoreLabel, gridBagConstraints);

        if (winner) {
            playerNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            currentPlayerNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            playerScoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            currentPlayerScoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        }

        return summaryPanel;
    }

    /**
     * Generates a summary panel for a team in a team game
     * 
     * @param team The team to generate the summary panel for
     * @param winner Whether the team is the winner
     * @return The summary panel
     */
    private JPanel generateTeamsSummaryPanel(Team team, boolean winner) {
        GridBagConstraints gridBagConstraints = null;
        JPanel summaryPanel = new JPanel();
        summaryPanel.setMinimumSize(new java.awt.Dimension(148, 60));
        summaryPanel.setPreferredSize(new java.awt.Dimension(148, 60));
        summaryPanel.setLayout(new java.awt.GridBagLayout());

        JLabel teamNameLabel = new JLabel();
        teamNameLabel.setText("Team's Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 4);
        summaryPanel.add(teamNameLabel, gridBagConstraints);

        JLabel currentTeamNameLabel = new JLabel();
        currentTeamNameLabel.setText(team.getName());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 0, 8);
        summaryPanel.add(currentTeamNameLabel, gridBagConstraints);

        JLabel teamScoreLabel = new JLabel();
        teamScoreLabel.setText("Player's Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 4);
        summaryPanel.add(teamScoreLabel, gridBagConstraints);

        JLabel currentTeamScoreLabel = new JLabel();
        currentTeamScoreLabel.setText(Integer.toString(state.gameManager.getRoundsManager().getTeamTotalScore(team)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 8, 8);
        summaryPanel.add(currentTeamScoreLabel, gridBagConstraints);

        if (winner) {
            teamNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            currentTeamNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            teamScoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            currentTeamScoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        }

        return summaryPanel;
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

        SummaryPanel = new javax.swing.JPanel();
        ParticipantNameLabel = new javax.swing.JLabel();
        CurrentParticipantNameLabel = new javax.swing.JLabel();
        ParticipantScoreLabel = new javax.swing.JLabel();
        CurrentParticipantScoreLabel = new javax.swing.JLabel();
        HeaderPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        TitleLabel = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        BodyPanel = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        SummaryScrollPane = new javax.swing.JScrollPane();
        SummaryListPanel = new javax.swing.JPanel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        FooterPanel = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        GoToMainMenuButton = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));

        SummaryPanel.setMinimumSize(new java.awt.Dimension(148, 60));
        SummaryPanel.setPreferredSize(new java.awt.Dimension(148, 60));
        SummaryPanel.setLayout(new java.awt.GridBagLayout());

        ParticipantNameLabel.setText("Player's Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 8, 0, 4);
        SummaryPanel.add(ParticipantNameLabel, gridBagConstraints);

        CurrentParticipantNameLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 4, 0, 8);
        SummaryPanel.add(CurrentParticipantNameLabel, gridBagConstraints);

        ParticipantScoreLabel.setText("Player's Score:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 8, 4);
        SummaryPanel.add(ParticipantScoreLabel, gridBagConstraints);

        CurrentParticipantScoreLabel.setText("----");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 8, 8);
        SummaryPanel.add(CurrentParticipantScoreLabel, gridBagConstraints);

        setMinimumSize(new java.awt.Dimension(1, 1));
        setPreferredSize(new java.awt.Dimension(1, 1));
        setLayout(new java.awt.GridBagLayout());

        HeaderPanel.setMaximumSize(new java.awt.Dimension(65744, 65744));
        HeaderPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        HeaderPanel.setLayout(new javax.swing.BoxLayout(HeaderPanel, javax.swing.BoxLayout.X_AXIS));
        HeaderPanel.add(filler1);

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TitleLabel.setText("Game Summary");
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

        SummaryListPanel.setLayout(new java.awt.GridLayout(0, 1));
        SummaryScrollPane.setViewportView(SummaryListPanel);

        BodyPanel.add(SummaryScrollPane);
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
        FooterPanel.add(filler4);

        GoToMainMenuButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        GoToMainMenuButton.setText("Go To Main Menu");
        GoToMainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoToMainMenuButtonActionPerformed(evt);
            }
        });
        FooterPanel.add(GoToMainMenuButton);
        FooterPanel.add(filler3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(FooterPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void GoToMainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoToMainMenuButtonActionPerformed
        state.panels.get(PanelName.MainMenuPanel).updateComponents();
        state.contentPaneCardLayout.show(state.contentPane, PanelName.MainMenuPanel.toString());
    }//GEN-LAST:event_GoToMainMenuButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JLabel CurrentParticipantNameLabel;
    private javax.swing.JLabel CurrentParticipantScoreLabel;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JButton GoToMainMenuButton;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JLabel ParticipantNameLabel;
    private javax.swing.JLabel ParticipantScoreLabel;
    private javax.swing.JPanel SummaryListPanel;
    private javax.swing.JPanel SummaryPanel;
    private javax.swing.JScrollPane SummaryScrollPane;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    // End of variables declaration//GEN-END:variables
}
